package linana;

import org.junit.Test;

import com.neusoft.dao.Productdao;
import com.neusoft.daoImp.ProductDaoBatisImpl;

public class ProductTest {
@Test
	public void testsearchProduct() {
		Productdao productdao=new ProductDaoBatisImpl();
		System.out.println(productdao.searchProduct("¾ÆË®"));
	}
}
