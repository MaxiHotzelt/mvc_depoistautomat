package com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.impl;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.empirie.maxi.mvc_depoistautomat.control.MainController;
import com.empirie.maxi.mvc_depoistautomat.model.DrinkingVessel;
import com.empirie.maxi.mvc_depoistautomat.model.Voucher;
import com.empirie.maxi.mvc_depoistautomat.utils.GridBagConstraintsHelper;
import com.empirie.maxi.mvc_depoistautomat.utils.PropertyHandler;
import com.empirie.maxi.mvc_depoistautomat.view.panels.TopContainerPanel;
import com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.IPanel;

public class BonInfoPanel implements IPanel {

	/**
	 * A singleton is used here, because our application has only one BonInfoPanel
	 * to display.
	 */
	private static BonInfoPanel bonInfoPanel = new BonInfoPanel();

	// needed components
	private JButton printBonBtn;
	private JButton backBtn;

	private JPanel voucherPanel;
	private JScrollPane scrollPane;
	private JLabel voucherInfoLbl;

	private BonInfoPanel() {
		init();
		config();
		build();
	}

	private void init() {
		this.printBonBtn = new JButton(
				PropertyHandler.getInstance().getDisplayText("depoistautomat.voucher.print.button"));
		this.backBtn = new JButton(PropertyHandler.getInstance().getDisplayText("depoistautomat.back.button"));

		this.voucherPanel = new JPanel();
		this.scrollPane = new JScrollPane(voucherPanel);
		this.voucherInfoLbl = new JLabel();
	}

	private void config() {
		this.printBonBtn.addActionListener(MainController.getInstance());
		this.backBtn.addActionListener(MainController.getInstance());
	}

	private void build() {
		this.voucherPanel.add(voucherInfoLbl);
	}

	public void showMessage() {
		JOptionPane.showMessageDialog(TopContainerPanel.getInstance(),
				PropertyHandler.getInstance().getDisplayText("depoistautomat.voucher.print.successful.message"),
				"Information", JOptionPane.INFORMATION_MESSAGE);
	}

	public void showVoucherInfo(Voucher voucher) {

		StringBuilder sb = new StringBuilder();

		DateFormat formatter = new SimpleDateFormat();
		PropertyHandler propsHandler = PropertyHandler.getInstance();

		sb.append("<html><head><style>" + "table {" + "  font-family: arial, sans-serif;"
				+ "  border-collapse: collapse;" + "  width: 100%;" + "}" + "td, th {" + "  border: 1px solid #dddddd;"
				+ "  text-align: left;" + "  padding: 8px;" + "}" + "</style></head><p style='margin-bottom:10px'>"
				+ propsHandler.getDisplayText("depoistautomat.voucher.info.created") + ": "
				+ formatter.format(voucher.getCreationDate()) + "</p>");
		sb.append("<table><tr><th>" + propsHandler.getDisplayText("depoistautomat.voucher.info.type") + "</th><th>"
				+ propsHandler.getDisplayText("depoistautomat.voucher.info.brand") + "</th><th>"
				+ propsHandler.getDisplayText("depoistautomat.voucher.info.volume") + "</th><th>"
				+ propsHandler.getDisplayText("depoistautomat.voucher.info.depoist") + "</th></tr>");
		for (DrinkingVessel vessel : voucher.getDrinkingVessels()) {
			sb.append("<tr>" + vessel.getType() + "</td><td>" + vessel.getBrand() + "</td><td>" + vessel.getVolume()
					+ " L</td><td style='text-align:right'>" + vessel.getValue() + " €</td></tr>");
		}
		sb.append("<tr><td style='text-align:right' colspan='4'>" + voucher.getValue() + " €</td></tr></table>");
		sb.append("</html>");

		voucherInfoLbl.setText(sb.toString());

	}

	@Override
	public void addComponents() {
		TopContainerPanel.getInstance().setLayout(new GridBagLayout());

		TopContainerPanel.getInstance().add(scrollPane, GridBagConstraintsHelper.getInstance().configureConstraints(0,
				0, 3, 1, 0, 0, 0, GridBagConstraints.CENTER));
		TopContainerPanel.getInstance().add(printBonBtn, GridBagConstraintsHelper.getInstance().configureConstraints(0,
				1, 1, 1, 0, 0, 0, GridBagConstraints.LAST_LINE_START));
		TopContainerPanel.getInstance().add(backBtn, GridBagConstraintsHelper.getInstance().configureConstraints(2, 1,
				1, 1, 0, 0, 0, GridBagConstraints.LAST_LINE_END));
	}

	@Override
	public void removeComponents() {
		TopContainerPanel.getInstance().setLayout(new FlowLayout());

		TopContainerPanel.getInstance().remove(printBonBtn);
		TopContainerPanel.getInstance().remove(backBtn);
		TopContainerPanel.getInstance().remove(scrollPane);

	}

	@Override
	public void changeLang() {
		this.printBonBtn.setText(PropertyHandler.getInstance().getDisplayText("depoistautomat.voucher.print.button"));
		this.backBtn.setText(PropertyHandler.getInstance().getDisplayText("depoistautomat.back.button"));

	}

	public static BonInfoPanel getInstance() {
		return bonInfoPanel;
	}

	public JButton getPrintBonBtn() {
		return printBonBtn;
	}

	public JButton getBackBtn() {
		return backBtn;
	}
}
