package com.tiger.lostandfound.mapper;

import com.tiger.lostandfound.pojo.Swiper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Aaron_Kitty
 * @Date 2020/4/9 12:28
 */
@Mapper
@Repository
public interface SwiperMapper {
    @Select("select * from swiper")
    public List<Swiper> findAll();
}
