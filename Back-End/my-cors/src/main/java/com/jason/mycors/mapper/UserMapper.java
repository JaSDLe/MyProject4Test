package com.jason.mycors.mapper;

import com.jason.mycors.entity.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> findAllUsers();
}
