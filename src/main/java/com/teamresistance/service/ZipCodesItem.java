package com.teamresistance.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ZipCodesItem{

	@JsonProperty("zip_code")
	private String zipCode;


	public void setZipCode(String zipCode){
		this.zipCode = zipCode;
	}

	public String getZipCode(){
		return zipCode;
	}

	@Override
 	public String toString(){
		return 
			"ZipCodesItem{" +
			",zip_code = '" + zipCode + '\'' + 
			"}";
		}
}