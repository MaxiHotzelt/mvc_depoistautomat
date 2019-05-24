package com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.impl;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;

import com.empirie.maxi.mvc_depoistautomat.control.MainController;
import com.empirie.maxi.mvc_depoistautomat.utils.PropertyHandler;
import com.empirie.maxi.mvc_depoistautomat.view.panels.TopContainerPanel;
import com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.IPanel;

/**
 * <p>
 * This class represents the GUI for adding different vessels to the voucher. It
 * has all the components, which are added to the 'TopContainerPanel', if this
 * view is active.
 * </p>
 * 
 * @author hotzelm
 * @version 1.0
 */
public class AddVesselPanel implements IPanel {

	/**
	 * <p>
	 * A singleton is used here because there should be only one addVesselPanel in
	 * the application.
	 * </p>
	 */
	private static AddVesselPanel addVesselPanel = new AddVesselPanel();

	// class attributes
	private JButton addVesselBtn;
	private JButton cancelBtn;

	private JComboBox<String> brandsCbx;
	private JComboBox<String> typesCbx;
	private JComboBox<String> volumesCbx;

	private AddVesselPanel() {
		init();
		config();
	}

	private void init() {
		PropertyHandler propsHandler = PropertyHandler.getInstance();

		this.addVesselBtn = new JButton(propsHandler.getDisplayText("depoistautomat.add.vessel.button"));
		this.cancelBtn = new JButton(propsHandler.getDisplayText("depoistautomat.cancel.button"));

		this.brandsCbx = new JComboBox<>();
		this.typesCbx = new JComboBox<>();
		this.volumesCbx = new JComboBox<>();
	}

	private void config() {
		this.cancelBtn.addActionListener(MainController.getInstance());
		this.addVesselBtn.addActionListener(MainController.getInstance());
		PropertyHandler.getInstance().getVesselInfo(typesCbx, null, null, null, "types");
		PropertyHandler.getInstance().getVesselInfo(brandsCbx, null, null, null, "brands");
		PropertyHandler.getInstance().getVesselInfo(volumesCbx, null, null, null, "volumes");
	}

	@Override
	public void addComponents() {
		TopContainerPanel.getInstance().setLayout(new GridBagLayout());

		TopContainerPanel.getInstance().add(brandsCbx);
		TopContainerPanel.getInstance().add(typesCbx);
		TopContainerPanel.getInstance().add(volumesCbx);
		TopContainerPanel.getInstance().add(addVesselBtn);
		TopContainerPanel.getInstance().add(cancelBtn);
	}

	@Override
	public void removeComponents() {
		TopContainerPanel.getInstance().setLayout(null);

		TopContainerPanel.getInstance().remove(brandsCbx);
		TopContainerPanel.getInstance().remove(typesCbx);
		TopContainerPanel.getInstance().remove(volumesCbx);
		TopContainerPanel.getInstance().remove(addVesselBtn);
		TopContainerPanel.getInstance().remove(cancelBtn);
	}

	@Override
	public void changeLang() {
		PropertyHandler propsHandler = PropertyHandler.getInstance();

		this.addVesselBtn.setText(propsHandler.getDisplayText("depoistautomat.add.vessel.button"));
		this.cancelBtn.setText(propsHandler.getDisplayText("depoistautomat.cancel.button"));
	}

	public static AddVesselPanel getInstance() {
		return addVesselPanel;
	}

	public JButton getAddVesselBtn() {
		return addVesselBtn;
	}

	public JButton getCancelBtn() {
		return cancelBtn;
	}

	public JComboBox<String> getBrandsCbx() {
		return brandsCbx;
	}

	public JComboBox<String> getTypesCbx() {
		return typesCbx;
	}

	public JComboBox<String> getVolumesCbx() {
		return volumesCbx;
	}

}
