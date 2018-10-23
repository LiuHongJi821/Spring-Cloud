package com.example.springbootmybatisdemo.service;

import java.util.List;

import com.example.springbootmybatisdemo.domain.TestPOJO;
import com.example.springbootmybatisdemo.dto.HotelDto;
import com.example.springbootmybatisdemo.mapper.HotelDtoMapper;
import com.example.springbootmybatisdemo.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServices {

    @Resource
    private TestMapper testMapper;

	@Resource
    private HotelDtoMapper hotelDtoMapper;
	
	public String show(){
        return "hello world!";
    }

    public List<TestPOJO> showDao(int age){
        return testMapper.get(age);
    }
    
    public List<HotelDto> findByCountry(String country){
        return hotelDtoMapper.findByCountry(country);
    }
    
}
