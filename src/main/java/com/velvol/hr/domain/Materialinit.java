package com.velvol.hr.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

//物料初始化对象
public class Materialinit {

	private Long id; //数据库自增ID
	private String preworkerid;
	private String name; //物料名称
	private String sort;//物料类型：衣服：冬秋季 ；头盔冬秋季，外卖箱：大中小，            //工牌：有无
	private String newold;//物料的新旧程度
	private String remark;//如果是半新、旧,则说明破损地方等备注信息
	private int ishas; //是否缺货，0:不缺货，-1缺货，默认是不缺货	
	private int putstate;//发放状态 0:未发放，1：发放     培训费：0：已扣除，1：未扣除  保险：0：未交纳
	private Date putdate; //发放日期	
	private String sputdate;//发放日期字符串
	private String broker;//经手人
	private int type;  //物料的类型：0：头盔、1：上衣；2：外卖箱 3：工牌；4：健康证；5：电动车；6：培训费；7：保险；8：劳动合同
	
	private String yardage; //物料规格尺码：主要是指衣服
		
	//后续离职处理用到
	private int isback;    //是否已归还（0:未归还、1:已归还）
	private int backtype;   //归还方式（0:未归还、1:正常归还、2:丢失赔偿、3:折旧赔偿 4：无需归还）	
	private String handledesc; //赔偿处理说明	
	private Date backdate; //归还日期
	private String sbackdate;
	private String backremark;
	private Float pcjin=0f;   //赔偿金额
	
	//培训费、个人保险处理结果：0:未处理     培训费：1：退回 ；2：不退回  ；保险：1：扣除，2：不扣除
	private int feetype=0;
	
	
	public Float getPcjin() {
		return pcjin;
	}

	public void setPcjin(Float pcjin) {
		this.pcjin = pcjin;
	}

	public int getFeetype() {
		return feetype;
	}

	public void setFeetype(int feetype) {
		this.feetype = feetype;
	}

	public String getBackremark() {
		return backremark;
	}

	public void setBackremark(String backremark) {
		this.backremark = backremark;
	}

	public String getSbackdate() {		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		if(backdate !=null)
	  	    sbackdate=sdf.format(backdate);  
		return sbackdate;
	}

	public void setSbackdate(String sbackdate) {
		this.sbackdate = sbackdate;
	}

	public String getSputdate() {		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		if(putdate !=null)
			sputdate=sdf.format(putdate);  
		return sputdate;		
	}

	public void setSputdate(String sputdate) {
		this.sputdate = sputdate;
	}

	
	public Materialinit() {		
	}

	//初始化数据用构造函数，当添加骑手时，自动添加	
	public Materialinit(String preworkerid, String name, int type) {		
		this.preworkerid = preworkerid;
		this.name = name;
		this.type = type;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPreworkerid() {
		return preworkerid;
	}
	public void setPreworkerid(String preworkerid) {
		this.preworkerid = preworkerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getNewold() {
		return newold;
	}
	public void setNewold(String newold) {
		this.newold = newold;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getIshas() {
		return ishas;
	}
	public void setIshas(int ishas) {
		this.ishas = ishas;
	}
	public int getPutstate() {
		return putstate;
	}
	public void setPutstate(int putstate) {
		this.putstate = putstate;
	}
	public Date getPutdate() {
		return putdate;
	}
	public void setPutdate(Date putdate) {
		this.putdate = putdate;
	}
	public String getBroker() {
		return broker;
	}
	public void setBroker(String broker) {
		this.broker = broker;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getYardage() {
		return yardage;
	}
	public void setYardage(String yardage) {
		this.yardage = yardage;
	}
	public int getIsback() {
		return isback;
	}
	public void setIsback(int isback) {
		this.isback = isback;
	}
	public int getBacktype() {
		return backtype;
	}
	public void setBacktype(int backtype) {
		this.backtype = backtype;
	}
	public String getHandledesc() {
		return handledesc;
	}
	public void setHandledesc(String handledesc) {
		this.handledesc = handledesc;
	}
	public Date getBackdate() {
		return backdate;
	}
	public void setBackdate(Date backdate) {
		this.backdate = backdate;
	}
		
}
