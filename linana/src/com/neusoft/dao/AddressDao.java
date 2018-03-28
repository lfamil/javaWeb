package com.neusoft.dao;

import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;

/**
 * 用户地址管理
 * */
	
public interface AddressDao {
/**
 * 添加用户收货地址
 * @param  userid  用户id
 * @param address 地址对象
 * @return int
 * */
	int addAddress(Integer userid,Address address);
	
	/**
	 * 删除用户地址
	 * @param userid  用户id
	 * @param id 地址id
	 * */
	int deleteAddressByUserid(Integer userid,Integer id);
	
	Address findAddressByid(Integer id,Integer userid);
	/**
	 * 修改收货地址
	 * @param userid
	 * @param address 需要修改的address
	 * */
	int updateAddressByUserid(Integer userid,Address address);
	
	/**
	 * 查询用户收货地址
	 * */
	PageModel<Address>  findUserAddress(Integer pageNo,Integer pageSize,Integer userid);
}
