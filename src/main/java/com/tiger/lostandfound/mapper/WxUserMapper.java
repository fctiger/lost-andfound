package com.tiger.lostandfound.mapper;

import com.tiger.lostandfound.pojo.WxUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author Aaron_Kitty
 * @Date 2020/4/9 20:41
 */
@Mapper
@Repository
public interface WxUserMapper {

    @Select("select * from user where  open_id = #{openId}")
    @Results(id="userMap", value= {
            @Result(column = "open_id",property = "openId"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "last_visit_time",property = "lastVisitTime"),
            @Result(column = "session_key",property = "sessionKey"),
            @Result(column = "city",property = "city"),
            @Result(column = "province",property = "province"),
            @Result(column = "country",property = "country"),
            @Result(column = "avatar_url",property = "avatarUrl"),
            @Result(column = "gender",property = "gender"),
            @Result(column = "nick_name",property = "nickName"),
    })
    /**
     * 查询
     * @param openId
     * @return
     */
    WxUser findById(String openId);

    /**
     * 更新
     * @param wxUser
     * @return
     */
    @Update("update user set last_visit_time= #{lastVisitTime},nick_name = #{nickName} where open_id =#{openId}")
    void updateByopenId(WxUser wxUser);
    @Insert("insert into user(open_id,create_time,last_visit_time,session_key,city,province,country,avatar_url,gender,nick_name)values(#{openId},#{createTime},#{lastVisitTime},#{sessionKey},#{city},#{province},#{country},#{avatarUrl},#{gender},#{nickName})")
    void insert(WxUser wxUser);
}
