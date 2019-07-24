package com.example.springbootmybatisdemo.mapper;

import com.example.springbootmybatisdemo.domain.TestPOJO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TestMapper {
	
	public List<TestPOJO> get(Integer age);
}
