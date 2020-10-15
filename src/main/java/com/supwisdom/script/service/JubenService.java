package com.supwisdom.script.service;

import com.supwisdom.script.domain.entity.Juben;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 剧本 服务类
 * 使用自定义逆向生成模板, 模板文件位置classpath：templates/mybatisCodeGen/service.java.ftl
 * @author zhenyuan.bi
 * @since 2020-10-08
 */
public interface JubenService extends IService<Juben> {

    /**
     * 上传新剧本
     * @param juben
     */
    void addJuben(Juben juben);
    
    
    
}
