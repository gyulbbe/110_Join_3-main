package com.feb.jdbc.service;

import java.util.HashMap;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feb.jdbc.dao.JoinDao;

@Service
public class JoinService {

	@Autowired
	private JoinDao joinDao;
	//1차 비밀번호와 2차 비밀번호 비교 기능
	public int join(HashMap<String, String> params) {
		//비교를 위한 대입
		String passWd = params.get("passWd");
		String repeatPassWd = params.get("repeatPassWd");
		//1차 비밀번호와 2차비밀번호가 같으면 1 다르면 0
		//return joinDao.join(params);대신 return 1;하면 안되나?
		boolean result = Objects.equals(passWd, repeatPassWd);
		if(result == true) {
			return joinDao.join(params);
		}
		else {
			return 0;
		}
	}
}
