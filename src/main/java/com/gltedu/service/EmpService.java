package com.gltedu.service;

import com.gltedu.mapper.EmpMapper;
import com.gltedu.pojo.Emp;
import com.gltedu.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 巩乐天
 * @version 1.0
 */
public interface EmpService {

    /*
    *分页查询
    */
    PageBean page(Integer page, Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end);

    /*
    *批量删除ig
    */
    void delete(List<Integer> ids);

    /*
     *新增员工
     */
    void save(Emp emp);

    /*
     *根据ID查询员工
     */
    Emp getById(Integer id);

    /*
     *更新员工信息
     */
    void update(Emp emp);

    /*
    *员工登陆
    */
    Emp login(Emp emp);
}
