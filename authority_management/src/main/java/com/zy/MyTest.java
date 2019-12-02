package com.zy;

import com.zy.model.SysRole;
import com.zy.service.SysRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author zy
 * @Date 2019-11-13 18:40
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MyTest {
    @Autowired
    private SysRoleService sysRoleService;
    @Test
    public void fun(){
        List<SysRole> sysRole = sysRoleService.getSysRole(1);
        System.out.println(sysRole);
    }
}
