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

    @Column(name="name")
    private String name;


    @Column(name="description")
    private String description;

    @Column(name="price")
    private double price;

    @Column(name="available")
    private int availableLots;

    @ManyToOne
    private User user;


    public Favorites() {
    }

    public Favorites(int parkingLotId, String name, String description, double price, int availableLots, User user) {
        this.parkingLotId = parkingLotId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.availableLots = availableLots;
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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public int getAvailableLots() { return availableLots; }

    public void setAvailableLots(int availableLots) { this.availableLots = availableLots; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
