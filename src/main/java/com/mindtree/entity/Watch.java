package com.mindtree.entity;

public class Watch implements Comparable<Watch> {

	private int id;
	private String modelName;
	private float price;
	private int typeID;

	public Watch() {

	}

	public Watch(int id, String modelName, float price, int typeID) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.price = price;
		this.typeID = typeID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int compareTo(Watch o) {
		// TODO Auto-generated method stub
		return (int) (o.getPrice() - this.getPrice());
	}

}
