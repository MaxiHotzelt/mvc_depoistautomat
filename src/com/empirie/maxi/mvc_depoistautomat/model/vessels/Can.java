package com.empirie.maxi.mvc_depoistautomat.model.vessels;

import com.empirie.maxi.mvc_depoistautomat.model.DrinkingVessel;

public class Can extends DrinkingVessel {

	public Can(String type, String brand, double volume) {
		super(type, brand, volume);
		this.value = 0.25;
	}

}
