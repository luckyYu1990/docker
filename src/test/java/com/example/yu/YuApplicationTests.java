package com.example.yu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.yu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YuApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Test
	void contextLoads() {
	}

	@Test
	public void testGetUsers() {
		userMapper.selectList(new QueryWrapper<>());
	}

}
