package com.teamresistance.controller;

import com.teamresistance.entity.User;
import com.teamresistance.persistence.GenericDao;
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

/**
 * A simple servlet to search.
 */

@WebServlet(
        urlPatterns = {"/login"}
)

public class Login extends HttpServlet {

    //logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * handles HTTP GET requests.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //get a session
        HttpSession session = req.getSession();
        String userName = req.getRemoteUser();

        if (userName != null) {
            GenericDao userDao = new GenericDao(User.class);
            User loggedInUser = (User) userDao.getByProperty("userName", userName);

            logger.info("Logging in for user: " + userName);

            session.setAttribute("id", loggedInUser.getUserID());

        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}