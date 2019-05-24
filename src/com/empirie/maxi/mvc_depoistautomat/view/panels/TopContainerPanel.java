package com.empirie.maxi.mvc_depoistautomat.view.panels;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * <p>
 * This class represents the top-half of the depoist automat GUI.
 * </p>
 * 
 * @author hotzelm
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TopContainerPanel extends JPanel {

	/**
	 * <p>
	 * A singleton is used here because there should be only one startpanel in the
	 * application.
	 * </p>
	 */
	private static final TopContainerPanel topContainerPanel = new TopContainerPanel();

	private TopContainerPanel() {
		config();
	}

	private void config() {
		this.setBackground(new Color(223, 223, 223));
		this.setForeground(Color.blue);
		this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
	}

	public static TopContainerPanel getInstance() {
		return topContainerPanel;
	}

}
