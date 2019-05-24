package com.empirie.maxi.mvc_depoistautomat.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Voucher {

	private Date creationDate;
	private double value;
	private ArrayList<DrinkingVessel> drinkingVessels = new ArrayList<>();

	public Voucher() {
		creationDate = Calendar.getInstance().getTime();
	}

	public void addVessel(DrinkingVessel vessel) {
		drinkingVessels.add(vessel);
	}

	public void reevaluateValue() {
		this.value = 0;
		for (DrinkingVessel vessel : drinkingVessels) {
			this.value += vessel.getValue() * 100;
		}
		this.value = this.value / 100;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public double getValue() {
		return value;
	}

	public List<DrinkingVessel> getDrinkingVessels() {
		return drinkingVessels;
	}
}
