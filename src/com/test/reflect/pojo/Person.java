package com.test.reflect.pojo;

public class Person {
	private String uid;
	private String lng;
	private String lat;

	public int x;
	public int y;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Person() {
		super();
	}

	public Person(String uid, String lng, String lat, int x, int y) {
		super();
		this.uid = uid;
		this.lng = lng;
		this.lat = lat;
		this.x = x;
		this.y = y;
	}

	public Person(String uid) {
		super();
		this.uid = uid;
	}

	public Person(String lng, String lat) {
		super();
		this.lng = lng;
		this.lat = lat;
	}

	protected Person(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	
	
	
	

}
