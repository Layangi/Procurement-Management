package net.asd.shoppingbackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
	//private fields
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int ID;
			public int getID() {
				return ID;
			}
			public void setID(int iD) {
				ID = iD;
			}
			public int getOID() {
				return OID;
			}
			public void setOID(int oID) {
				OID = oID;
			}
			public String getSUPPLIER() {
				return SUPPLIER;
			}
			public void setSUPPLIER(String sUPPLIER) {
				SUPPLIER = sUPPLIER;
			}
			public double getAMOUNT() {
				return AMOUNT;
			}
			public void setAMOUNT(double aMOUNT) {
				AMOUNT = aMOUNT;
			}
			public boolean isPAID() {
				return PAID;
			}
			public void setPAID(boolean pAID) {
				PAID = pAID;
			}
			
			
			@Override
			public String toString() {
				return "Payment [ID=" + ID + ", OID=" + OID + ", SUPPLIER=" + SUPPLIER + ", AMOUNT=" + AMOUNT
						+ ", PAID=" + PAID + "]";
			}
			
			private int OID;
			
			private String SUPPLIER;
			private double AMOUNT;
			private boolean PAID;
}
