package com.gltedu.service.impl;

import com.gltedu.mapper.DeptMapper;
import com.gltedu.mapper.EmpMapper;
import com.gltedu.pojo.Dept;
import com.gltedu.pojo.Emp;
import com.gltedu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 巩乐天
 * @version 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;


    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class) //spring事务管理
    @Override
    public void delete(Integer id) throws Exception {


            deptMapper.deleteById(id);//根据ID删除部门数据t
//            int i = 1 / 0;//模拟抛出异常
//        if(true){
//            throw new Exception("出错了。。。");
//        }
            empMapper.deleteByDeptId(id);//根据部门ID删除该部门下的员工



    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    @Override
    public Dept select(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }


}
