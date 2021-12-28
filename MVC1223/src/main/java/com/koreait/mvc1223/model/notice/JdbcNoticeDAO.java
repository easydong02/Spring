package com.koreait.mvc1223.model.notice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.koreait.mvc1223.domain.Notice;
import com.koreait.mvc1223.exception.NoticeException;


@Repository
public class JdbcNoticeDAO implements NoticeDAO {
	//Spring이 지원하는 DB연동기술을 이용하겠다!!
	@Autowired //DAO는 자동으로 올라와서 위빙코드 짤수 없다. 따라서 autowired로 자동으로올라간 녀석하고 위빙해준다
	private JdbcTemplate jdbcTemplate; //Connection,PreparedStatement,ResultSet을 우리 대신 내부적으로 처리
	
	
	@Override
	public List selectAll() {
		String sql="select * from notice order by notice_id desc";
		List list=jdbcTemplate.query(sql, new RowMapper<Notice>() {
			public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
				Notice notice= new Notice();
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setTitle(rs.getString("title"));
				notice.setWriter(rs.getString("writer"));
				notice.setContent(rs.getString("content"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));
				notice.setFilename(rs.getString("filename"));
				
				return notice;
			}
		});
		return list;
	}

	@Override
	public Notice select(int notice_id) {
		String sql="select * from notice where notice_id=?";
		Notice notice =jdbcTemplate.queryForObject(sql, new Object[] {notice_id}, new RowMapper<Notice>() {
			public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
				Notice notice= new Notice();
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setTitle(rs.getString("title"));
				notice.setWriter(rs.getString("writer"));
				notice.setContent(rs.getString("content"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));
				notice.setFilename(rs.getString("filename"));
				
				return notice;
			}
		});
		
		return notice;
	}

	@Override
	public void insert(Notice notice) throws NoticeException {
		String sql="insert into notice(notice_id,title,writer,content) values(seq_notice.nextval,?,?,?)";
		int result = jdbcTemplate.update(sql, notice.getTitle(),notice.getWriter(),notice.getContent());
		
		
		if(result==0) {
			throw new NoticeException("게시물 등록 실패");
		}
		
	}

	@Override
	public void update(Notice notice) {
		String sql ="update notice set title=?, writer=?, content=? where  notice_id=?";
		int result =jdbcTemplate.update(sql, notice.getTitle(),notice.getWriter(),notice.getContent(),notice.getNotice_id());
		
		if(result==0) {
			throw new NoticeException("게시물 수정 실패");
		}
	}

	@Override
	public void delete(int notice_id) {
		// TODO Auto-generated method stub
		
	}

}
