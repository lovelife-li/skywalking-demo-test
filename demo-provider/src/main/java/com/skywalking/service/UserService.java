package com.skywalking.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.skywalking.IUserService;
import org.springframework.stereotype.Component;

/**
 * @author ldb
 * @date 2020/12/6
 * @dsscription
 */
@Component
@Service
public class UserService implements IUserService {
    @Override
    public String getUserById(Integer id) throws Exception {
        Thread.sleep(2000);
        return "id:" + id + ";name:zhangsan";
    }
}
