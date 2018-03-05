package com.velvol.hr.domain;

import java.util.Date;

//用来接收物料发放的数据：只用来模型驱动，不同数据库表关联
public class Materialmodel {

	private String  id; //骑手ID 一定不能是LONG，否则模型驱动出错，会接收不到数据，或action类不存在错误
	private int type;//0：头盔、1：上衣；2：外卖箱 3：工牌；4：健康证；5：电动车；6：培训费；7：保险；8：劳动合同
	
	//0：头盔
	private String tksort;
	private String tknewold;
	private String tkremark;
	private int tkishas;
	private Date tkputdate; 
	private String  stkputdate; 
	
	//1:上衣
	private String sysort;
	private String synewold;
	private String syremark;
	private int syishas;
	private Date syputdate; 
	private String  ssyputdate; 
	
	//2:外卖箱
	private String wmxsort;
	private String wmxnewold;
	private String wmxremark;
	private int wmxishas;
	private Date wmxputdate; 
	private String  swmxputdate; 
	
	//3:工牌
	private int gpputstate;
	private String gpnewold;
	private String gpremark;
	private int gpishas;
	private Date gpputdate; 
	private String  sgpputdate; 
	
	//4:健康证
	private int jkzputstate;	
	private String jkzremark;
	private int jkzishas;
	private Date jkzputdate; 
	private String  sjkzputdate; 
	
	//5:电动车
	private String ddcsort;
	private String ddcnewold;
	private String ddcremark;
	private int ddcishas;
	private Date ddcputdate; 
	private String  sddcputdate; 
	
	//6:培训费
	private int pxputstate;
	private String pxnewold;
	private String pxremark;
	private int pxishas;
	private Date pxputdate; 
	private String  spxputdate;
	
	//7:保险
	private int bxputstate;
	private String bxnewold;
	private String bxremark;
	private int bxishas;
	private Date bxputdate; 
	private String  sbxputdate; 
	
	//8:劳动合同
	private int htputstate;
	private String htnewold;
	private String htremark;
	private int htishas;
	private Date htputdate; 
	private String  shtputdate; 
	

	public String getWmxsort() {
		return wmxsort;
	}
	public void setWmxsort(String wmxsort) {
		this.wmxsort = wmxsort;
	}
	public String getWmxnewold() {
		return wmxnewold;
	}
	public void setWmxnewold(String wmxnewold) {
		this.wmxnewold = wmxnewold;
	}
	public String getWmxremark() {
		return wmxremark;
	}
	public void setWmxremark(String wmxremark) {
		this.wmxremark = wmxremark;
	}
	public int getWmxishas() {
		return wmxishas;
	}
	public void setWmxishas(int wmxishas) {
		this.wmxishas = wmxishas;
	}
	public Date getWmxputdate() {
		return wmxputdate;
	}
	public void setWmxputdate(Date wmxputdate) {
		this.wmxputdate = wmxputdate;
	}
	public String getSwmxputdate() {
		return swmxputdate;
	}
	public void setSwmxputdate(String swmxputdate) {
		this.swmxputdate = swmxputdate;
	}
	public int getJkzputstate() {
		return jkzputstate;
	}
	public void setJkzputstate(int jkzputstate) {
		this.jkzputstate = jkzputstate;
	}
	public String getJkzremark() {
		return jkzremark;
	}
	public void setJkzremark(String jkzremark) {
		this.jkzremark = jkzremark;
	}
	public int getJkzishas() {
		return jkzishas;
	}
	public void setJkzishas(int jkzishas) {
		this.jkzishas = jkzishas;
	}
	public Date getJkzputdate() {
		return jkzputdate;
	}
	public void setJkzputdate(Date jkzputdate) {
		this.jkzputdate = jkzputdate;
	}
	public String getSjkzputdate() {
		return sjkzputdate;
	}
	public void setSjkzputdate(String sjkzputdate) {
		this.sjkzputdate = sjkzputdate;
	}
	public String getDdcsort() {
		return ddcsort;
	}
	public void setDdcsort(String ddcsort) {
		this.ddcsort = ddcsort;
	}
	public String getDdcnewold() {
		return ddcnewold;
	}
	public void setDdcnewold(String ddcnewold) {
		this.ddcnewold = ddcnewold;
	}
	public String getDdcremark() {
		return ddcremark;
	}
	public void setDdcremark(String ddcremark) {
		this.ddcremark = ddcremark;
	}
	public int getDdcishas() {
		return ddcishas;
	}
	public void setDdcishas(int ddcishas) {
		this.ddcishas = ddcishas;
	}
	public Date getDdcputdate() {
		return ddcputdate;
	}
	public void setDdcputdate(Date ddcputdate) {
		this.ddcputdate = ddcputdate;
	}
	public String getSddcputdate() {
		return sddcputdate;
	}
	public void setSddcputdate(String sddcputdate) {
		this.sddcputdate = sddcputdate;
	}
	public int getBxputstate() {
		return bxputstate;
	}
	public void setBxputstate(int bxputstate) {
		this.bxputstate = bxputstate;
	}
	public String getBxnewold() {
		return bxnewold;
	}
	public void setBxnewold(String bxnewold) {
		this.bxnewold = bxnewold;
	}
	public String getBxremark() {
		return bxremark;
	}
	public void setBxremark(String bxremark) {
		this.bxremark = bxremark;
	}
	public int getBxishas() {
		return bxishas;
	}
	public void setBxishas(int bxishas) {
		this.bxishas = bxishas;
	}
	public Date getBxputdate() {
		return bxputdate;
	}
	public void setBxputdate(Date bxputdate) {
		this.bxputdate = bxputdate;
	}
	public String getSbxputdate() {
		return sbxputdate;
	}
	public void setSbxputdate(String sbxputdate) {
		this.sbxputdate = sbxputdate;
	}
	public int getHtputstate() {
		return htputstate;
	}
	public void setHtputstate(int htputstate) {
		this.htputstate = htputstate;
	}
	public String getHtnewold() {
		return htnewold;
	}
	public void setHtnewold(String htnewold) {
		this.htnewold = htnewold;
	}
	public String getHtremark() {
		return htremark;
	}
	public void setHtremark(String htremark) {
		this.htremark = htremark;
	}
	public int getHtishas() {
		return htishas;
	}
	public void setHtishas(int htishas) {
		this.htishas = htishas;
	}
	public Date getHtputdate() {
		return htputdate;
	}
	public void setHtputdate(Date htputdate) {
		this.htputdate = htputdate;
	}
	public String getShtputdate() {
		return shtputdate;
	}
	public void setShtputdate(String shtputdate) {
		this.shtputdate = shtputdate;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTkremark() {
		return tkremark;
	}
	public void setTkremark(String tkremark) {
		this.tkremark = tkremark;
	}
	public String getSyremark() {
		return syremark;
	}
	public void setSyremark(String syremark) {
		this.syremark = syremark;
	}
	
	public String getGpnewold() {
		return gpnewold;
	}
	public void setGpnewold(String gpnewold) {
		this.gpnewold = gpnewold;
	}
	public String getGpremark() {
		return gpremark;
	}
	public void setGpremark(String gpremark) {
		this.gpremark = gpremark;
	}
	public int getGpishas() {
		return gpishas;
	}
	public void setGpishas(int gpishas) {
		this.gpishas = gpishas;
	}
	public Date getGpputdate() {
		return gpputdate;
	}
	public void setGpputdate(Date gpputdate) {
		this.gpputdate = gpputdate;
	}
	public String getSgpputdate() {
		return sgpputdate;
	}
	public void setSgpputdate(String sgpputdate) {
		this.sgpputdate = sgpputdate;
	}
	
	public int getGpputstate() {
		return gpputstate;
	}
	public void setGpputstate(int gpputstate) {
		this.gpputstate = gpputstate;
	}
	
	public int getPxputstate() {
		return pxputstate;
	}
	public void setPxputstate(int pxputstate) {
		this.pxputstate = pxputstate;
	}
	public String getPxnewold() {
		return pxnewold;
	}
	public void setPxnewold(String pxnewold) {
		this.pxnewold = pxnewold;
	}
	public String getPxremark() {
		return pxremark;
	}
	public void setPxremark(String pxremark) {
		this.pxremark = pxremark;
	}
	public int getPxishas() {
		return pxishas;
	}
	public void setPxishas(int pxishas) {
		this.pxishas = pxishas;
	}
	public Date getPxputdate() {
		return pxputdate;
	}
	public void setPxputdate(Date pxputdate) {
		this.pxputdate = pxputdate;
	}
	public String getSpxputdate() {
		return spxputdate;
	}
	public void setSpxputdate(String spxputdate) {
		this.spxputdate = spxputdate;
	}
	public String getStkputdate() {
		return stkputdate;
	}
	public void setStkputdate(String stkputdate) {
		this.stkputdate = stkputdate;
	}
	public String getSsyputdate() {
		return ssyputdate;
	}
	public void setSsyputdate(String ssyputdate) {
		this.ssyputdate = ssyputdate;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTkputdate() {
		return tkputdate;
	}
	public void setTkputdate(Date tkputdate) {
		this.tkputdate = tkputdate;
	}
	public Date getSyputdate() {
		return syputdate;
	}
	public void setSyputdate(Date syputdate) {
		this.syputdate = syputdate;
	}
	public String getTknewold() {
		return tknewold;
	}
	public void setTknewold(String tknewold) {
		this.tknewold = tknewold;
	}
	
	public int getTkishas() {
		return tkishas;
	}
	public void setTkishas(int tkishas) {
		this.tkishas = tkishas;
	}
	public String getSynewold() {
		return synewold;
	}
	public void setSynewold(String synewold) {
		this.synewold = synewold;
	}
	
	public int getSyishas() {
		return syishas;
	}
	public void setSyishas(int syishas) {
		this.syishas = syishas;
	}
	public String getTksort() {
		return tksort;
	}
	public void setTksort(String tksort) {
		this.tksort = tksort;
	}
	public String getSysort() {
		return sysort;
	}
	public void setSysort(String sysort) {
		this.sysort = sysort;
	}
		
}
