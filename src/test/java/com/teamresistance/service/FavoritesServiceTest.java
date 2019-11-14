package com.teamresistance.service;

import com.teamresistance.entity.Favorites;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FavoritesServiceTest {

    @Test
    void getParkingLotInfo() {
    }

    @Test
    void getFavorites() throws Exception {
        FavoritesService newService = new FavoritesService();
        List<Favorites> places = newService.getParkingLotInfo(53705, 10);

        for (Favorites place : places) {
            System.out.println(place.getId());
        }
    }


}