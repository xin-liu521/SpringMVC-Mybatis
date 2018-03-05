package com.velvol.hr.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

//考勤统计表对象
public class Statkaoqin implements java.io.Serializable {
  private Long id;
  private Long regionid;
  private String regionname;
  private Long stationid;
  private String stationname;
  private int total=0; //人员总数
  private int kqnumber=0; //考勤人数
  private int cqnumber; //出勤人数 
  private int ncqnumber;//未出勤人数

  private int zcbnumber;//早餐班
  private int zzbnumber;//正常班
  private int yxbnumber;//夜宵班
  private int cdnumber;//迟到人数
  private int sjnumber;//事假人数
  private int bjnumber;//病假人数
  private int qqnumber;//缺勤
  private int qtnumber;//其他
  private int txnumber;//调休  
  private int bgnumber;//考勤变更记录数量或考勤变更人数   
  private Date kqdate;//考勤日期
  private String skqdate; //考勤日期字符串
	
  
  public int getBgnumber() {
	return bgnumber;
}
public void setBgnumber(int bgnumber) {
	this.bgnumber = bgnumber;
}
public int getTxnumber() {
	return txnumber;
}
public void setTxnumber(int txnumber) {
	this.txnumber = txnumber;
}
public int getZcbnumber() {
	return zcbnumber;
}
public void setZcbnumber(int zcbnumber) {
	this.zcbnumber = zcbnumber;
}
public int getZzbnumber() {
	return zzbnumber;
}
public void setZzbnumber(int zzbnumber) {
	this.zzbnumber = zzbnumber;
}
public int getYxbnumber() {
	return yxbnumber;
}
public void setYxbnumber(int yxbnumber) {
	this.yxbnumber = yxbnumber;
}
public int getQqnumber() {
	return qqnumber;
}
public void setQqnumber(int qqnumber) {
	this.qqnumber = qqnumber;
}
public int getQtnumber() {
	return qtnumber;
}
public void setQtnumber(int qtnumber) {
	this.qtnumber = qtnumber;
}
public int getSjnumber() {
	return sjnumber;
}
public void setSjnumber(int sjnumber) {
	this.sjnumber = sjnumber;
}
public int getCdnumber() {
	return cdnumber;
}
public void setCdnumber(int cdnumber) {
	this.cdnumber = cdnumber;
}
public int getBjnumber() {
	return bjnumber;
}
public void setBjnumber(int bjnumber) {
	this.bjnumber = bjnumber;
}
public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRegionid() {
		return regionid;
	}
	public void setRegionid(Long regionid) {
		this.regionid = regionid;
	}
	public String getRegionname() {
		return regionname;
	}
	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}
	public Long getStationid() {
		return stationid;
	}
	public void setStationid(Long stationid) {
		this.stationid = stationid;
	}
	public String getStationname() {
		return stationname;
	}
	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getKqnumber() {
		return kqnumber;
	}
	public void setKqnumber(int kqnumber) {
		this.kqnumber = kqnumber;
	}
	public int getCqnumber() {
		return cqnumber;
	}
	public void setCqnumber(int cqnumber) {
		this.cqnumber = cqnumber;
	}
	public int getNcqnumber() {
		return ncqnumber;
	}
	public void setNcqnumber(int ncqnumber) {
		this.ncqnumber = ncqnumber;
	}
	public Date getKqdate() {
		return kqdate;
	}
	public void setKqdate(Date kqdate) {
		this.kqdate = kqdate;
	}
	public String getSkqdate() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		if(kqdate !=null)
			skqdate=sdf.format(kqdate);  
     	return skqdate;
	}
	public void setSkqdate(String skqdate) {
		this.skqdate = skqdate;
	}
	  
  
}
