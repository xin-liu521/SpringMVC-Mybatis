package com.infoyb.supplier.common.model;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * <dl>
 * <dt>ProjectName : infoyb-common </dt>
 * <dt>PakageName : com.infoyb.common.model </dt>
 * <dt>ClassName: BaseModel </dt>
 * <dd>CreateDate: 2017-07-21 15:02 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description:  父级实体类，对实体类的扩展，实体类需继承此类     </dd>
 * </dl>
 *
 * @author Minty
 */
public class BaseModel implements Serializable{

	@Transient
	private String sortOrder;//升序  降序
	@Transient
	private String sortName; //排序关键字
	@Transient
	private Integer pageSize; //每页显示条数
	@Transient
	private Integer pageNumber; //当前页数


	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
}
