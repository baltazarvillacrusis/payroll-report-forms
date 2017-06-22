package com.svi.payroll.report.objects;

public class Address {
	
	 private String unitOrRoomNum = "";
	 private String floorNum = "";
	 private String buildingName = "";
	 private String blockNo = ""; //block no, phase no, house no
	 private String street = "";
	 private String barangay = "";
	 private String subdivision = "";
	 private String city = "";  //municipality
	 private String province = ""; //state if abroad
	 private String country = "";
	 private String zipCode = "";
	 
	 public Address(){
		 
	 }
	 public Address(String unitOrRoomNum, String floorNum, String buildingName,
			String blockNo, String street, String barangay, String subdivision,
			String city, String province, String country, String zipCode) {	
		this.unitOrRoomNum = unitOrRoomNum;
		this.floorNum = floorNum;
		this.buildingName = buildingName;
		this.blockNo = blockNo;
		this.street = street;
		this.barangay = barangay;
		this.subdivision = subdivision;
		this.city = city;
		this.province = province;
		this.country = country;
		this.zipCode = zipCode;
	}


	 
	 
	public String getUnitOrRoomNum() {
		return unitOrRoomNum;
	}
	public void setUnitOrRoomNum(String unitOrRoomNum) {
		this.unitOrRoomNum = unitOrRoomNum;
	}
	public String getFloorNum() {
		return floorNum;
	}
	public void setFloorNum(String floorNum) {
		this.floorNum = floorNum;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getBlockNo() {
		return blockNo;
	}
	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBarangay() {
		return barangay;
	}
	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}
	public String getSubdivision() {
		return subdivision;
	}
	public void setSubdivision(String subdivision) {
		this.subdivision = subdivision;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	// TODO change method name to getCompleteAddress
	public String completeAddress() {		  
		StringBuilder completeAddress = new StringBuilder();	
		appendString(floorNum,completeAddress);
		appendString(buildingName,completeAddress);
		appendString(blockNo,completeAddress);
		appendString(street,completeAddress);
		appendString(barangay,completeAddress);
		appendString(subdivision,completeAddress);
		appendString(city,completeAddress);
		appendString(province,completeAddress);
		appendString(country,completeAddress);
		appendString(zipCode,completeAddress);	
		return completeAddress.toString();	  
	}
	
	private void appendString(String str, StringBuilder completeAddress){
		if(str.trim().length() != 0){
			if(completeAddress.toString().trim().length() >0){
				completeAddress.append(", "+str.trim());
			}
			else{
				completeAddress.append(str.trim());
			}
			
		}
	}
}
