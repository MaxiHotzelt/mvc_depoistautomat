package com.empirie.maxi.mvc_depoistautomat.model;

/**
 * <p>
 * This class represents a drinking vessel and its attributes.
 * </p>
 * 
 * @author hotzelm
 * @version 1.0
 */
public abstract class DrinkingVessel {

	protected double value;
	protected double volume;
	protected String type;
	protected String brand;

	public DrinkingVessel(String type, String brand, double volume) {
		this.type = type;
		this.brand = brand;
		this.volume = volume;
	}

	// getters and setters
	public double getValue() {
		return value;
	}

	public double getVolume() {
		return volume;
	}

	public String getType() {
		return type;
	}

	public String getBrand() {
		return brand;
	}
}
