package com.empirie.maxi.mvc_depoistautomat.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;

import com.empirie.maxi.mvc_depoistautomat.utils.PropertyHandler;
import com.empirie.maxi.mvc_depoistautomat.view.panels.ContainerPanel;
import com.empirie.maxi.mvc_depoistautomat.view.panels.TitleBarPanel;

/**
 * <p>
 * This class serves as the entrypoint for the application. It loads the JFrame
 * and calls main.
 * </p>
 * 
 * @author hotzelm
 * @version 1.0
 */
@SuppressWarnings("serial")
public class EntrypointDPAutomat extends JFrame {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			changeUI();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		EntrypointDPAutomat.getInstance().setVisible(true);
	}

	private static EntrypointDPAutomat entrypoint = new EntrypointDPAutomat();

	private EntrypointDPAutomat() {
		init();
		config();
		build();
	}

	private void init() {
		// not needed atm
	}

	private void config() {
		int width = Integer.parseInt(
				PropertyHandler.getInstance().getSettingsProps().getProperty("depoistautomat.view.main.width"));
		int height = Integer.parseInt(
				PropertyHandler.getInstance().getSettingsProps().getProperty("depoistautomat.view.main.height"));

		this.setTitle("Depoist Automat");
		this.setSize(width, height);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setUndecorated(true);
		this.setLayout(new BorderLayout());
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

		// This block centers the application in the middle of all connected monitors
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gsd = ge.getScreenDevices();
		GraphicsConfiguration gc = gsd[gsd.length / 2].getDefaultConfiguration();
		Rectangle rect = gc.getBounds();

		setLocation((int) rect.getCenterX() - width / 2, (int) rect.getCenterY() - height / 2);
	}

	private void build() {
		this.add(TitleBarPanel.getInstance(), BorderLayout.NORTH);
		this.add(ContainerPanel.getInstance(), BorderLayout.CENTER);
	}

	private static void changeUI() {
		UIManager.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
		UIManager.put("ToggleButton.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
	}

	public static EntrypointDPAutomat getInstance() {
		return entrypoint;
	}

}
