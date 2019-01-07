package net.asd.shoppingbackend.dao;

import java.util.List;

import net.asd.shoppingbackend.dto.Accept;

public interface AcceptDAO {

	List <Accept> list();
	Accept get(int AcpId);
    	
	boolean add(Accept accept);
	boolean update(Accept accept);
	boolean delete(Accept accept);
	
}
