package com.dolly.spring.article.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.dolly.spring.article.vo.ArticleVO;

public class ArticleDAOImpl implements ArticleDAO {
	private JdbcTemplate jdbcTemplate;

	public ArticleDAOImpl() {
		System.out.println("public ArticleDAOImpl()");
	} // 기본 생성자 end

	@Override
	public List<ArticleVO> selectAllArticles() throws DataAccessException {
		String query = "select articleno, parentno, title, content, imagefilename, writedate, id from t_board2 order by writedate desc";
		List<ArticleVO> articleList = new ArrayList<ArticleVO>();
		
		articleList = this.jdbcTemplate.query(query, new RowMapper<ArticleVO>() {

			public ArticleVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ArticleVO articleVO = new ArticleVO();
				
				articleVO.setArticleNo(rs.getInt("articleno"));
				articleVO.setParentNo(rs.getInt("parentno"));
				articleVO.setTitle(rs.getString("title"));
				articleVO.setContent(rs.getString("content"));
				articleVO.setImageFilename(rs.getString("imagefilename"));
				articleVO.setWriteDate(rs.getDate("writedate"));
				articleVO.setId(rs.getString("id"));
				
				return articleVO;
			}
			
		});
		
		return articleList;
	}

	@Override
	public int addArticle(ArticleVO articleVO) throws DataAccessException {
		int parentNo = articleVO.getParentNo();
		String title = articleVO.getTitle();
		String content= articleVO.getContent();
		String imageFilename = articleVO.getImageFilename();
		String id = articleVO.getId();
		
		String query = "insert into t_board2 (articleno, parentno, title, content, imagefilename, writedate, id) values (t_board2_seq.NEXTVAL, " 
				+ parentNo + ", "
				+ "'" + title + "', "
				+ "'" + content + "', "
				+ "'" + imageFilename + "', "
				+ "SYSDATE, "
				+ "'" + id
				+ "') ";
		System.out.println(query);
		
		int result = this.jdbcTemplate.update(query);
		System.out.println(result);
		return result;
	}

	@Override
	public List<ArticleVO> articleForm() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVO articleDetail(int articleNo) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("this.jdbcTemplate = new JdbcTemplate(dataSource);");
	}

}
