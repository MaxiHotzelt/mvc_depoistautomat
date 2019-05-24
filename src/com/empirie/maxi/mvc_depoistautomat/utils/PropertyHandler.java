package com.empirie.maxi.mvc_depoistautomat.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JComboBox;

/**
 * <p>
 * This class handles everything that is correlated to properties, such as
 * loading properties or getting values out of them.
 * </p>
 * 
 * @author hotzelm
 * @version 1.0
 * 
 * @see Properties
 */
public class PropertyHandler {

	private static PropertyHandler propsHandler = new PropertyHandler();

	private Properties vesselProps = new Properties();
	private Properties settingsProps = new Properties();
	private Properties messagesBundleProps = new Properties();

	/**
	 * <p>
	 * The language the GUI of the automat is displayed in.
	 * </p>
	 */
	private LanguageEnum lang;

	private PropertyHandler() {
		loadProperties();
		initLanguage();
	}

	private void loadProperties() {
		String vesselPath = "/properties/vessels.properties";
		String settingsPath = "/properties/settings.properties";
		String messagesBundlePath = "/properties/messagesBundle.properties";
		try {
			vesselProps.load(getClass().getResourceAsStream(vesselPath));
			settingsProps.load(getClass().getResourceAsStream(settingsPath));
			messagesBundleProps.load(getClass().getResourceAsStream(messagesBundlePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * This method gets the 'settings.properties', which has the default language
	 * stored. It sets the 'lang' attribute according to the default language.
	 * </p>
	 * 
	 * @see Properties
	 * @see Enum
	 */
	private void initLanguage() {
		if (messagesBundleProps.getProperty("depoistautomat.language.default").equals("de")) {
			lang = LanguageEnum.GERMAN;
		} else if (messagesBundleProps.getProperty("depoistautomat.language.default").equals("en")) {
			lang = LanguageEnum.ENGLISH;
		}
	}

	/**
	 * <p>
	 * This Method loads the text from a properties file, that needs to be displayed
	 * in the GUI. The language of the text is dependet of current active language,
	 * which is saved in the 'lang' enum.
	 * </p>
	 * 
	 * @param key - The searched key (without the language key)
	 * @return Text that needs to be displayed
	 * 
	 * @see Enum
	 */
	public String getDisplayText(String key) {
		String langKey;
		if (lang == LanguageEnum.GERMAN) {
			langKey = "de";
		} else {
			langKey = "en";
		}

		return messagesBundleProps.getProperty(key + "." + langKey);
	}

	public List<String> getVesselInfo(JComboBox<String> cbox, String brand, String vol, String type, String comboBox) {
		ArrayList<String> values = new ArrayList<>();
		String langKey;
		if (lang == LanguageEnum.GERMAN) {
			langKey = "de";
		} else {
			langKey = "en";
		}
		for (Map.Entry<Object, Object> entry : vesselProps.entrySet()) {
			String key = entry.getKey().toString();
			if (brand == null && vol == null && type == null && comboBox.equals("types")) {
				if (key.contains("type") && !key.contains("volume") && !key.contains("brand")
						&& key.contains(langKey)) {
					String value = entry.getValue().toString();
					cbox.addItem(value);
				}
			} else if (brand == null && vol == null && type == null && comboBox.equals("brands")) {
				if (key.contains("brand") && !key.contains("volume") && !key.contains("type")
						&& !key.contains(langKey)) {
					String value = entry.getValue().toString();
					cbox.addItem(value);
				}
			} else if (brand == null && vol == null && type == null && comboBox.equals("volumes")) {
				if (!key.contains("brand") && key.contains("volume") && !key.contains("type")
						&& !key.contains(langKey)) {
					String value = entry.getValue().toString();
					cbox.addItem(value);
				}
			}

		}
		return values;
	}

	public static PropertyHandler getInstance() {
		return propsHandler;
	}

	public Properties getVesselProps() {
		return vesselProps;
	}

	public Properties getSettingsProps() {
		return settingsProps;
	}

	public LanguageEnum getLang() {
		return lang;
	}

	public void setLang(LanguageEnum lang) {
		this.lang = lang;
	}

}
