package com.tiger.lostandfound.service.impl;

import com.tiger.lostandfound.mapper.UploadsMapper;
import com.tiger.lostandfound.pojo.Uploads;
import com.tiger.lostandfound.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aaron_Kitty
 * @Date 2020/4/10 22:39
 */
@Service
public class UploadsServiceImpl implements BaseService {
    @Autowired
    private UploadsMapper uploadsMapper;
    public void insert(Uploads uploads){
        uploadsMapper.insert(uploads);
    }
    public List<Uploads> selectByPojo(Uploads uploads){
        return uploadsMapper.selectBypojo(uploads);
    }
    public Uploads findById(Integer id){
        return uploadsMapper.selectById(id);
    }
    /**
     * 通过主键删除
     *
     * @param id
     */
    @Override
    public void deleteById(Object id) {

    }

    /**
     * 批量刪除 eg：ids -> “1,2,3,4”
     *
     * @param ids
     */
    @Override
    public void deleteByIds(String ids) {

    }

    /**
     * 更新
     *
     * @param model
     * @return
     */
    @Override
    public void update(Object model) {

    }

    /**
     * 查找
     *
     * @param id
     * @return
     */
    @Override
    public Object findById(String id) {
        return null;
    }

    /**
     * 多id查询
     *
     * @param ids
     * @return
     */
    @Override
    public List findByIds(String ids) {
        return null;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List findAll() {
        return null;
    }
}
