/**
 * 
 */
package com.koreait.shoppingmall.model.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.shoppingmall.domain.Category;
import com.koreait.shoppingmall.exception.CategoryException;

/**
 * @author easyd
 *
 */

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public List selectAll() {
		return categoryDAO.selectAll();
	}

	@Override
	public Category select(int category_id) {
		return categoryDAO.select(category_id);
	}

	@Override
	public void insert(Category category) {
		categoryDAO.insert(category);
		categoryDAO.updateTeam(category.getTeam());
	}

	@Override
	public void update(Category category) {
	}

	@Override
	public void delete(int category_id) {
	}

	@Override
	public void registSub(Category category) throws CategoryException {
		categoryDAO.updateStep(category);
		categoryDAO.insertSub(category);
	}

}
