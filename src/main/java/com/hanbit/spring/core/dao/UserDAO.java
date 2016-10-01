package com.hanbit.spring.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.spring.core.vo.UserVO;

@Repository
public class UserDAO implements IUserDAO {

	private final String USER = "hanbit";
	private final String USER_PASSWORD = "hanbit";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public int insertUser(UserVO userVO) {
		int countInserted = 0;
		
		try (Connection connection 
				= dataSource.getConnection()) {
			String sql = "INSERT INTO user (user_id, user_email, user_password)"
					+ " VALUES(?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userVO.getUserId());
			statement.setString(2, userVO.getUserEmail());
			statement.setString(3, userVO.getUserPassword());
			
			countInserted = statement.executeUpdate();
			
		}
		catch (SQLException e) {
			
		}
		
		
		return countInserted;
	}
	
	@Override
	public int insertUserDetail(UserVO userVO) {
		int countInserted = 0;
		
		try (Connection connection 
				= dataSource.getConnection()) {
			String sql = "INSERT INTO user_detail (user_id, user_tel, user_birthday, user_photo)"
					+ " VALUES(?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userVO.getUserId());
			statement.setString(2, userVO.getUserTel());
			statement.setString(3, userVO.getUserBirthday());
			statement.setString(4, userVO.getUserPhoto());
			
			countInserted = statement.executeUpdate();
			
		}
		catch (SQLException e) {
			
		}
		
		return countInserted;
	}
	
	@Override
	public int countEmail(String email) {
		
		return 0;
	}
	
	@Override
	public int updateUser(UserVO userVO) {
		
		return 0;
	}
	
	@Override
	public String selectPassword(String userId) {
	
		return null;
	}
	
	@Override
	public int deleteUser(String userId) {
		
		return 0;
	}
	
	@Override
	public int deleteUserDetail(String userId) {
		
		return 0;
	}
	
	@Override
	public List<UserVO> selectUsers() {
		List<UserVO> users = new ArrayList<>();;
		
		try (Connection connection 
				= DriverManager.getConnection
				("jdbc:mysql://localhost:3306/hanbit", USER, USER_PASSWORD)) {
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql = "SELECT u.user_id, user_email, user_tel, user_birthday, user_photo"
					+ " FROM user u, user_detail d"
					+ " WHERE u.user_id = d.user_id";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				String userId = resultSet.getString(1);
				String userEmail = resultSet.getString("user_email");
				String userTel = resultSet.getString("user_tel");
				String userBirthday = resultSet.getString("user_birthday");
				String userPhoto = resultSet.getString("user_photo");
				
				UserVO user = new UserVO();
				user.setUserId(userId);
				user.setUserEmail(userEmail);
				user.setUserTel(userTel);
				user.setUserBirthday(userBirthday);
				user.setUserPhoto(userPhoto);
				
				users.add(user);
			}
		}
		catch (ClassNotFoundException e) {
			
		}
		catch (SQLException e) {
			
		}
		
		return users;
	}
	
	@Override
	public UserVO selectUserDetail(String userId) {
		
		return null;
	}
	
}
