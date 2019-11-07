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

        ZipCodesItem items = new ZipCodesItem();
        List<ZipCodesItem> list = new ArrayList<>();

        String format = "json";
        String units = "mile";

        Client client = ClientBuilder.newClient();
        WebTarget target =

                client.target("https://www.zipcodeapi.com/rest/" + apiKey
                        + "/radius." + format + "/"+ zipCode + "/" + raidus + "/" + units + "?minimal");

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

        //return list of zipCodeItems
        return list;
    }

}
