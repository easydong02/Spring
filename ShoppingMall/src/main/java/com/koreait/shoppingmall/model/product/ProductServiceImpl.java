package com.koreait.shoppingmall.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.shoppingmall.domain.Product;
import com.koreait.shoppingmall.domain.ProductImg;
import com.koreait.shoppingmall.exception.ProductException;
import com.koreait.shoppingmall.exception.ProductImgException;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ProductImgDAO productImgDAO;
	

	@Override
	public List selectAll() {
		return productDAO.selectAll();
	}

	@Override
	public Product select(int product_id) {
		return productDAO.select(product_id);
	}

	//적어도 상품 등록이란? product + product_img + 이미지업로드
	public void regist(Product product , List<ProductImg> productImgList) throws ProductException, ProductImgException {
		//product_id =0
		productDAO.insert(product);//상품정보
		//product_id = 최근에 들어간 값
		
		
		for(ProductImg obj :productImgList) {
			//pk값을 채워넣자!
			obj.setProduct(product); //productImg가 필요로 하는 부모의 객체를 대입!!
			obj.getProduct().setProduct_id(product.getProduct_id());
			productImgDAO.insert(obj);//상품 이미지
		}
	}

	@Override
	public void update(Product product) throws ProductException {
		productDAO.update(product);
	}

	@Override
	public void delete(int product_id) throws ProductException{
		productDAO.delete(product_id);
	}

	@Override
	public List selectAllByCategory(int category_id) {
		return productDAO.selectAllByCategory(category_id);
	}

}
