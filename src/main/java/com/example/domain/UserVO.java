package com.example.domain;

public class UserVO{
	private String uid;
	private String upass;
	private int point;
	private int sendcnt;
	private int rececnt;
	private String uname;
	private String image;
	private String zipcode;
	private String address;
	private String address2;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getSendcnt() {
		return sendcnt;
	}
	public void setSendcnt(int sendcnt) {
		this.sendcnt = sendcnt;
	}
	public int getRececnt() {
		return rececnt;
	}
	public void setRececnt(int rececnt) {
		this.rececnt = rececnt;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", upass=" + upass + ", point=" + point + ", sendcnt=" + sendcnt + ", rececnt="
				+ rececnt + ", uname=" + uname + ", image=" + image + ", zipcode=" + zipcode + ", address=" + address
				+ ", address2=" + address2 + "]";
	}
	
	
}
