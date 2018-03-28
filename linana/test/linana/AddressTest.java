package linana;

import org.junit.Test;

import com.neusoft.daoImp.AddressdaoImpl;
import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;

public class AddressTest {
	
public void testaddAddress() {
	AddressdaoImpl addressdao=AddressdaoImpl.getInstance();
	Address address=new Address();
	address.setId(3);
	address.setReceiver_address("山西省太原市杏花岭区");
	address.setReceiver_mobile("12390293");
	address.setReceiver_name("zhangsan");
	int result=addressdao.addAddress(2, address);
	System.out.println("result="+result);
}

	public void testdeleteAddressByUserid() {
	AddressdaoImpl addressdao=AddressdaoImpl.getInstance();
	addressdao.deleteAddressByUserid(null, 1);
	}
	
public void testupdateAddressByUserid() {
		AddressdaoImpl addressdao=AddressdaoImpl.getInstance();
		Address address=new Address();
		address.setId(2);
		address.setReceiver_address("山西省太原市fgd迎泽区");
		address.setReceiver_mobile("128372293");
		address.setReceiver_name("xiaoming");
		addressdao.updateAddressByUserid(2, address);
}
@Test
public void testfindUserAddress() {
	AddressdaoImpl addressdao=AddressdaoImpl.getInstance();
	PageModel<Address> pagemodel=addressdao.findUserAddress(1, 2, 2);
	System.out.println(pagemodel);
}

public void testfindAddressByid() {
	AddressdaoImpl addressdao=AddressdaoImpl.getInstance();
	Address address=addressdao.findAddressByid(1, 2);
	System.out.println(address);
}
}
