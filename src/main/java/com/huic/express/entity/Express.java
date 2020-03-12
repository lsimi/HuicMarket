package com.huic.express.entity;

public class Express {
    private Integer expressId;

    private String expressName;

    private String expressDetail;

    private String expressImg;

    public Integer getExpressId() {
        return expressId;
    }

    public void setExpressId(Integer expressId) {
        this.expressId = expressId;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    public String getExpressDetail() {
        return expressDetail;
    }

    public void setExpressDetail(String expressDetail) {
        this.expressDetail = expressDetail == null ? null : expressDetail.trim();
    }

    public String getExpressImg() {
        return expressImg;
    }

    public void setExpressImg(String expressImg) {
        this.expressImg = expressImg == null ? null : expressImg.trim();
    }

	@Override
	public String toString() {
		return "Express [expressId=" + expressId + ", expressName=" + expressName + ", expressDetail=" + expressDetail
				+ ", expressImg=" + expressImg + "]";
	}
    
}