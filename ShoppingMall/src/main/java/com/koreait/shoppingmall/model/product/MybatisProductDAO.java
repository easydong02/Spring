/**
 * 
 */
package com.koreait.shoppingmall.model.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.shoppingmall.domain.Product;
import com.koreait.shoppingmall.exception.ProductException;
import com.koreait.shoppingmall.exception.UploadException;

/**
 * @author easyd
 *
 */
@Repository
public class MybatisProductDAO implements ProductDAO {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public Product select(int product_id) {
		return null;
	}

	@Override
	public void insert(Product product) throws ProductException{
		int result = sessionTemplate.insert("Product.insert",product);
		if(result ==0) {
			throw new UploadException("상품등록실패");
		}
	}

	@Override
	public void update(Product product) {
	}

	@Override
	public void delete(int product_id) {
	}

}
