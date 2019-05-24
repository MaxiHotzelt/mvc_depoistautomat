package com.empirie.maxi.mvc_depoistautomat.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class represents the model of the depoistautomat in our application.
 * </p>
 * 
 * @author hotzelm
 * @version 1.0
 */
public class Depoistautomat {

	/**
	 * <p>
	 * A singleton is used here, because there should only be one depoistautomat in
	 * our application.
	 * </p>
	 */
	private static Depoistautomat depoistAutomat = new Depoistautomat();

	/**
	 * <p>
	 * In this list all the vouchers are saved.
	 * </p>
	 * 
	 * @see ArrayList
	 */
	private ArrayList<Voucher> vouchers = new ArrayList<>();

	/**
	 * <p>
	 * This list saves all the vessels, that are inside the automat.
	 * </p>
	 * 
	 * @see ArrayList
	 */
	private ArrayList<DrinkingVessel> vessels = new ArrayList<>();

	private Voucher activeVoucher;

	private Depoistautomat() {

	}

	/**
	 * <p>
	 * This method represents the emptying of the vessels inside the automat.
	 * </p>
	 */
	public void emptyDPAutomat() {
		vessels.clear();
	}

	public void addDrinkingVessel(DrinkingVessel vessel) {
		this.vessels.add(vessel);
	}

	public static Depoistautomat getInstance() {
		return depoistAutomat;
	}

	public List<Voucher> getVouchers() {
		return vouchers;
	}

	public List<DrinkingVessel> getVessels() {
		return vessels;
	}

	public Voucher getActiveVoucher() {
		return activeVoucher;
	}

	public void setActiveVoucher(Voucher activeVoucher) {
		this.activeVoucher = activeVoucher;
	}

}
