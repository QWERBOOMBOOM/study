package com.cyc.mydemo.controller;

import com.cyc.mydemo.entity.Depart;
import com.cyc.mydemo.entity.vo.DepartVO;
import com.cyc.mydemo.repository.DepartRepository;
import com.cyc.mydemo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("depart")
public class DepartController {

    @Autowired
    private DepartRepository departRepository;

    /**
     * 增加部门信息
     * @param vo
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody DepartVO vo){

        Depart depart = new Depart();
        depart.setName(vo.getName());
        depart.setCreateTime(LocalDateTime.now());
        if (!departRepository.getDepartByName(vo.getName()).isEmpty()){
            return Result.fail("已经存在重复名称的部门了");
        }
        Depart save = departRepository.save(depart);
        if (Objects.nonNull(save)) {
            return Result.success("插入成功");
        }
        return Result.fail("插入失败");
    }

    /**
     * 修改部门信息
     * @param vo
     * @return
     */
    @PutMapping
    public Result update(@RequestBody DepartVO vo){
        List<Depart> departByName = departRepository.getDepartByName(vo.getName());
        if (departByName.size()>1&& !vo.getId().equals(departByName.get(0).getId())){

            return Result.fail("已经存在重复名称的部门了");
        }
             /*
        Depart depart = new Depart();
        depart.setId(departByName.get(0).getId());
        depart.setName(vo.getName());
        depart.setCreateTime(departByName.get(0).getCreateTime());
        depart.setUpdateTime(LocalDate.now());
        Depart save = departRepository.save(depart);
        if (Objects.nonNull(save)) {
            return Result.success("更新成功");
        }
        return Result.fail("更新失败");*/

        departRepository.updateDepartByName(vo.getId(),vo.getName(),LocalDateTime.now());
        return Result.success("更新成功");
    }

    /**
     * 根据名字分页查询
     * @param name
     * @param pageable
     * @return
     */
    @GetMapping("page")
    public Result page(@RequestParam("name") String name ,Pageable pageable){
        return Result.success(departRepository.findByName(name,pageable));
    }
}
