package com.empirie.maxi.mvc_depoistautomat.view.panels;

import static java.awt.GridBagConstraints.BOTH;
import static java.awt.GridBagConstraints.CENTER;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import com.empirie.maxi.mvc_depoistautomat.utils.GridBagConstraintsHelper;
import com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.impl.PrintBonPanel;
import com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.impl.Startpanel;

/**
 * <p>
 * This class is here to initialize all the GUI for the start.
 * </p>
 * 
 * @author hotzelm
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ContainerPanel extends JPanel {

	private static final ContainerPanel mainView = new ContainerPanel();

	private TopContainerPanel topContainerPanel;
	private PrintBonPanel printBonPanel;

	private GridBagConstraintsHelper gbcHelper;

	public static ContainerPanel getInstance() {
		return mainView;
	}

	private ContainerPanel() {
		init();
		config();
		build();
	}

	private void init() {
		this.topContainerPanel = TopContainerPanel.getInstance();
		this.printBonPanel = new PrintBonPanel();
		this.gbcHelper = GridBagConstraintsHelper.getInstance();
	}

	private void config() {
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(242, 65, 72));
	}

	private void build() {
		Startpanel.getInstance().addComponents();

		this.add(topContainerPanel,
				gbcHelper.configureAllConstraints(0, 0, 1, 1, BOTH, 1, 1, CENTER, new Insets(100, 100, 50, 100)));
		this.add(printBonPanel, gbcHelper.configureConstraints(0, 1, 1, 1, BOTH, 1, 1, CENTER));
	}

	public TopContainerPanel getTopContainerPanel() {
		return topContainerPanel;
	}

	public GridBagConstraintsHelper getGbcHelper() {
		return gbcHelper;
	}

}
