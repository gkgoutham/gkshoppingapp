package com.gk.app.shopping.service;

import java.util.List;

import com.gk.app.shopping.bean.Partner;
import com.gk.app.shopping.bean.Users;

public interface PartnerService {

	Partner createPartner(Users user);
	
	Partner updatePartner(Users user);
	 
    List<Users> findAllPartners();
 
    Users findPartner(String name);
 
    boolean approvePartner(Partner partner);
    
    boolean rejectPartner(Partner partner);
    
    boolean disablePartner(Partner partner);
    
    boolean enablePartner(Partner partner);
    
}
