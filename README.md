# skywalking-demo-test
skywakling入门demo

### 注意
如果觉得存储用ES，太麻烦，直接使用h2内存数据库测试很方便。

### provider启动加入
-javaagent:D:\\apache-skywalking-apm-es7-6.6.0\\apache-skywalking-apm-bin-es7\\agent\\skywalking-agent.jar
-Dskywalking_config=D:\\study\\skywalking-demo-test\\demo-provider\\src\\main\\resources\\agent.config
-Dskywalking.agent.service_name=provider01
-Dskywalking.collector.backend_service=127.0.0.1:11800

### webapp启动加入
-javaagent:D:\\apache-skywalking-apm-es7-6.6.0\\apache-skywalking-apm-bin-es7\\agent\\skywalking-agent.jar
-Dskywalking_config=D:\\study\\skywalking-demo-test\\demo-webapp\\src\\main\\resources\\agent.config
-Dskywalking.agent.service_name=demo01
-Dskywalking.collector.backend_service=127.0.0.1:11800
