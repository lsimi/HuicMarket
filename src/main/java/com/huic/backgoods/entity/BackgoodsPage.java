package com.huic.backgoods.entity;

public class BackgoodsPage {

	private Integer sid;
	private Integer cparentid;
	private String goodsname;
	private Integer gid;
	
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getCparentid() {
		return cparentid;
	}
	public void setCparentid(Integer cparentid) {

		if(cparentid!=null&&!"".equals(cparentid))
		{
			this.cparentid = cparentid;
		}
	}
	
	public String getGoodsname() {
		return goodsname;
	}
	
	public void setGoodsname(String goodsname) {

		if(goodsname!=null&&!"".equals(goodsname))
		{
			this.goodsname = goodsname;
		}
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	@Override
	public String toString() {
		return "BackgoodsPage [sid=" + sid + ", cparentid=" + cparentid + ", goodsname=" + goodsname + "]";
	}
	

	
	
}
