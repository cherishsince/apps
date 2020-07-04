# App

**Apps** 是一个内部的 **应用商店** ，主要面向于公司内部，或者部门的 App，便于 **测试**、**产品**、**领导** 下载，这样也更便于应用的管理，也可以免去你在风控的敲代码的时候，**小哥给我装个测试环境的包**，😝😝😝😝。

浏览地址：[https://coget.cn/apps/](https://coget.cn/apps/)

#### 计划

- app-web：这是一个html页面，给测试、产品、领导们用的（已完成）。
- app-service: 一个简单地服务（已完成）。
- app-admins: 管理app上传，下载使用（**未完成**）。

- dockerfile：便于企业快速部署（**未完成**）。
- 轻便型：可以将 MySql 换掉，使用 xxx 可以更轻便（**未完成**）。
- 数据：数据备份和迁移方案（**未完成**）。



#### web 界面功能



![类图](http://f100.coget.cn/apps/web-demonstration.gif)





#### 安装-MySql方案

**第一步-初始化数据**：

初始化数据库，`docs/sql/xxx.sql` 下有初始化 `sql` 执行即可。

`apps-init.sql`：只有表结构。

`apps-init-data.sql`: 表结构附加 `网易云音乐`、`QQ音乐` 测试数据。



**第二步-maven依赖**：

> (略) Java 的同学熟门熟路
>
> 给大家贴个链接：https://blog.csdn.net/zeal9s/article/details/84023846



**第三步-启动服务**

服务采用的是 `SpringBoot`，相对于比较简单和轻便的启动，找到 `AppsApplication` 文件 `main` 方法运行即可(先下载好 maven相关依赖)。



#### 服务打包



**Docker 打包**





**SpringBoot jar 文件打包**





