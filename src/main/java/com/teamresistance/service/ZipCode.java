package com.zipecodeapi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

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
 	public String toString(){
		return 
			"ZipCode{" + 
			"zip_codes = '" + zipCodes + '\'' + 
			"}";
		}
}