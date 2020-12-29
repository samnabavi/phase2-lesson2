package com.model;

public class Product {
	
	private String id;
	private String name;
	private String model;
	private String color;
	private String year;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String id, String name, String model, String color, String year) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.color = color;
		this.year = year;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", model=" + model + ", color=" + color + ", year=" + year
				+ "]";
	} 
	

}
