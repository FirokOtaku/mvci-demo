# MVCI Demo

用于展示基础 [MVCI](https://github.com/FirokOtaku/MVCIntrospector) 基础用法的示例项目. 

启动此项目, 需要:

* JDK 17
* MySQL 8.0 数据库  
  [数据库文件](db-all.sql)
* 启用环境中的 APT 功能

----

Small demo project for showing basic usages of MVCI.

To run this project, you need:

* JDK 17
* MySQL 8.0 database  
  [db-all.sql](db-all.sql)
* enable APT in your dev-environment

----

如果配置正确,
启动构建将会看到类似如下日志:

If everything is okay,
start building then you will see some logs like:

```log
Clearing build system data...
Executing pre-compile tasks...
Output path {PATH} intersects with a source root. Only files that were created by build will be cleaned.
Cleaning output directories...
Running 'before' tasks
Checking sources
Copying resources... [mvci-demo]
Searching for compilable files... [tests of mvci-demo]
Searching for compilable files... [mvci-demo]
Parsing java... [mvci-demo]
java: MVC Introspector ADT 初始化完成
java: [MVCI] 本轮找到 3 个 MVCI 注解
java: [MVCI] 开始生成运行时内容...
java: [MVCI] 完成生成
java: [MVCI] 本次共为 2 个实体生成结构: [[firok.demo.mvci.bean.InfoBean, firok.demo.mvci.bean.UserBean]]
java: [MVCI] 本轮找到 0 个 MVCI 注解
Writing classes... [mvci-demo]
Updating dependency information... [mvci-demo]
Adding @NotNull assertions... [mvci-demo]
Adding pattern assertions... [mvci-demo]
Adding the Threading Model assertions… [mvci-demo]
Running 'after' tasks
javac 17.0.2 was used to compile java sources
Finished, saving caches...
Executing post-compile tasks...
Synchronizing output directories...
{TIMESTAMP} - Build completed successfully with 2 warnings in 5 sec, 831 ms
```

启动项目, 可以看到输出:

Run project, you will see console output:

```log
 _ _   |_  _ _|_. ___ _ |    _ 
| | |\/|_)(_| | |_\  |_)||_|_\ 
     /               |         
                        3.5.2 
[           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 38080 (http) with context path ''
[           main] firok.demo.mvci.MvciDemoApplication      : Started MvciDemoApplication in 2.322 seconds (JVM running for 2.99)
[           main] com.zaxxer.hikari.HikariDataSource       : HikariCorePool - Starting...
[           main] com.zaxxer.hikari.HikariDataSource       : HikariCorePool - Start completed.
0 users in database.
1 users in database.
read user1 from db: user1, password1
0 users in database.
0 infos in database.
1 infos in database.
all mappers:
com.baomidou.mybatisplus.core.override.MybatisMapperProxy@73d62b5
```

----

武运昌隆!

Have fun!
