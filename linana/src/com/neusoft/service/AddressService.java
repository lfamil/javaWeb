package com.neusoft.service;

import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;

public interface AddressService {
	int addAddress(Integer userid,Address address);
int deleteAddressByUserid(Integer userid,Integer id);
	
	Address findAddressByid(Integer id,Integer userid);
	int updateAddressByUserid(Integer userid,Address address);
	PageModel<Address>  findUserAddress(Integer pageNo,Integer pageSize,Integer userid);
}
