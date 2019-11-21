package com.teamresistance.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamresistance.entity.ParkingLot;
import com.teamresistance.entity.Key;
import com.teamresistance.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class GenerateKey {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * @return 20-byte random Key
     */
    public String getRandomKey() {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(20);

        for (int i = 0; i < 20; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        //Save the generated key for later comparison
        GenericDao keyDao = new GenericDao(Key.class);
        Key newKey = new Key();
        newKey.setAPIKey(sb.toString());
        int id = keyDao.insert(newKey);

        return sb.toString();
    }
}
