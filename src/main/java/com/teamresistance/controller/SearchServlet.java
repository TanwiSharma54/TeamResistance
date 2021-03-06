package com.teamresistance.controller;

import com.teamresistance.entity.ParkingLot;
import com.teamresistance.service.FavoritesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * A simple servlet to search and return cards in the user's database
 */
@WebServlet(
        urlPatterns = {"/search"}
)

public class SearchServlet extends HttpServlet {

    //logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get a session
        HttpSession session = req.getSession();

        //get user input
        String zipInput = req.getParameter("zipCode");
        String radInput = req.getParameter("radius");


        //if user input is provided, return results matching the input
        if (zipInput != null && radInput != null) {
            try {

                //wrap inputs as Integers
                int zipCode = Integer.parseInt(zipInput);
                int radius = Integer.parseInt(radInput);

                //create instance of FavoritesService and get parkingLot info and store into list
                FavoritesService newService = new FavoritesService();
                List<ParkingLot> parkingLotInfoList = newService.getParkingLotInfo(zipCode, radius);

                session.setAttribute("lots", parkingLotInfoList);

            } catch (Exception e) {
               e.printStackTrace();
            }
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}