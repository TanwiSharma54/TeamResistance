package com.teamresistance.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class ZipCode{

	@JsonProperty("zip_codes")
	private List<ZipCodesItem> zipCodes;

	public void setZipCodes(List<ZipCodesItem> zipCodes){
		this.zipCodes = zipCodes;
	}

	public List<ZipCodesItem> getZipCodes(){
		return zipCodes;
	}

	@Override
 	public String toString() {
		//return "zip_codes " + zipCodes;
		return
			"ZipCode{" + 
			"zip_codes = '" + zipCodes + '\'' + 
			"}";

	}
}