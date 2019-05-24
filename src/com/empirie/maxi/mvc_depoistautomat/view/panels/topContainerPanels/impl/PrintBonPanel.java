package com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PrintBonPanel extends JPanel {

	public PrintBonPanel() {
		init();
		build();
		config();
		repaint();
	}

	private void init() {
		// not used
	}

	private void build() {
		// not used
	}

	private void config() {
		this.setOpaque(false);
	}

	@Override
	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		super.paint(g2d);
		g2d.setColor(Color.black);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		int ovalD = 220;
		g2d.fillOval(720 / 2 - ovalD / 2, 0, ovalD, ovalD);
	}
}
