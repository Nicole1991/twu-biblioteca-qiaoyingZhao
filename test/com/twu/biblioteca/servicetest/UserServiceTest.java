package com.twu.biblioteca.servicetest;

import com.twu.biblioteca.entity.UserEntity;
import com.twu.biblioteca.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Qiaoying Zhao on 2017/2/25.
 */
public class UserServiceTest {
    @Before
    public void setUp() throws Exception {
        UserService userService = UserService.getInstance();
        List<UserEntity> userEntityList = new ArrayList<UserEntity>();
    }

    /**
     * Method: init()
     * ?How to Test Method like this?
     */
    @Test
    public void testInitIsOk() throws Exception {
        List<UserEntity> userList = null;
        UserService userService = UserService.getInstance();
        userService.init();
    }

    /**
     * Method: checkUser(String userName, String password)
     */
    @Test
    public void testCheckUserReturnTrue() throws Exception {
        String name = "Nicole Zhao";
        String password = "123456";
        assertEquals(true,UserService.getInstance().checkUser(name,password));
    }

    /**
     * Method: checkUser(String userName, String password)
     */
    @Test
    public void testCheckUserReturnFalse() throws Exception {
        String name = "Zhao";
        String password = "123456";
        assertEquals(false,UserService.getInstance().checkUser(name,password));
    }


    @After
    public void after() throws Exception {

    }

}
