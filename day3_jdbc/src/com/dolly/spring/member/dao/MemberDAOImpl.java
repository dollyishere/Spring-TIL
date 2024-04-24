package com.dolly.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dolly.spring.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	private JdbcTemplate jdbcTemplate;

	public MemberDAOImpl() {
		System.out.println("public MemberDAOImpl()");
	}

	@Override
	public List<MemberVO> selectAllMembers() throws DataAccessException {
		String query = "select id, pwd, name, email, joinDate from t_member "
				+ "order by joinDate desc";
		System.out.println("query ===> " + query);
		
		List<MemberVO> membersList = new ArrayList<MemberVO>();
		// 무조건 첫 번째 인자값은 query문
		// 두번째 인자값은 경우에 따라 바꿔치기할 수 있음
		membersList = this.jdbcTemplate.query(query, new RowMapper<MemberVO>() {
			// arrayList처럼 계속 쌓아주는 역할을 함
			// 한행을 묶어주는 역할을 memberVO가 담당
			// 사실 기존 while문 돌려도 상관없긴 해
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO memberVO = new MemberVO();
				System.out.println(rs.getString("id"));
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoinDate(rs.getDate("joinDate"));
				
				return memberVO;
			}
		});
		return membersList;
	}

	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// private DataSource dataSource; => setter =>
	// public void setDataSource(DataSource dataSource) {~~}
	// 원래 따로 setter도 있어야 하고, dataSource 객체도 있어야 하지만, 없어도 호출되는 이유는?
	// setter를 만들게 되면 set대문자~가 되지만, 이 형태만 지키면 setter로 작용함
	// 대신 변수명과 부합하게 만들어주어야 함
	// 그니까 dataSource setter 식으로 만들어두는 대신, 내부 로직은 dataSource 변수에 해당 값을 할당하는 게 아니라, jdbcTemplate에 할당하는 거일듯?
	// 중요한 건 형식에 맞게 만드는 것(불필요한 변수를 안 만들 수 있다!)
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("this.jdbcTemplate = new JdbcTemplate(dataSource;)");
	}
	
}
