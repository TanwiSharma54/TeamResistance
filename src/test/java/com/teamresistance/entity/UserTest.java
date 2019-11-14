package com.teamresistance.entity;

import com.teamresistance.entity.Favorites;
import com.teamresistance.entity.User;
import com.teamresistance.persistence.GenericDao;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    GenericDao dao;

    @BeforeEach
    void setUp() {
        dao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a User
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User) dao.getById(1);
        assertEquals("jmarley", retrievedUser.getUserName());
    }

    /**
     * Verify successful update of a User
     */
    @Test
    void updateSuccess() {
        String newUserName = "smcduck";
        User userToUpdate = (User) dao.getById(1);
        userToUpdate.setUserName(newUserName);
        dao.saveOrUpdate(userToUpdate);
        User userAfterUpdate = (User) dao.getById(1);
        assertEquals(newUserName, userAfterUpdate.getUserName());
    }

    /**
     * Verify successful insert of a User
     */
    @Test
    void insertSuccess() {
        String newUserName = "dqueiser";
        String newUserPassword = "lastjediSux";
        User newUser = new User(newUserName, newUserPassword);
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = (User) dao.getById(id);
        assertNotNull(insertedUser);
        assertEquals("dqueiser", insertedUser.getUserName());
    }

    /**
     * Verify successful insert of a user and a favorite
     */
    @Test
    void insertWithFaveSuccess() {
        String newUserName = "dbowman1";
        String newUserPassword = "openthedoors";
        int newFaveLot = 123;
        User newUser = new User(newUserName, newUserPassword);
        Favorites newFavorites = new Favorites(newFaveLot, newUser);
        newUser.addFavorites(newFavorites);
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = (User) dao.getById(id);
        assertNotNull(insertedUser);
        assertEquals("dbowman1", insertedUser.getUserName());
        assertEquals(1, insertedUser.getFavorites().size());

    }

    /**
     * Verify successful delete of User
     * Will need a test user set up for this test case
     *  - one that has a Favorite assigned to it
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    /**
     * Verify successful retrieval of all Users
     */
    @Test
    void getAllSuccess() {
        List<User> Users = dao.getAll();
        assertEquals(2, Users.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = (List<User>) dao.getByProperty("userName", "atreyu");
        assertEquals(1, users.size());
        assertEquals(2, users.get(0).getUserID());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getAllByPropertyLike("userName", "a");
        assertEquals(1, users.size());
    }

}
