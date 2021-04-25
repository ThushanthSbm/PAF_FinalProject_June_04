package com.java;

import java.sql.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Product {
	
	private int FID;
	private String ProductName;
	private String ProductMail;
	private int PhoneNo;
	private String Address;
	private double Amount;

	public int getFID() {
		return FID;
	}

	public void setFID(int fID) {
		FID = fID;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String ProductName) {
		ProductName = ProductName;
	}

	public String getProductMail() {
		return ProductMail;
	}

	public void setProductMail(String ProductMail ) {
		ProductMail = ProductMail;
	}

	public int getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		PhoneNo = phoneNo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	@Override
	public String toString() {
		
		return "Product [fid=" +FID + " ,ProductName=" + ProductName + ", ProductMail=" + ProductMail + ", phoneNo=" + PhoneNo
				+ ", address=" + Address +", amount=" + Amount + "]";
	}	
	
	
	

}
