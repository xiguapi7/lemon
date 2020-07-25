# Lemon权限管理系统

Lemon是基于Spring Cloud和Vue.js的前后端分离的后台权限管理系统。
> 版本：v0.1.0

#### 0. 主要功能
- 系统登录：系统用户登录、系统登录认证（token方式）
- 用户管理：用户的增删改查
- 机构管理：机构的增删改查
- 角色管理：角色的增删改查
- 菜单管理：菜单的增删改查
- 字典管理：字典的增删改查
- 配置管理：配置的增删改查
- 登录日志：记录用户的登录日志、查看系统登录日志记录
- 操作日志：记录用户的操作日志、查看系统操作日志记录
- 在线用户：根据用户的登录状态查看统计当前登录在线用户
- 数据监控：定制Druid信息，提供简洁有效的SQL数据监控
- 聚合文档：定制Swagger文档，提供简洁美观的API文档
- 备份还原：系统数据备份还原，一键恢复系统初始化数据
- 主题切换：支持主题切换、自定义主题颜色，实现一键换肤
- 服务治理：集成Consul注册中心，实现服务的注册和发现
- 服务监控：集成Spring Boot Admin，实现全方位的服务监控
- 服务消费：集成Ribbon、Feign，实现服务调用和负载均衡
- 服务熔断：集成Hystrix、Turbine，实现服务的熔断和监控
- 服务网关：集成Spring Cloud Zuul，实现统一API服务网关
- 链路追踪：集成Sleuth、Zipkin，实现服务分布式链路追踪
- 配置中心：集成Spring Cloud Config和Bus，实现分布式配置中心。

#### 1. 系统架构

##### 1.0 前端架构
前端架构比较简单，核心框架是使用Vue.js，UI使用Element，采用Axios与后端交互，Mock模拟接口数据。
![image.png](https://i.loli.net/2020/07/25/jI2ShrlQV3TqHcx.png)

##### 1.1 后端架构
后端使用Spring Boot、Spring Cloud、Spring Security和MyBatis的主流架构。注册中心使用Consul、以Maven为构建工具、MySQL作为主数据库。
![image.png](https://i.loli.net/2020/07/25/bJrsDIRxFPpCEXQ.png)


#### 2. 技术选型

##### 2.0 前端
- 核心框架：Vue.js 2.x
- UI框架： Element UI 2.x
- 状态管理：Vuex 2.x
- 后台交互：Axios 0.18.x
- 图标使用：Font Awesome 4.x

##### 2.1 后端
- 核心框架：Spring Boot 2.x
- Cloud版本：Spring Cloud Finchley
- 安全框架：Spring Security 5.x
- Web框架：Spring MVC 5.x
- 持久层框架：MyBatis 3.x
- 数据库连接池：Druid 1.x
- 消息队列：Rabbit MQ
- 接口文档：Swagger 2.9.x
- 日志管理：SLF4J、Log4J

##### 2.2 后端项目结构
- lemon-pom：聚合模块
- lemon-common：公共模块，提供工具类等
- lemon-core：封装业务模块，主要封装公共业务模块
- lemon-admin：后台管理模块，包含用户、角色、菜单管理等
- lemon-backup：系统数据备份还原模块
- lemon-monitor：系统监控服务端，监控Spring Boot应用
- lemon-hystrix：服务熔断监控模块，收集汇总熔断统计信息
- lemon-zuul：API服务网关模块，统一管理和转发外部调用请求
- lemon-config：配置中心服务端，生成GIT配置文件的访问接口
- lemon-zipkin：链路追踪，
- lemon-consul：注册中心
- config-repo：配置中心仓库，在GIT上统一存储系统配置文件


#### 3. 数据库设计
lemon权限管理系统需要实现的需求有：
- 系统登录
- 用户管理
- 机构管理
- 角色管理
- 菜单管理
- 字典管理
- 登录日志
- 操作日志
- 数据监控
- 服务监控
- 服务治理

基于以上需求，结合各功能需求之间的直接关系，我们需要设计出权限管理系统的数据库表。
数据库表设计应当遵循以下原则：
- 所有数据库均采用长整型“编号”字段作为表的主键。
- 编号、创建人、创建时间、更新人、更新时间为所有表的共同字段
- 表间关系采用各表编号进行关联查询，不定义实际数据库外键

##### 3.0 数据库表关系
系统中的数据库表主要包含以下关系：
- 用户表和角色表通过用户角色表关联
- 角色表和菜单表通过角色菜单表关联
- 角色表和机构表通过角色权限表关联
- 用户表和机构表通过用户的机构ID管理
- 用户菜单和按钮权限查找流程为：用户 -> 用户角色 -> 角色 -> 角色菜单 -> 菜单

