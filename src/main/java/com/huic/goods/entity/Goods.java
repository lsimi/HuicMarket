package com.huic.goods.entity;

import java.util.Date;
import java.util.List;

import com.huic.store.entity.Store;

public class Goods {
    private Integer gId;

    private String gName;

    private Integer cateId;

    private String gImg;

    private Long gSalenum;

    private Date gUptime;

    private Integer gStatus;

    private Date gDowntime;

    private Integer sId;

    private String gDetail;
    
    //关联店铺
    private Store store;
    
    //关联商品详情表
    private List<Goodsdetail> goodsdetails;
    
    private List<GooodsDetailImg> imgs;
    
    
    
    public List<GooodsDetailImg> getImgs() {
		return imgs;
	}

	public void setImgs(List<GooodsDetailImg> imgs) {
		this.imgs = imgs;
	}

	public List<Goodsdetail> getGoodsdetails() {
		return goodsdetails;
	}

	public void setGoodsdetails(List<Goodsdetail> goodsdetails) {
		this.goodsdetails = goodsdetails;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getgImg() {
        return gImg;
    }

    public void setgImg(String gImg) {
        this.gImg = gImg == null ? null : gImg.trim();
    }

    public Long getgSalenum() {
        return gSalenum;
    }

    public void setgSalenum(Long gSalenum) {
        this.gSalenum = gSalenum;
    }

    public Date getgUptime() {
        return gUptime;
    }

    public void setgUptime(Date gUptime) {
        this.gUptime = gUptime;
    }

    public Integer getgStatus() {
        return gStatus;
    }

    public void setgStatus(Integer gStatus) {
        this.gStatus = gStatus;
    }

    public Date getgDowntime() {
        return gDowntime;
    }

    public void setgDowntime(Date gDowntime) {
        this.gDowntime = gDowntime;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getgDetail() {
        return gDetail;
    }

    public void setgDetail(String gDetail) {
        this.gDetail = gDetail == null ? null : gDetail.trim();
    }

	@Override
	public String toString() {
		return "Goods [gId=" + gId + ", gName=" + gName + ", cateId=" + cateId + ", gImg=" + gImg + ", gSalenum="
				+ gSalenum + ", gUptime=" + gUptime + ", gStatus=" + gStatus + ", gDowntime=" + gDowntime + ", sId="
				+ sId + ", gDetail=" + gDetail + "]";
	}
    
    
}