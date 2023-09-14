package com.sam.SpringWithMongodb.model;

public class Address {

	private String area;
	private String district;
	private Integer postcode;
	
	
	public Address() {}
	public Address(String area, String district, Integer postcode) {
		super();
		this.area = area;
		this.district = district;
		this.postcode = postcode;
	}
	
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getPostcode() {
		return postcode;
	}
	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}
}
