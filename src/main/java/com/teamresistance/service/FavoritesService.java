package com.teamresistance.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamresistance.entity.Favorites;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class FavoritesService {

    public List<Favorites> getParkingLotInfo(int zipCode, int radius) throws JsonProcessingException {

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

        //grab zipCodes beginning at [i]=7,10,13...
        for (int i = 7; i < tokens.length; i += 3) {
            ZipCodesItem item = new ZipCodesItem();
            item.setZipCode(tokens[i]);
            list.add(item);
        }


        List<Favorites> places = getFavorites(list);

        //return list of zipCodeItems
        return places;
    }

    public List<Favorites> getFavorites(List<ZipCodesItem> list) {

        List<Favorites> places = new ArrayList<>();

        String zip = "";

        for (ZipCodesItem zipCode : list) {
            zip += zipCode.getZipCode() + ",";
        }



        System.out.println(zip);

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://3.130.227.98:8081/parkinglots/" + zip + "");

        //specify the type of data to get back and get the response
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        System.out.println(response);

        return places;
    }

}
