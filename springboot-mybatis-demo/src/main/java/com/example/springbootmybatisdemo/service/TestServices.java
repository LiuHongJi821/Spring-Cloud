package com.example.springbootmybatisdemo.service;

import java.util.List;

import com.example.springbootmybatisdemo.domain.TestPOJO;
import com.example.springbootmybatisdemo.dto.HotelDto;
import com.example.springbootmybatisdemo.mapper.HotelDtoMapper;
import com.example.springbootmybatisdemo.mapper.TestMapper;
import com.example.springbootmybatisdemo.util.DistributedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class TestServices {

    @Resource
    private TestMapper testMapper;

	public String show(){
        return "hello world!";
    }

    public List<TestPOJO> showDao(int age){

        DistributedLock distributedLock = new DistributedLock();
        String lockName = "test";
        String identifier = null;
        try {
            identifier = distributedLock.lockWithTimeout(lockName, 3000);
            if (!StringUtils.isEmpty(identifier)) {
                //获取锁等待超时的处理
                List<TestPOJO> test = testMapper.get(age);
            }
            //需要控制事务的代码
            distributedLock.releaseLock(lockName, identifier);
        } catch (Exception e) {
            distributedLock.releaseLock(lockName, identifier);
        }

        return testMapper.get(age);
    }

    
}
