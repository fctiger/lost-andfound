package com.tiger.lostandfound.service.impl;

import com.tiger.lostandfound.mapper.WxUserMapper;
import com.tiger.lostandfound.pojo.WxUser;
import com.tiger.lostandfound.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aaron_Kitty
 * @Date 2020/4/9 20:37
 */
@Service
public class WxUserServiceImpl implements BaseService {
    @Autowired
    private WxUserMapper wxUserMapper;
    public void insert(WxUser wxUser){
        wxUserMapper.insert(wxUser);
    }
    @Override
    public void deleteById(Object id) {

    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public void update(Object model) {
        wxUserMapper.updateByopenId((WxUser) model);
    }

    @Override
    public Object findById(String id) {
        return wxUserMapper.findById(id);
    }

    @Override
    public List findByIds(String ids) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }
}
