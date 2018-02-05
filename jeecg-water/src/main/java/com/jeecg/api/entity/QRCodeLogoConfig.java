package com.jeecg.api.entity;

import java.awt.Color;

public class QRCodeLogoConfig {
	

	//logo默认边框颜色  
	public static final Color DEFAULT_BORDERCOLOR = Color.GRAY;
	//logo默认边框宽度  
	public static final int DEFAULT_BORDER = 1;
	//logo大小默认为照片的1/5  
	public static final int DEFAULT_LOGOPART = 4;

	private final int border;
	private final Color borderColor;
	private final int logoPart;

	/** 
	 * Creates a default config with on color #BLACK and off color 
	 * #WHITE, generating normal black-on-white barcodes. 
	 */
	public QRCodeLogoConfig() {
		this(DEFAULT_BORDERCOLOR, DEFAULT_BORDER, DEFAULT_LOGOPART);
	}

	public QRCodeLogoConfig(Color borderColor, int border, int logoPart) {
		this.borderColor = borderColor;
		this.border = border;
		this.logoPart = logoPart;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public int getBorder() {
		return border;
	}

	public int getLogoPart() {
		return logoPart;
	}

}
