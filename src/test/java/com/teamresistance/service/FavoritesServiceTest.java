package com.teamresistance.service;

import com.teamresistance.entity.Favorites;
import com.teamresistance.entity.ParkingLot;
import com.teamresistance.entity.User;
import com.teamresistance.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FavoritesServiceTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao dao;

    @BeforeEach
    void setUp() {
        dao = new GenericDao(Favorites.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getParkingLotInfo() {
    }

    @Test
    void getFavorites() throws Exception {
        FavoritesService newService = new FavoritesService();
        List<ParkingLot> places = newService.getParkingLotInfo(53705, 10);

        for (ParkingLot parkingLot : places) {
            System.out.println(parkingLot.getId());
        }
    }

    @Test
    void testInsert() {
        GenericDao userDao = new GenericDao(User.class);
        User user = new User("john", "1234");
        userDao.saveOrUpdate(user);

        User newUser = (User)userDao.getById(3);
        System.out.println(newUser.getUserName());
        logger.info(newUser.getUserName());

        int newFaveParkingLotID = 789;
        String name = "Quick and Out Parking";
        String description = "2514 W Johnson St, Madison WI 53715";
        double price = 2.89;
        int availableLots = 2;
        Favorites newFavorite = new Favorites(newFaveParkingLotID, name, description, price, availableLots, newUser);
        user.addFavorites(newFavorite);
        int id = dao.insert(newFavorite);
        assertNotEquals(0, id);
        Favorites insertedFavorite = (Favorites) dao.getById(id);
        assertNotNull(insertedFavorite);
        assertEquals(newFaveParkingLotID, insertedFavorite.getParkingLotId());

    }
}
