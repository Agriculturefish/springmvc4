package com.nyown.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ItemsVO {
	   private int id;
	   private String name;
	   private float price;
	   private String detail;
	   private String pic;
	   @DateTimeFormat( pattern = "yyyy-MM-dd" )  
	   private Date createtime;
	   private String starttime;
	   
		public String getStarttime() {
		return starttime;
		}
		public void setStarttime(String starttime) {
			this.starttime = starttime;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		public String getPic() {
			return pic;
		}
		public void setPic(String pic) {
			this.pic = pic;
		}
		public Date getCreatetime() {
			return createtime;
		}
		public void setCreatetime(Date createtime) {
			this.createtime = createtime;
		}
}
