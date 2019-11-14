package com.teamresistance.controller;

import com.teamresistance.entity.Favorites;
import com.teamresistance.entity.ParkingLot;
import com.teamresistance.entity.User;
import com.teamresistance.persistence.GenericDao;
import com.teamresistance.service.FavoritesService;
import com.teamresistance.service.ZipCodesItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 * A simple servlet to search and return cards in the user's database
 */
@WebServlet(
        urlPatterns = {"/addFavorite"}
)

public class AddServlet extends HttpServlet {

    //logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("inside add servlet ");

        HttpSession session = req.getSession();
        String userName = req.getRemoteUser();
        GenericDao userDao = new GenericDao(User.class);
        User loggedInUser = (User) userDao.getByProperty("userName", userName);

        //get user input
        String input = req.getParameter("id");
        List<ParkingLot> newList = (List<ParkingLot>)req.getAttribute("lots");
        ParkingLot newLot = new ParkingLot();


        //if user input is provided, return results matching the input
        if (input != null ) {
            try {

                int inputID = Integer.parseInt(input);

                for (int i = 0; i < newList.size(); i++) {
                   if (newList.get(i).getId() == inputID) {
                       newLot = newList.get(i);
                   }
                }

                GenericDao placeDao = new GenericDao(Favorites.class);


                Favorites newFavorite = new Favorites(inputID, newLot.getName(), newLot.getDescription(), newLot.getPrice(), newLot.getAvailableLots(),  loggedInUser);
                placeDao.saveOrUpdate(newFavorite);

                List<Favorites> places = placeDao.getAll();

                req.setAttribute("places", places);

            } catch (Exception e) {
               e.printStackTrace();
            }
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/favorites.jsp");
        dispatcher.forward(req, resp);
    }
}