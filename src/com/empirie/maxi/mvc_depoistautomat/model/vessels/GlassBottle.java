package com.empirie.maxi.mvc_depoistautomat.model.vessels;

import com.empirie.maxi.mvc_depoistautomat.model.DrinkingVessel;

public class GlassBottle extends DrinkingVessel {

	public GlassBottle(String type, String brand, double volume) {
		super(type, brand, volume);
		this.value = 0.15;
	}

}
