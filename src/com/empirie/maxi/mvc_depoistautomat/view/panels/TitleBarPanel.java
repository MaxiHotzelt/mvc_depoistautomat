package com.empirie.maxi.mvc_depoistautomat.view.panels;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.empirie.maxi.mvc_depoistautomat.control.MainController;

/**
 * <p>
 * This class replaces the default TitleBar.
 * </p>
 * 
 * @author hotzelm
 * @version 1.0
 * @see JPanel
 */
@SuppressWarnings("serial")
public class TitleBarPanel extends JPanel {

	/**
	 * <p>
	 * A singleton is used here, because there should be only one titleBar in our
	 * application.
	 * </p>
	 */
	private static TitleBarPanel titleBarPanel = new TitleBarPanel();

	private JButton exitBtn;
	private JButton minimizeBtn;

	private TitleBarPanel() {
		init();
		config();
		build();
	}

	private void init() {
		this.exitBtn = new JButton("X");
		this.minimizeBtn = new JButton("-");
	}

	private void config() {
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.setBackground(new Color(163, 92, 94));
		this.addMouseMotionListener(MainController.getInstance());
		this.addMouseListener(MainController.getInstance());
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));

		this.exitBtn.addActionListener(MainController.getInstance());
		this.exitBtn.setFocusPainted(false);

		this.minimizeBtn.addActionListener(MainController.getInstance());
		this.minimizeBtn.setFocusPainted(false);

	}

	private void build() {
		this.add(minimizeBtn);
		this.add(exitBtn);
	}

	public static TitleBarPanel getInstance() {
		return titleBarPanel;
	}

	public JButton getExitBtn() {
		return exitBtn;
	}

	public JButton getMinimizeBtn() {
		return minimizeBtn;
	}
}
