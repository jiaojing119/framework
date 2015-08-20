package com.anson.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.anson.nosql.mybatiscache.MybatisCache;
import com.anson.user.model.Users;

@CacheNamespace(implementation=MybatisCache.class)
public interface UsersMapper {
    int deleteByPrimaryKey(Long id);
    @Insert(value=" insert into users(username,password,phonenumber) values(#{username},#{password},#{phonenumber})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") 
    long insert(Users record);

    int insertSelective(Users record);
    
    
    
    @Select(value = { " select * from users where id = #{id}" }) 
    Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Users record);
    
    @Update(value = {" update users set username = #{username},password= #{password},"
    		+ "phonenumber= #{phonenumber},createdat= #{createdat} where id = #{id} " })
    int updateByPrimaryKey(Users user);
}