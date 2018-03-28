package com.neusoft.serviceImp;

import java.util.List;

import com.neusoft.dao.Catedao;
import com.neusoft.daoImp.CatedaoImpl;
import com.neusoft.entity.Cate;
import com.neusoft.service.CateService;

public class CateServiceImpl implements CateService {

	@Override
	public List<Cate> findAllcate() {
		// TODO Auto-generated method stub
		Catedao cated=new CatedaoImpl();
		return cated.findAllcate();
	}

}
