package com.empirie.maxi.mvc_depoistautomat.utils;

import javax.swing.ImageIcon;

public class ImageLoader {

	private static ImageLoader imgLoader = new ImageLoader();

	private ImageLoader() {

	}

	public ImageIcon loadImg(String imgName) {
		String imgPath = "/images/" + imgName;

		return new ImageIcon(getClass().getResource(imgPath));
	}

	public static ImageLoader getInstance() {
		return imgLoader;
	}

}
