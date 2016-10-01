package com.hanbit.spring.core.dao;

import java.util.List;

import com.hanbit.spring.core.vo.UserVO;

public interface IUserDAO {

	int insertUser(UserVO userVO);

	int insertUserDetail(UserVO userVO);

	int countEmail(String email);

	int updateUser(UserVO userVO);

	String selectPassword(String userId);

	int deleteUser(String userId);

	int deleteUserDetail(String userId);

	List<UserVO> selectUsers();

	UserVO selectUserDetail(String userId);

}