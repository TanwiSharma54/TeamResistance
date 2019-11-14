package com.teamresistance.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ParkingLot {

	@JsonProperty("price")
	private double price;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("availableLots")
	private int availableLots;

	@JsonProperty("id")
	private int id;

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setAvailableLots(int availableLots){
		this.availableLots = availableLots;
	}

	public int getAvailableLots(){
		return availableLots;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ParkingLot{" +
			"price = '" + price + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",availableLots = '" + availableLots + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}