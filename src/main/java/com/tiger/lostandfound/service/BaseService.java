package com.tiger.lostandfound.service;

import java.util.List;

/**
 * @author Aaron_Kitty
 * @Date 2020/4/9 20:32
 */
public interface BaseService<T> {
    /**
     * 通过主键删除
     * @param id
     */
    void deleteById(T id);

    /**
     * 批量刪除 eg：ids -> “1,2,3,4”
     * @param ids
     */
    void deleteByIds(String ids);

    /**
     *更新
     * @param model
     * @return
     */
    void update(T model);

    /**
     * 查找
     * @param id
     * @return
     */
    T findById(String id);

    /**
     * 多id查询
     * @param ids
     * @return
     */
    List<T> findByIds(String ids);

    /**
     * 查询所有
     * @return
     */
    List<T> findAll();

}
