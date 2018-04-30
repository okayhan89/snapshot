package com.skcc.snapshot.dto;

import java.io.Serializable;


public class SnapshotDto implements Serializable {

	private int titleMax;
    private int productNo;
    private int loadTimeout;
    private int tileHeight;
    private String url;
    private String format;
    private String prefix;
    private String imgLoc;
    private int quality;

    public SnapshotDto(){
    	
    }
    
    public SnapshotDto(int titleMax, int productNo, int loadTimeout, 
    		int tileHeight, String url, String format,
			String prefix, String imgLoc, int quality) {
		super();
		this.titleMax = titleMax;
		this.productNo = productNo;
		this.loadTimeout = loadTimeout;
		this.tileHeight = tileHeight;
		this.url = url;
		this.format = format;
		this.prefix = prefix;
		this.imgLoc = imgLoc;
		this.quality = quality;
	}
    
	public int getTitleMax() {
		return titleMax;
	}
	public void setTitleMax(int titleMax) {
		this.titleMax = titleMax;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getLoadTimeout() {
		return loadTimeout;
	}
	public void setLoadTimeout(int loadTimeout) {
		this.loadTimeout = loadTimeout;
	}
	public int getTileHeight() {
		return tileHeight;
	}
	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getImgLoc() {
		return imgLoc;
	}
	public void setImgLoc(String imgLoc) {
		this.imgLoc = imgLoc;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	@Override
	public String toString() {
		return "[titleMax=" + titleMax + ", productNo=" + productNo + ", loadTimeout=" + loadTimeout
				+ ", tileHeight=" + tileHeight + ", url=" + url + ", format=" + format + ", prefix=" + prefix
				+ ", imgLoc=" + imgLoc + ", quality=" + quality + "]";
	}

   
}