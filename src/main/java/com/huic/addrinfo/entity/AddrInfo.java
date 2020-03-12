package com.huic.addrinfo.entity;

public class AddrInfo {
    private Integer addrId;

	private String addrName;

	private String addrDetail;

	private String addrPhone;

	private String addrPost;

	private Integer userId;

	private Integer addrStatus;

	private String addrProvice;

	private String addrCity;

	private String addrArea;

	public Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

	public String getAddrName() {
		return addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName == null ? null : addrName.trim();
	}

	public String getAddrDetail() {
		return addrDetail;
	}

	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail == null ? null : addrDetail.trim();
	}

	public String getAddrPhone() {
		return addrPhone;
	}

	public void setAddrPhone(String addrPhone) {
		this.addrPhone = addrPhone == null ? null : addrPhone.trim();
	}

	public String getAddrPost() {
		return addrPost;
	}

	public void setAddrPost(String addrPost) {
		this.addrPost = addrPost == null ? null : addrPost.trim();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAddrStatus() {
		return addrStatus;
	}

	public void setAddrStatus(Integer addrStatus) {
		this.addrStatus = addrStatus;
	}

	public String getAddrProvice() {
		return addrProvice;
	}

	public void setAddrProvice(String addrProvice) {
		this.addrProvice = addrProvice == null ? null : addrProvice.trim();
	}

	public String getAddrCity() {
		return addrCity;
	}

	public void setAddrCity(String addrCity) {
		this.addrCity = addrCity == null ? null : addrCity.trim();
	}

	public String getAddrArea() {
		return addrArea;
	}

	public void setAddrArea(String addrArea) {
		this.addrArea = addrArea == null ? null : addrArea.trim();
	}

    
}