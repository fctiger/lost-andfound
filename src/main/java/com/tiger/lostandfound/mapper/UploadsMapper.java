package com.tiger.lostandfound.mapper;

import com.tiger.lostandfound.pojo.Uploads;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Aaron_Kitty
 * @Date 2020/4/10 22:32
 */
@Mapper
@Repository
public interface UploadsMapper {
    @Insert("INSERT INTO public(open_id,jiandao,base_classify,detail,classify,image_url,name,contactway,phone,create_time)VALUES(#{openId},#{jiandao},#{baseClassify},#{detail},#{classify},#{imageUrl},#{name},#{contactWay},#{phone},#{createTime})")
    void insert(Uploads uploads);
    @Select("select * from public where base_classify = #{baseClassify} and classify = #{classify}")
    @Result(column = "image_url",property = "imageUrl")
    @Result(column = "base_classify",property = "baseClassify")
    @Result(column = "open_id",property = "openId")
    @Result(column = "create_time",property = "createTime")
    List<Uploads> selectBypojo(Uploads uploads);
    @Select("select * from public where id = #{id}")
    @Result(column = "image_url",property = "imageUrl")
    @Result(column = "base_classify",property = "baseClassify")
    @Result(column = "open_id",property = "openId")
    @Result(column = "create_time",property = "createTime")
    Uploads selectById(Integer id);
}
