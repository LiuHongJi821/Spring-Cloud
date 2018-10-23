package com.example.springbootmybatisdemo.mapper;

import com.example.springbootmybatisdemo.dto.HotelDto;

import java.util.List;


public interface HotelDtoMapper {
	
	public List<HotelDto> findByCountry(String country);
}
