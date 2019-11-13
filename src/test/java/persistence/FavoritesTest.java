package persistence;

import com.teamresistance.entity.Favorites;
import com.teamresistance.entity.User;
import com.teamresistance.persistence.GenericDao;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FavoritesTest {

    GenericDao dao;

    @BeforeEach
    void setUp() {
        dao = new GenericDao(Favorites.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a Favorite
     */
    @Test
    void getByIdSuccess() {
        Favorites retrievedFave = (Favorites) dao.getById(1);
        assertNotNull(retrievedFave);
        //assertEquals(123, retrievedFave.getParkingLotId());
    }

    /**
     * Verify successful update of a Favorite
     */
    @Test
    void updateSuccess() {
        int newParkingLotID = 456;
        Favorites favoriteToUpdate = (Favorites) dao.getById(1);
        favoriteToUpdate.setParkingLotId(newParkingLotID);
        dao.saveOrUpdate(favoriteToUpdate);
        Favorites favoriteAfterUpdate = (Favorites) dao.getById(1);
        assertEquals(newParkingLotID, favoriteAfterUpdate.getParkingLotId());
    }

    /**
     * Verify successful insert of a Favorite
     */
    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User) userDao.getById(1);
        int newFaveParkingLotID = 789;
        Favorites newFavorite = new Favorites(newFaveParkingLotID, user);
        user.addFavorites(newFavorite);
        int id = dao.insert(newFavorite);
        assertNotEquals(0, id);
        Favorites insertedFavorite = (Favorites) dao.getById(id);
        assertNotNull(insertedFavorite);
        assertEquals(newFaveParkingLotID, insertedFavorite.getParkingLotId());
    }

    /**
     * Verify successful delete of a favorite
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * Verify successful retrieval of all Favorites
     */
    @Test
    void getAllSuccess() {
        List<Favorites> favorites = dao.getAll();
        assertEquals(3, favorites.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    //@Test
    //void getByPropertyEqualSuccess() {
        //List<Favorites> favorites = dao.getAllByProperty("parkingLotId", 963);
        //assertEquals(1, favorites.size());
        //assertEquals(1, favorites.get(0).getId());
    //}

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Favorites> favorites = dao.getAllByPropertyLike("parkingLotId", "1");
        assertEquals(2, favorites.size());
    }


}
