package com.denso.common.vo;

import java.io.Serializable;

import org.springframework.util.StringUtils;

import com.denso.common.intf.Pageable;
import com.denso.common.intf.Pageable.Direction;
import com.denso.common.intf.Pageable.Order;
import com.denso.model.PageRequest;


public class PageVo implements Serializable{
	private static final long serialVersionUID = 6308008607506765494L;
	
	private int page = 0;
	private int size = 10;
	private String property;
	private String direction;
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public Pageable getPageable(){
		if(!StringUtils.isEmpty(property) && !StringUtils.isEmpty(direction)){
			return new PageRequest(page, size, new Order(property, Direction.valueOf(direction.toUpperCase())));
		} else{
			return new PageRequest(page, size);
		}
	}
	
}
