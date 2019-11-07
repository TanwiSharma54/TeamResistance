package com.teamresistance.controller;

import com.teamresistance.entity.Favorites;
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

        HttpSession session = req.getSession();

       // User loggedInUser = (User)userDao.getByProperty("userName", req.getRemoteUser());

        //get user input
        String searchTerm = req.getParameter("zipcode");
        String searchType = req.getParameter("radius");

        int zipCode = Integer.parseInt(searchTerm);
        int radius = Integer.parseInt(searchType);

        //if user input is provided, return results matching the input
        if (!searchTerm.isEmpty() && !searchType.isEmpty()) {
            try {


                FavoritesService newService = new FavoritesService();
                List<ZipCodesItem> places = newService.getParkingLotInfo(zipCode, radius);

                req.setAttribute("places", places);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else { //otherwise, return all cards in the user's database
            req.setAttribute("places", "");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}