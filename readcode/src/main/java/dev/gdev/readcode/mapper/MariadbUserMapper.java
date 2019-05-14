package dev.gdev.readcode.mapper;

import dev.gdev.readcode.enums.UserSexEnum;
import dev.gdev.readcode.model.MariadbUser;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface MariadbUserMapper {
    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<MariadbUser> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    MariadbUser getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(MariadbUser user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(MariadbUser user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);
}
