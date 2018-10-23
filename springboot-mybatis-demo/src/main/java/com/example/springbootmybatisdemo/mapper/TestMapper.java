package com.example.springbootmybatisdemo.mapper;

import com.example.springbootmybatisdemo.domain.TestPOJO;

import java.util.List;


public interface TestMapper {
	
	public List<TestPOJO> get(Integer age);
}
