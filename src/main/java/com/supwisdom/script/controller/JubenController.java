package com.supwisdom.script.controller;

import com.supwisdom.script.domain.entity.Juben;
import com.supwisdom.script.mapper.JubenMapper;
import com.supwisdom.script.service.JubenService;

import com.supwisdom.framework.web.domain.bean.R;
import com.supwisdom.framework.utils.ExceptionCheckUtil;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import java.util.Arrays;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;


/**
 * 剧本 前端控制器
 * 使用自定义逆向生成模板, 模板文件位置classpath：templates/mybatisCodeGen/controller.java.ftl
 * @author zhenyuan.bi
 * @since 2020-10-08
 */
@Api(tags = {"剧本"})
@ApiSupport(order = 100)
@RequestMapping("/script/juben")
@RestController
public class JubenController {

	@Resource
    private JubenMapper jubenMapper;
    
    @Resource
    private JubenService jubenService;
    
    
    
    /**
     * 使用id查询数据
     * @param id
     * @return
     */
    @GetMapping("getById")
    public R<Juben> getById(final String id) {
        ExceptionCheckUtil.hasLength(id, "ID 不能为空");
        
        return R.ofSuccess(jubenService.getById(id));
    }

    
    
    /**
     * 查询数据列表
     */
    @GetMapping("getList")
    public R<List<Juben>> getList(Juben queryBean) {
        List<Juben> jubens = jubenService.list(Wrappers.<Juben>lambdaQuery(queryBean));
        return R.ofSuccess(jubens);
    }
    
    
    
    /**
     * 查询数据分页
     */
    @GetMapping("getPage")
    public R<Page<Juben>> getPage(int pageNo, int pageSize, Juben queryBean) {
        Page<Juben> page = new Page<>(pageNo, pageSize);
        jubenService.page(page, Wrappers.<Juben>lambdaQuery(queryBean));
        return R.ofSuccess(page);
    }
    
    
    
    /**
     * 根据id删除数据
     */
    @DeleteMapping("deleteById")
    public R<String> deleteById(final String id) {
        ExceptionCheckUtil.hasLength(id, "ID 不能为空");
        
        boolean flag = jubenService.removeById(id);
        return R.ofSuccess("删除结果：" + (flag? "删除成功" : "删除失败"));
    }
    
    
    
    /**
     * 批量删除 根据id数组
     */
    @DeleteMapping("batchDeleteByIds")
    public R<String> batchDeleteByIds(String[] ids) {
        ExceptionCheckUtil.notEmpty(ids, "批量删除的IDs 不能为空");
        
        boolean flag = jubenService.removeByIds(Arrays.asList(ids));
        return R.ofSuccess("删除结果：" + (flag? "删除成功" : "删除失败"));
    }
    
    
    
    /**
     * 插入一条新数据
     * @param juben 数据
     * @param bindingResult 表单校验结果
     * @return
     */
    @PostMapping("addRecord")
    public R<Juben> addRecord(@Validated(value= {}) @RequestBody Juben juben, BindingResult bindingResult) {
        if (StringUtils.isEmpty(juben.getId()))
            juben.setId(null);
        
        jubenService.addJuben(juben);
        return R.ofSuccess(juben);
    }
    
    
    
    /**
     * 更新数据
     * @param updateBean 数据
     * @param bindingResult 表单校验结果
     * @return
     */
    @PostMapping("updateById")
    public R<String> updateById(@Validated(value= {}) @RequestBody Juben updateBean, BindingResult bindingResult) {
        ExceptionCheckUtil.hasLength(updateBean.getId(), "ID 不能为空");
        
        boolean flag = jubenService.updateById(updateBean);
        return R.ofSuccess(flag? "更新成功" : "更新失败");
    }
}