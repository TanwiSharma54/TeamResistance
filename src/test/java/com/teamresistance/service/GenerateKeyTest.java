package com.teamresistance.service;

import com.teamresistance.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateKeyTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao dao;

    @BeforeEach
    void setUp() {
        //dao = new GenericDao(Favorites.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAPIKey() throws Exception {
        GenerateKey newKeyService = new GenerateKey();
        String myKey =  newKeyService.getRandomKey();
        System.out.println(myKey);
    }
}
