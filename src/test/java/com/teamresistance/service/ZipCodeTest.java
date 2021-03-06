package com.teamresistance.service;

import com.teamresistance.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;

class ZipCodeTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao dao;

    @BeforeEach
    void setUp() {
        //dao = new GenericDao(Favorites.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getZipCodes() throws Exception {
        ZipCode newZipCode = new ZipCode();
        List<ZipCodesItem> zipCodesItem = newZipCode.getZipCodes();

        System.out.println(zipCodesItem.toString());
    }
}
