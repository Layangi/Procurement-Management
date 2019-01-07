package net.asd.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {

	@Column(name = "id")
	private int Id; //purchase order Id		
	@Column(name = "DelId")
	private int Delid; //deliveryId
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ItmId; //AcceptId
	private String itemN;
	private int quantity;
    @Column(name="is_matched")
	private boolean matched;
    
	@Override
	public String toString() {
		return "Item [Id=" + Id + ", Delid=" + Delid + ", ItmId=" + ItmId + ", itemN=" + itemN + ", quantity="
				+ quantity + ", matched=" + matched + "]";
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
	public int getItmId() {
		return ItmId;
	}
	public void setItmId(int itmId) {
		ItmId = itmId;
	}
	public String getItemN() {
		return itemN;
	}
	public void setItemN(String itemN) {
		this.itemN = itemN;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isMatched() {
		return matched;
	}
	public void setMatched(boolean matched) {
		this.matched = matched;
	}
    
    
	
}
