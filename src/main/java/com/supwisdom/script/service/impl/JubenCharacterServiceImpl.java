package com.supwisdom.script.service.impl;

import com.supwisdom.framework.utils.CollectionUtil;
import com.supwisdom.script.domain.entity.JubenCharacter;
import com.supwisdom.script.mapper.JubenCharacterMapper;
import com.supwisdom.script.service.JubenCharacterService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
 * 剧本的角色 服务实现类
 * 使用自定义逆向生成模板, 模板文件位置classpath：templates/mybatisCodeGen/serviceImpl.java.ftl
 * @author zhenyuan.bi
 * @since 2020-10-14
 */
@Service
public class JubenCharacterServiceImpl extends ServiceImpl<JubenCharacterMapper, JubenCharacter> implements JubenCharacterService {

    @Resource
    private JubenCharacterMapper jubenCharacterMapper;

    
    
    @Override
    @Transactional(rollbackFor=Exception.class)
    public int saveOrUpdateRecords(String jubenId, List<JubenCharacter> jubenCharacters) {
        // 1. 删除旧的人物绑定
        remove(Wrappers.<JubenCharacter>lambdaUpdate().eq(JubenCharacter::getJubenId, jubenId));
        
        // 2. 重新绑定人物关系
        if (!CollectionUtil.isEmpty(jubenCharacters)) {
            saveBatch(jubenCharacters);
            return jubenCharacters.size();
        }
            
        return 0;
    }

}