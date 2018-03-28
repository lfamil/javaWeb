package com.neusoft.serviceImp;

import com.neusoft.dao.AddressDao;
import com.neusoft.daoImp.AddressdaoImpl;
import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;
import com.neusoft.service.AddressService;

public class AddressServiceImpl implements AddressService {
AddressDao addressdao=AddressdaoImpl.getInstance();
	@Override
	public int addAddress(Integer userid, Address address) {
		// TODO Auto-generated method stub
		
		return addressdao.addAddress(userid, address);
	}

	@Override
	public int deleteAddressByUserid(Integer userid, Integer id) {
		// TODO Auto-generated method stub
		return addressdao.deleteAddressByUserid(userid, id);
	}

	@Override
	public Address findAddressByid(Integer id, Integer userid) {
		// TODO Auto-generated method stub
		return addressdao.findAddressByid(id, userid);
	}

	@Override
	public int updateAddressByUserid(Integer userid, Address address) {
		// TODO Auto-generated method stub
		return addressdao.updateAddressByUserid(userid, address);
	}

	@Override
	public PageModel<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer userid) {
		// TODO Auto-generated method stub
		return addressdao.findUserAddress(pageNo, pageSize, userid);
	}

}
