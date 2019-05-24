package com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.impl;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.empirie.maxi.mvc_depoistautomat.control.MainController;
import com.empirie.maxi.mvc_depoistautomat.utils.GridBagConstraintsHelper;
import com.empirie.maxi.mvc_depoistautomat.utils.ImageLoader;
import com.empirie.maxi.mvc_depoistautomat.utils.PropertyHandler;
import com.empirie.maxi.mvc_depoistautomat.view.panels.TopContainerPanel;
import com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.IPanel;

/**
 * <p>
 * This class is a represents the part of the GUI, where the user can choose
 * from different languages.
 * </p>
 * 
 * @author hotzelm
 * @version 1.0
 */
public class LangPanel implements IPanel {

	/**
	 * <p>
	 * A singleton is used here because there only exists one language Panel in our
	 * application.
	 * </p>
	 */
	public static LangPanel langPanel = new LangPanel();

	// needed attributes
	private JButton applyBtn;
	private JButton backBtn;

	private JPanel flagsPanel;
	private JLabel gerIcon;
	private JLabel enIcon;

	private LangPanel() {
		init();
		config();
		build();
	}

	private void init() {
		PropertyHandler propsHandler = PropertyHandler.getInstance();

		this.applyBtn = new JButton(propsHandler.getDisplayText("depoistautomat.apply.button"));
		this.backBtn = new JButton(propsHandler.getDisplayText("depoistautomat.back.button"));

		this.flagsPanel = new JPanel();
		this.enIcon = new JLabel(ImageLoader.getInstance().loadImg("english.png"));
		this.gerIcon = new JLabel(ImageLoader.getInstance().loadImg("german.png"));
	}

	private void config() {
		this.applyBtn.addActionListener(MainController.getInstance());
		this.backBtn.addActionListener(MainController.getInstance());

		this.flagsPanel.setOpaque(false);

		this.enIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.enIcon.addMouseListener(MainController.getInstance());
		this.enIcon.setPreferredSize(new Dimension(200, 200));

		this.gerIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.gerIcon.addMouseListener(MainController.getInstance());
		this.gerIcon.setPreferredSize(new Dimension(200, 200));
	}

	private void build() {
		this.flagsPanel.add(this.enIcon);
		this.flagsPanel.add(this.gerIcon);
	}

	@Override
	public void addComponents() {
		GridBagConstraintsHelper gbcH = GridBagConstraintsHelper.getInstance();

		TopContainerPanel.getInstance().setLayout(new GridBagLayout());

		TopContainerPanel.getInstance().add(this.flagsPanel,
				gbcH.configureConstraints(0, 0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER));
		TopContainerPanel.getInstance().add(this.applyBtn,
				gbcH.configureConstraints(0, 1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER));
		TopContainerPanel.getInstance().add(this.backBtn,
				gbcH.configureConstraints(1, 1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER));

	}

	@Override
	public void removeComponents() {
		TopContainerPanel.getInstance().setLayout(null);

		TopContainerPanel.getInstance().remove(this.flagsPanel);
		TopContainerPanel.getInstance().remove(this.applyBtn);
		TopContainerPanel.getInstance().remove(this.backBtn);
	}

	@Override
	public void changeLang() {
		PropertyHandler propsHandler = PropertyHandler.getInstance();

		this.applyBtn.setText(propsHandler.getDisplayText("depoistautomat.apply.button"));
		this.backBtn.setText(propsHandler.getDisplayText("depoistautomat.back.button"));
	}

	public static LangPanel getInstance() {
		return langPanel;
	}

	public JButton getApplyBtn() {
		return applyBtn;
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public JPanel getFlagsPanel() {
		return flagsPanel;
	}

	public JLabel getGerIcon() {
		return gerIcon;
	}

	public JLabel getEnIcon() {
		return enIcon;
	}

}
