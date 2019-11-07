package com.teamresistance.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name="Favorites")
@Table(name="favorites")
public class Favorites {

    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int Id;

    @Column(name="parkingLotId")
    private int parkingLotId;

    @ManyToOne
    private User user;


    public Favorites() {
    }

    public Favorites(int parkingLotId, User user) {
        this.parkingLotId = parkingLotId;
        this.user = user;
    }

    public int getId() {
        return this.Id;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
