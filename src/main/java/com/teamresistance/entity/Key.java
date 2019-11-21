package com.teamresistance.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Key")
@Table(name="api_keys")
public class Key {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name="API_Key")
    private String apiKey;

    public Key() {

    }

    public Key(String apiKey) {
        this.apiKey = apiKey;
    }

    public int getKeyID() {
        return id;
    }

    public void setKeyID(int keyID) {
        this.id = keyID;
    }

    public String getAPIKey() {
        return apiKey;
    }

    public void setAPIKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
