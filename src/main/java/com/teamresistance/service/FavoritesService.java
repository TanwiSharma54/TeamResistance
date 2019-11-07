package com.teamresistance.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class FavoritesService {

    public List<ZipCodesItem> getParkingLotInfo(int zipCode, int radius) throws JsonProcessingException {

        String apiKey = "C6duubd0kQKxJEOmFShO87kDSvVP6U2gpTd65fh7wMBironF9up5xyisynI21Ep9";
        String format = "json";

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://www.zipcodeapi.com/rest/"+ apiKey +"/"+radius+".csv/08057/5/miles?minimal");
                //client.target("https://www.zipcodeapi.com/rest/" + apiKey
                //        + "/radius." + format + "/"+ zipCode + "/" + radius + "/" + units + "");

        //https://www.zipcodeapi.com/rest/<api_key>/radius.<format>/<zip_code>/<distance>/<units>

        //if only want zip returned
        //https://www.zipcodeapi.com/rest/<api_key>/radius.csv/08057/5/miles?minimal

        //specify the type of data to get back
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        System.out.println(response);

        //map response into a class with jackson library
        ObjectMapper mapper = new ObjectMapper(); //create mapper to map

        //create a list of ZipCode objects
        ZipCode list = new ZipCode();

        List<ZipCodesItem> zipCodeItems = mapper.readValue(response, new TypeReference<List<ZipCodesItem>>() {});

        return zipCodeItems;
    }

}
