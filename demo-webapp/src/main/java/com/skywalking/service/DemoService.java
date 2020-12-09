package com.skywalking.service;

import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.stereotype.Service;


/**
 * @author ldb
 */
@Service
public class DemoService {
    // 添加@Trace注解，使用该注解需要引入apm-toolkit-trace依赖
    @Trace(operationName = "default-trace-method")
    public void traceMethod() throws Exception {
        Thread.sleep(1000);
        ActiveSpan.tag("trace-method",
                String.valueOf(System.currentTimeMillis()));
        ActiveSpan.info("traceMethod info Message");
        System.out.println(TraceContext.traceId()); // 打印Trace ID
    }
}