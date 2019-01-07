package net.asd.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;



@Entity
public class Accept {
	
	@Column(name = "id")
//	@NotBlank(message ="Please Enter Purchase Order Id")
	private int Id; //purchase order Id	
	@Column(name = "DelId")
//	@NotBlank(message ="Please Enter Delivery Order Id")
	private int Delid; //deliveryId
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int AcpId; //AcceptId
	@NotBlank(message ="Please select a status")
	private String status;
    @NotBlank(message ="Please select a date")
	private String deDate;
	
	@Override
	public String toString() {
		return "Accept [Id=" + Id + ", Delid=" + Delid + ", AcpId=" + AcpId + ", status=" + status + ", deDate="
				+ deDate + "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getDelid() {
		return Delid;
	}
	public void setDelid(int delid) {
		Delid = delid;
	}
	public int getAcpId() {
		return AcpId;
	}
	public void setAcpId(int acpId) {
		AcpId = acpId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDeDate() {
		return deDate;
	}
	public void setDeDate(String deDate) {
		this.deDate = deDate;
	}
	
	

}
