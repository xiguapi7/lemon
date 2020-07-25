-- Lemon权限管理系统数据库表脚本
-- 系统版本: v0.1.0
-- 数据库版本: MySQL 8.0


-- 用户关系表
-- 用户表包含用户信息，主要有编号、用户名、昵称、密码、手机号、邮箱等字段，其中用dept_id与机构表关联，表明所属机构
CREATE TABLE `sys_user`
(
    `id`               bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name`             varchar(50) NOT NULL COMMENT '用户名',
    `nick_name`        varchar(150) DEFAULT NULL COMMENT '昵称',
    `avatar`           varchar(150) DEFAULT NULL COMMENT '头像',
    `password`         varchar(100) DEFAULT NULL COMMENT '密码',
    `salt`             varchar(40)  DEFAULT NULL COMMENT '加密盐',
    `email`            varchar(100) DEFAULT NULL COMMENT '邮箱',
    `mobile`           varchar(100) DEFAULT NULL COMMENT '手机号',
    `status`           tinyint(4)   DEFAULT NULL COMMENT '状态: 0-禁用 1-正常',
    `dept_id`          bigint(20)   DEFAULT NULL COMMENT '机构ID',
    `create_by`        varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `del_flag`         tinyint(4)   DEFAULT '0' COMMENT '是否删除: -1 删除, 0 正常',
    PRIMARY KEY (id),
    UNIQUE KEY `name` (`name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 34
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户管理';


-- 角色表
-- 角色表代表用户角色，用户拥有角色，角色拥有菜单，菜单拥有权限标识，所以不同角色拥有不同的权限，角色表主要有编号、角色名、备注等字段
CREATE TABLE `sys_role`
(
    `id`               bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name`             varchar(100) NOT NULL COMMENT '角色名称',
    `remark`           varchar(100) DEFAULT NULL COMMENT '备注',
    `create_by`        varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `del_flag`         tinyint(4)   DEFAULT '0' COMMENT '是否删除: -1 删除, 0 正常',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = utf8mb4 COMMENT ='角色管理';


-- 机构表
-- 机构代表一种组织结构，可以有自己狗，用户归属于机构。机构表主要有编号、机构名称、上级机构等字段。
CREATE TABLE `sys_dept`
(
    `id`               bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name`             varchar(50) NOT NULL COMMENT '机构名称',
    `parent_id`        bigint(20)  DEFAULT NULL COMMENT '上级机构ID，一级机构为0',
    `order_num`        int(11)     DEFAULT NULL COMMENT '排序',
    `create_by`        varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime    DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime    DEFAULT NULL COMMENT '更新时间',
    `del_flag`         tinyint(4)  DEFAULT '0' COMMENT '是否删除: -1 删除, 0 正常',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 36
  DEFAULT CHARSET = utf8mb4 COMMENT ='机构管理';


-- 菜单表
-- 菜单分为菜单目录、菜单和操作按钮3种类型，可以进行权限控制，菜单表主要有编号、菜单名称、父菜单、菜单类型、菜单图标、菜单URL、菜单权限等字段。
CREATE TABLE `sys_menu`
(
    `id`               bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name`             varchar(50) NOT NULL COMMENT '菜单名称',
    `parent_id`        bigint(20)   DEFAULT NULL COMMENT '父菜单，一级菜单为0',
    `url`              varchar(200) DEFAULT NULL COMMENT '菜单URL，类型： 1.普通页面（如用户管理，/sys/user）
                                    2.嵌套完整外部页面，以http(s)开头的链接
                                    3. 嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控，iframe:/druid/login.html)',
    `perms`            varchar(500) DEFAULT NULL COMMENT '授权(多个逗号分隔,如sys:user:add,sys:user:edit)',
    `type`             int(11)      DEFAULT NULL COMMENT '类型： 0.目录， 1.菜单， 2.按钮',
    `icon`             varchar(50)  DEFAULT NULL COMMENT '菜单图标',
    `order_num`        int(11)      DEFAULT NULL COMMENT '排序',
    `create_by`        varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `del_flag`         tinyint(4)   DEFAULT '0' COMMENT '是否删除: -1 删除, 0 正常',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 45
  DEFAULT CHARSET = utf8mb4 COMMENT ='菜单管理';


-- 用户角色表
-- 用户角色表是用户和角色中间表，通过用户ID和角色ID分别和用户表、角色表关联。
CREATE TABLE `sys_user_role`
(
    `id`               bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id`          bigint(20) NOT NULL COMMENT '用户ID',
    `role_id`          bigint(20) NOT NULL COMMENT '角色ID',
    `create_by`        varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime    DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 76
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户角色表';


-- 角色菜单表
-- 角色菜单表是角色和菜单的中间表，通过角色ID和菜单ID分别和角色表、菜单表关联。
CREATE TABLE `sys_role_menu`
(
    `id`               bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `role_id`          bigint(20) NOT NULL COMMENT '角色ID',
    `menu_id`          bigint(20) NOT NULL COMMENT '菜单ID',
    `create_by`        varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime    DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 76
  DEFAULT CHARSET = utf8mb4 COMMENT ='角色菜单表';


-- 角色机构表
-- 角色机构表是角色和机构的中间表，通过角色ID和机构ID分别和角色表、机构表关联。
CREATE TABLE `sys_role_dept`
(
    `id`               bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `role_id`          bigint(20) NOT NULL COMMENT '角色ID',
    `dept_id`          bigint(20) NOT NULL COMMENT '机构ID',
    `create_by`        varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime    DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4 COMMENT ='角色机构表';


-- 字典表
-- 字典表主要存储系统常用的枚举型数据，主要包含编号、标签、数据值、类型等字段。
CREATE TABLE `sys_dict`
(
    `id`               bigint(20)     NOT NULL AUTO_INCREMENT COMMENT '编号',
    `value`            varchar(100)   NOT NULL COMMENT '数据值',
    `label`            varchar(100)   NOT NULL COMMENT '标签名',
    `type`             varchar(100)   NOT NULL COMMENT '类型',
    `description`      varchar(100)   NOT NULL COMMENT '描述',
    `sort`             decimal(10, 0) NOT NULL COMMENT '排序(升序)',
    `create_by`        varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`          varchar(255) DEFAULT NULL COMMENT '备注信息',
    `del_flag`         tinyint(4)   DEFAULT '0' COMMENT '是否删除: -1 删除, 0 正常',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8mb4 COMMENT ='字典表';


-- 配置表
-- 配置表主要存储系统配置信息，主要包含编号、标签、数据值、类型等字段。
CREATE TABLE `sys_config`
(
    `id`               bigint(20)     NOT NULL AUTO_INCREMENT COMMENT '编号',
    `value`            varchar(100)   NOT NULL COMMENT '数据值',
    `label`            varchar(100)   NOT NULL COMMENT '标签名',
    `type`             varchar(100)   NOT NULL COMMENT '类型',
    `description`      varchar(100)   NOT NULL COMMENT '描述',
    `sort`             decimal(10, 0) NOT NULL COMMENT '排序(升序)',
    `create_by`        varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50)  DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remarks`          varchar(255) DEFAULT NULL COMMENT '备注信息',
    `del_flag`         tinyint(4)   DEFAULT '0' COMMENT '是否删除: -1 删除, 0 正常',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8mb4 COMMENT ='配置表';


-- 操作日志表
-- 操作日志表主要记录系统用户的日常操作信息，主要包含编号、用户名、用户操作、请求方法、请求参数、执行时长、IP地址等。
CREATE TABLE `sys_log`
(
    `id`               bigint(20)    NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_name`        varchar(50)   NOT NULL COMMENT '用户名',
    `operation`        varchar(50)   NOT NULL COMMENT '用户操作',
    `method`           varchar(200)  NOT NULL COMMENT '请求方法',
    `params`           varchar(5000) NOT NULL COMMENT '请求参数',
    `time`             bigint(20)    NOT NULL COMMENT '执行时长',
    `ip`               varchar(64) DEFAULT NULL COMMENT 'IP地址',
    `create_by`        varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime    DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2798
  DEFAULT CHARSET = utf8mb4 COMMENT ='系统操作日志';


-- 登录日志表
-- 登录日志表主要记录用户登录和退出状态，主要包含编号、用户名、登录状态、IP地址等字段，可以根据status状态统计在线用户信息。
CREATE TABLE `sys_login_log`
(
    `id`               bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_name`        varchar(50) NOT NULL COMMENT '用户名',
    `status`           varchar(50) NOT NULL COMMENT '登录状态(online:在线,登录初始状态,方便统计在线人数; login:退出登录后将online置为login; logout:退出登录)',
    `ip`               varchar(64) DEFAULT NULL COMMENT 'IP地址',
    `create_by`        varchar(50) DEFAULT NULL COMMENT '创建人',
    `create_time`      datetime    DEFAULT NULL COMMENT '创建时间',
    `last_update_by`   varchar(50) DEFAULT NULL COMMENT '更新人',
    `last_update_time` datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2798
  DEFAULT CHARSET = utf8mb4 COMMENT ='系统登录日志';