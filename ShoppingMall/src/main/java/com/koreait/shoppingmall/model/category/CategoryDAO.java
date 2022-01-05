package com.koreait.shoppingmall.model.category;

import java.util.List;

import com.koreait.shoppingmall.domain.Category;

public interface CategoryDAO {
	public List selectAll();
	public Category select(int category_id);
	public void insert(Category category);
	public void update(Category category);
	public void updateTeam(int team);
	public void delete(int category_id);
	
	
	//답변자리 확보
	public void updateStep(Category category);
	
	
	//답변 등록
	public void insertSub(Category category);
}
