package com.teamresistance.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamresistance.entity.ParkingLot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class FavoritesService {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @param zipCode zipCode to pass in
     * @param radius radius to pass in
     * @return parkingLotInfList
     * @throws JsonProcessingException
     */
    public List<ParkingLot> getParkingLotInfo(int zipCode, int radius) throws JsonProcessingException {

        String apiKey = "C6duubd0kQKxJEOmFShO87kDSvVP6U2gpTd65fh7wMBironF9up5xyisynI21Ep9";

        //create local variables
        ZipCodesItem items = new ZipCodesItem();
        List<ZipCodesItem> list = new ArrayList<>();

        String format = "json";
        String units = "mile";

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://www.zipcodeapi.com/rest/" + apiKey
                        + "/radius." + format + "/"+ zipCode + "/" + radius + "/" + units + "?minimal");

        //specify the type of data to get back and get the response
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        //parse response
        String[] tokens = response.split("\\t|,|;|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/|\"");

        //grab zipCodes beginning at [i]=7,10,13...and add to list
        for (int i = 7; i < tokens.length; i += 3) {
            ZipCodesItem item = new ZipCodesItem();
            item.setZipCode(tokens[i]);
            list.add(item);
        }

        //pass list of zipcode items to get parkinglot information
        List<ParkingLot> parkingLotInfoList = getParkingLotInfo(list);

        //return list of parkinglot info
        return parkingLotInfoList;
    }

    /**
     * this method returns a list of parkinglots based on zipcodes
     * @param list list of zipcodes
     * @return parkingLotInfo list
     */
    public List<ParkingLot> getParkingLotInfo(List<ZipCodesItem> list) {

        List<ParkingLot> parkingInfoList = new ArrayList<>();

        String zip = "";

        for (ZipCodesItem zipCode : list) {
            zip += zipCode.getZipCode() + ",";
        }

        try {

            Client client = ClientBuilder.newClient();
            WebTarget target =
                    client.target("http://3.130.227.98:8081/parkinglots/" + zip + "");

            //specify the type of data to get back and get the response
            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            System.out.println(response);

            //map response into a class with jackson library
            ObjectMapper mapper = new ObjectMapper();

            parkingInfoList = mapper.readValue(response, new TypeReference<List<ParkingLot>>() {});


        } catch (Exception e) {
            logger.error("Unable to map object");
        }

        return parkingInfoList;
    }

}
