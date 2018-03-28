package com.neusoft.dao;

import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;

/**
 * �û���ַ����
 * */
	
public interface AddressDao {
/**
 * ����û��ջ���ַ
 * @param  userid  �û�id
 * @param address ��ַ����
 * @return int
 * */
	int addAddress(Integer userid,Address address);
	
	/**
	 * ɾ���û���ַ
	 * @param userid  �û�id
	 * @param id ��ַid
	 * */
	int deleteAddressByUserid(Integer userid,Integer id);
	
	Address findAddressByid(Integer id,Integer userid);
	/**
	 * �޸��ջ���ַ
	 * @param userid
	 * @param address ��Ҫ�޸ĵ�address
	 * */
	int updateAddressByUserid(Integer userid,Address address);
	
	/**
	 * ��ѯ�û��ջ���ַ
	 * */
	PageModel<Address>  findUserAddress(Integer pageNo,Integer pageSize,Integer userid);
}
