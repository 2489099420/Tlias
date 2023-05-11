package com.gltedu.controller;

import com.gltedu.anno.Log;
import com.gltedu.mapper.EmpMapper;
import com.gltedu.pojo.Emp;
import com.gltedu.pojo.PageBean;
import com.gltedu.pojo.Result;
import com.gltedu.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 巩乐天
 * @version 1.0
 */

//员工管理Controller
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    /*
    * 分页条件查询
    */
    @GetMapping
    public Result select(@RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "10")  Integer pageSize,
                         String name, Short gender,
                         @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                         @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end)
    {
        log.info("分页查询，参数：{},{},{},{}.{}.{}",page,pageSize,name,gender,begin,end);
        //调用service分页查询
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    /*
    *批量删除员工
    */
    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作，ids:{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    /*
    *新增员工
    */
    @Log
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工，emps:{}",emp);
        empService.save(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询员工信息，id:{}",id);
        //调用service方法
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工的信息：{}",emp);
        empService.update(emp);
        return Result.success();
    }
}
