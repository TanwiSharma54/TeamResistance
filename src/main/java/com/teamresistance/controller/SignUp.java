package com.teamresistance.controller;

import com.teamresistance.service.FavoritesService;
import com.teamresistance.service.ZipCodesItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * A simple servlet to search and return cards in the user's database
 */
@WebServlet(
        urlPatterns = {"/search"}
)

public class SignUp extends HttpServlet {

    //logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //get user input
        String zipInput = req.getParameter("zipCode");
        String radInput = req.getParameter("radius");


        //if user input is provided, return results matching the input
        if (zipInput != null && radInput != null) {
            try {

                int zipCode = Integer.parseInt(zipInput);
                int radius = Integer.parseInt(radInput);

                FavoritesService newService = new FavoritesService();
                List<ZipCodesItem> places = newService.getParkingLotInfo(zipCode, radius);

                req.setAttribute("places", places);

            } catch (Exception e) {
               e.printStackTrace();
            }
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}