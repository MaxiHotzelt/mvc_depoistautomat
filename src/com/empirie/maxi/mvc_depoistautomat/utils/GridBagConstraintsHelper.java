package com.empirie.maxi.mvc_depoistautomat.utils;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GridBagConstraintsHelper {

	public static final GridBagConstraintsHelper GBC_HELPER = new GridBagConstraintsHelper();

	public static GridBagConstraintsHelper getInstance() {
		return GBC_HELPER;
	}

	private GridBagConstraintsHelper() {

	}

	public GridBagConstraints configureConstraints(int gridx, int gridy, int gridwidth, int gridheight, int fill,
			double weightx, double weighty, int anchor) {
		return configConstraints(gridx, gridy, gridwidth, gridheight, fill, weightx, weighty, anchor,
				new Insets(0, 0, 0, 0), 0, 0);

	}

	public GridBagConstraints configureAllConstraints(int gridx, int gridy, int gridwidth, int gridheight, int fill,
			double weightx, double weighty, int anchor, Insets insets) {
		return configConstraints(gridx, gridy, gridwidth, gridheight, fill, weightx, weighty, anchor, insets, 0, 0);
	}

	private GridBagConstraints configConstraints(int gridx, int gridy, int gridwidth, int gridheight, int fill,
			double weightx, double weighty, int anchor, Insets insets, int ipadx, int ipady) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		constraints.fill = fill;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		constraints.anchor = anchor;
		constraints.insets = insets;
		constraints.ipadx = ipadx;
		constraints.ipady = ipady;

		return constraints;
	}
}
