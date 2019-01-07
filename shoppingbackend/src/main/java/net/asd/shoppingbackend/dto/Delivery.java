package net.asd.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Delivery {

	//@NotBlank(message ="Please Enter Purchase Order Id")
	//purchase order Id	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="delid")
	private int DelId; //Delivery Id 
	@Column(name = "id") 
	private int Id; 
	@NotBlank(message ="Please Select a branch")
	private String branch;
	@NotBlank(message ="Please Enter Branch Address")
	private String address;
	private String ddate;
	@NotBlank(message ="Please Enter Contact No")
	private String no;
	
	
	@Override
	public String toString() {
		return "Delivery [DelId=" + DelId + ", Id=" + Id + ", branch=" + branch + ", address=" + address + ", ddate="
				+ ddate + ", no=" + no + "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getDelId() {
		return DelId;
	}
	public void setDelId(int delId) {
		DelId = delId;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	

	
}
