package com.teamresistance.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Key")
@Table(name="key")
public class Key {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name="userName")
    private String userName;

    @Column(name="passWord")
    private String passWord;

    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Favorites> favorites = new HashSet<>();

    public Key() {

    }

    public Set<Favorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorites> favorites) {
        this.favorites = favorites;
    }

    public Key(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getUserID() {
        return id;
    }

    public void setUserID(int userID) {
        this.id = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void addFavorites(Favorites place) {
        this.favorites.add(place);
    }

    public void removeFavorites(Favorites place) {
        this.favorites.remove(place);
    }
}
