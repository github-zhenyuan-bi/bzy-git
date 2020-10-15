package com.supwisdom.framework.utils;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.supwisdom.framework.web.domain.entity.Menu;

@SpringBootTest
public class CollectionUtilTest {

    @Test
    public void test() {
        Collection<Integer> coll = Lists.newArrayList(1, 2, 3, 4, 5);
        Collection<Integer> coll2 = Sets.newHashSet(5, 6, 7, 8, 9);
        Map<String, String> map = Maps.newHashMap();
        
        // 空集合校验
        assertFalse(CollectionUtil.isEmpty(coll));
        assertFalse(CollectionUtil.isEmpty(coll2));
        assertTrue(CollectionUtil.isEmpty(map));
        
    }

    
    @Test
    public void test2() {
        Menu root = new Menu().setId(SystemConstant.TREE_ROOT_ID);
        List<Menu> menus = Lists.newArrayList(
                new Menu().setId("1").setPid(SystemConstant.TREE_ROOT_ID),
                new Menu().setId("2").setPid(SystemConstant.TREE_ROOT_ID),
                new Menu().setId("3").setPid(SystemConstant.TREE_ROOT_ID),
                new Menu().setId("4").setPid("1"),
                new Menu().setId("5").setPid("1"),
                new Menu().setId("6").setPid("2"),
                new Menu().setId("7").setPid("6"));
        CollectionUtil.buildTree(root, menus);
        System.out.println(root);
    }
}
