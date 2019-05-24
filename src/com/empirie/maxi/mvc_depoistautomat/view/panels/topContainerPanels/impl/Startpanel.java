package com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.impl;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.empirie.maxi.mvc_depoistautomat.control.MainController;
import com.empirie.maxi.mvc_depoistautomat.utils.PropertyHandler;
import com.empirie.maxi.mvc_depoistautomat.view.panels.TopContainerPanel;
import com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.IPanel;

/**
 * <p>
 * This class represents the GUI of the startpanel for the user.
 * </p>
 * 
 * @author hotzelm
 * @version 1.0
 * 
 * @see JPanel
 */
public class Startpanel implements IPanel {

	/**
	 * <p>
	 * A singleton is used here because there should be only one startpanel in the
	 * application.
	 * </p>
	 */
	private static Startpanel startpanel = new Startpanel();

	// class attributes
	private JButton addBottleBtn;
	private JButton languageBtn;
	private JButton viewBonBtn;

	private Startpanel() {
		init();
		config();
	}

	private void init() {
		PropertyHandler propsHandler = PropertyHandler.getInstance();

		this.addBottleBtn = new JButton(propsHandler.getDisplayText("depoistautomat.add.vessel.button"));
		this.languageBtn = new JButton(propsHandler.getDisplayText("depoistautomat.language.button"));
		this.viewBonBtn = new JButton(propsHandler.getDisplayText("depoistautomat.voucher.button"));
	}

	private void config() {
		this.addBottleBtn.addActionListener(MainController.getInstance());
		this.languageBtn.addActionListener(MainController.getInstance());
		this.viewBonBtn.addActionListener(MainController.getInstance());
	}

	@Override
	public void addComponents() {
		TopContainerPanel.getInstance().setLayout(new GridBagLayout());

		TopContainerPanel.getInstance().add(addBottleBtn);
		TopContainerPanel.getInstance().add(languageBtn);
		TopContainerPanel.getInstance().add(viewBonBtn);
	}

	@Override
	public void removeComponents() {
		TopContainerPanel.getInstance().setLayout(null);

		TopContainerPanel.getInstance().remove(addBottleBtn);
		TopContainerPanel.getInstance().remove(languageBtn);
		TopContainerPanel.getInstance().remove(viewBonBtn);
	}

	@Override
	public void changeLang() {
		PropertyHandler propsHandler = PropertyHandler.getInstance();
		this.addBottleBtn.setText(propsHandler.getDisplayText("depoistautomat.add.vessel.button"));
		this.languageBtn.setText(propsHandler.getDisplayText("depoistautomat.language.button"));
		this.viewBonBtn.setText(propsHandler.getDisplayText("depoistautomat.voucher.button"));
	}

	public static Startpanel getInstance() {
		return startpanel;
	}

	public JButton getAddBottleBtn() {
		return addBottleBtn;
	}

	public JButton getLanguageBtn() {
		return languageBtn;
	}

	public JButton getViewBonBtn() {
		return viewBonBtn;
	}

}
