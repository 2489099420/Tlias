package com.gltedu.service;

import com.gltedu.pojo.Dept;

import java.util.List;

/**
 * @author 巩乐天
 * @version 1.0
 */
public interface DeptService {
    /*
    * 查询全部部门数据
    * */
    List<Dept> list();

    /*
    *删除部门
    * */
    void delete(Integer id) throws Exception;
    /*
     *新增部门们
     * */
    void add(Dept dept);

    Dept select(Integer id);


    void update(Dept dept);
}
