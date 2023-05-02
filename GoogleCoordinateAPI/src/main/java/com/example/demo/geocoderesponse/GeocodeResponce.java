package com.example.demo.geocoderesponse;

public class GeocodeResponce {
String latitude;
String longitude;
public String getLatitude() {
	return latitude;
}
public void setLatitude(String latitude) {
	this.latitude = latitude;
}
public String getLongitude() {
	return longitude;
}
public void setLongitude(String longitude) {
	this.longitude = longitude;
}
public GeocodeResponce(String latitude, String longitude) {
	super();
	this.latitude = latitude;
	this.longitude = longitude;
}
public GeocodeResponce() {
	super();
	// TODO Auto-generated constructor stub
}

}
