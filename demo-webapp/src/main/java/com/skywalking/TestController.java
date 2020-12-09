package com.skywalking;

import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ldb
 * @date 2020/12/6
 * @dsscription
 */
@RestController
public class TestController {

    private static final org.slf4j.Logger LOGGER =
            LoggerFactory.getLogger(TestController.class);

    @Reference
    private IUserService userService;


    @GetMapping("/err")
    public String err() {
        String traceId = TraceContext.traceId();
        System.out.println("traceId:" + TraceContext.traceId());
        ActiveSpan.tag("error-trace activation", "error");
        throw new RuntimeException("err");
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Integer id)throws Exception{
        Thread.sleep(1000);
        // TraceContext 工具类定义在 apm-toolkit-trace 依赖包中
        LOGGER.info("traceId:{}", TraceContext.traceId());
        ActiveSpan.tag("hello-trace", id+"");
        String userInfo = userService.getUserById(id);
        Thread.sleep(1000);
        return userInfo;
    }


}
