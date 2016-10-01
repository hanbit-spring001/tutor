package com.hanbit.spring.core.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hanbit.spring.core.vo.UserVO;

@Repository
public class UserSpringDAO implements IUserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertUser(UserVO userVO) {
		
		String sql = "INSERT INTO user (user_id, user_email, user_password)"
				+ " VALUES(?, ?, ?)";

		return jdbcTemplate.update(sql, 
				userVO.getUserId(), userVO.getUserEmail(), userVO.getUserPassword());
	}

	@Override
	public int insertUserDetail(UserVO userVO) {
		
		String sql = "INSERT INTO user_detail (user_id, user_tel, user_birthday, user_photo)"
				+ " VALUES(?, ?, ?, ?)";

		return jdbcTemplate.update(sql, 
				userVO.getUserId(), userVO.getUserTel(), userVO.getUserBirthday(),
				userVO.getUserPhoto());
	}

	@Override
	public int countEmail(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String selectPassword(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserDetail(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserVO> selectUsers() {
		
		String sql = "SELECT u.user_id, user_email, user_tel, user_birthday, user_photo"
				+ " FROM user u, user_detail d"
				+ " WHERE u.user_id = d.user_id";
		
		List<UserVO> users = jdbcTemplate.queryForList(sql, UserVO.class);
		
		return users;
	}

	@Override
	public UserVO selectUserDetail(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
