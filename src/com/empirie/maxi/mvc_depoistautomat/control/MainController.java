package com.empirie.maxi.mvc_depoistautomat.control;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.empirie.maxi.mvc_depoistautomat.model.Depoistautomat;
import com.empirie.maxi.mvc_depoistautomat.model.DrinkingVessel;
import com.empirie.maxi.mvc_depoistautomat.model.Voucher;
import com.empirie.maxi.mvc_depoistautomat.model.vessels.Can;
import com.empirie.maxi.mvc_depoistautomat.model.vessels.GlassBottle;
import com.empirie.maxi.mvc_depoistautomat.model.vessels.PlasticBottle;
import com.empirie.maxi.mvc_depoistautomat.utils.LanguageEnum;
import com.empirie.maxi.mvc_depoistautomat.utils.PropertyHandler;
import com.empirie.maxi.mvc_depoistautomat.view.EntrypointDPAutomat;
import com.empirie.maxi.mvc_depoistautomat.view.panels.TitleBarPanel;
import com.empirie.maxi.mvc_depoistautomat.view.panels.TopContainerPanel;
import com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.IPanel;
import com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.impl.AddVesselPanel;
import com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.impl.BonInfoPanel;
import com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.impl.LangPanel;
import com.empirie.maxi.mvc_depoistautomat.view.panels.topContainerPanels.impl.Startpanel;

/**
 * <p>
 * This class is the Controller. It handles user interactions and the therefore
 * resulting communication between model and view.
 * </p>
 * 
 * @author hotzelm
 * @version 1.0
 */
public class MainController implements ActionListener, MouseListener, MouseMotionListener {
	/**
	 * <p>
	 * A singleton is used here because there should be only one mainController in
	 * the application.
	 * </p>
	 */
	private static final MainController mainController = new MainController();

	// needed views
	private ArrayList<IPanel> panels = new ArrayList<>();

	/**
	 * <p>
	 * This attribute is needed, because we need to make our application draggable
	 * again, after setting '.setUndecorated(true)'
	 * </p>
	 */
	private Point appCords;

	private MainController() {
		init();
	}

	private void init() {
		addVoucher();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (panels.isEmpty()) {
			panels.add(Startpanel.getInstance());
			panels.add(AddVesselPanel.getInstance());
			panels.add(LangPanel.getInstance());
			panels.add(BonInfoPanel.getInstance());
		}
		// startpanel
		if (e.getSource() == Startpanel.getInstance().getAddBottleBtn()) {
			Startpanel.getInstance().removeComponents();
			AddVesselPanel.getInstance().addComponents();
		} else if (e.getSource() == Startpanel.getInstance().getLanguageBtn()) {
			Startpanel.getInstance().removeComponents();
			LangPanel.getInstance().addComponents();
		} else if (e.getSource() == Startpanel.getInstance().getViewBonBtn()) {
			Startpanel.getInstance().removeComponents();
			BonInfoPanel.getInstance().addComponents();
			BonInfoPanel.getInstance().showVoucherInfo(getActiveVoucher());
		}
		// addVesselPanel
		else if (e.getSource() == AddVesselPanel.getInstance().getCancelBtn()) {
			AddVesselPanel.getInstance().removeComponents();
			Startpanel.getInstance().addComponents();
		} else if (e.getSource() == AddVesselPanel.getInstance().getAddVesselBtn()) {
			addVessel();
			getActiveVoucher().reevaluateValue();
		}
		// langPanel
		else if (e.getSource() == LangPanel.getInstance().getApplyBtn()) {
			changeLang();
		} else if (e.getSource() == LangPanel.getInstance().getBackBtn()) {
			LangPanel.getInstance().removeComponents();
			Startpanel.getInstance().addComponents();
		}
		// bonInfoPanel
		else if (e.getSource() == BonInfoPanel.getInstance().getBackBtn()) {
			BonInfoPanel.getInstance().removeComponents();
			Startpanel.getInstance().addComponents();
		} else if (e.getSource() == BonInfoPanel.getInstance().getPrintBonBtn()) {
			BonInfoPanel.getInstance().showMessage();
			addVoucher();
		}
		// topTitleBar
		else if (e.getSource() == TitleBarPanel.getInstance().getExitBtn()) {
			System.exit(0);
		} else if (e.getSource() == TitleBarPanel.getInstance().getMinimizeBtn()) {
			EntrypointDPAutomat.getInstance().setState(JFrame.ICONIFIED);
		}

		TopContainerPanel.getInstance().revalidate();
		TopContainerPanel.getInstance().repaint();

	}

	private Voucher getActiveVoucher() {
		ArrayList<Voucher> vouchers = (ArrayList<Voucher>) Depoistautomat.getInstance().getVouchers();

		return vouchers.get(vouchers.size() - 1);
	}

	private void addVoucher() {
		Depoistautomat.getInstance().getVouchers().add(new Voucher());
	}

	private void addVessel() {
		String type = String.valueOf(AddVesselPanel.getInstance().getTypesCbx().getSelectedItem());
		String brand = String.valueOf(AddVesselPanel.getInstance().getBrandsCbx().getSelectedItem());
		Double volume = Double
				.parseDouble(String.valueOf(AddVesselPanel.getInstance().getVolumesCbx().getSelectedItem()));

		DrinkingVessel vessel = null;
		if (type.equals("Dose")) {
			vessel = new Can(type, brand, volume);
		} else if (type.equals("Glas")) {
			vessel = new GlassBottle(type, brand, volume);
		} else if (type.equals("Plastik")) {
			vessel = new PlasticBottle(type, brand, volume);
		}

		getActiveVoucher().addVessel(vessel);
		Depoistautomat.getInstance().addDrinkingVessel(vessel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == LangPanel.getInstance().getEnIcon()) {
			PropertyHandler.getInstance().setLang(LanguageEnum.ENGLISH);
		} else if (e.getSource() == LangPanel.getInstance().getGerIcon()) {
			PropertyHandler.getInstance().setLang(LanguageEnum.GERMAN);
		}
	}

	/**
	 * <p>
	 * This method is called, if the language gets changed from within the
	 * LangPanel.
	 * </p>
	 */
	private void changeLang() {
		for (IPanel pnl : panels) {
			pnl.changeLang();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// not needed
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// not needed
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == TitleBarPanel.getInstance()) {
			appCords = e.getPoint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == TitleBarPanel.getInstance()) {
			appCords = null;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point currCords = e.getLocationOnScreen();

		EntrypointDPAutomat.getInstance().setLocation(currCords.x - appCords.x, currCords.y - appCords.y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// not needed
	}

	public static MainController getInstance() {
		return mainController;
	}
}
