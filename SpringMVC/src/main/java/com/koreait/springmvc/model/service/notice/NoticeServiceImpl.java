package com.koreait.springmvc.model.service.notice;

import java.util.List;

import com.koreait.springmvc.domain.Notice;
import com.koreait.springmvc.model.repository.notice.NoticeDAO;

public class NoticeServiceImpl implements NoticeService {
	//DAO에게 일을 시키기 위해 DAO를 has a로 보유하자!!
	//하지만, 보유는 하되 느슨한 결합으로 보유해야 한다.
	
	private NoticeDAO noticeDAO;
	
	//외부의 컨테이너로 하여금, NoticeDAO의 인스턴스를 주입받기 위해 setter를 준비해놓자!!
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	@Override
	public List selectAll() {
		
		return noticeDAO.selectAll();
	}

	@Override
	public int insert(Notice notice) {
		int result=0;
		result = noticeDAO.insert(notice);
		return result;
	}

	@Override
	public Notice select(int notice_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int notice_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
