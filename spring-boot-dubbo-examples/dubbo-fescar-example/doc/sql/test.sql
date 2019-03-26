-- 创建订单库
create database t_order;
-- 创建用户库
create database t_user;
-- 创建库存库
create database t_storage;

-- 库存表
CREATE TABLE `storage` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`commodity_id` varchar(32) NOT NULL COMMENT '商品code',
	`name` varchar(64) NOT NULL COMMENT '商品名称',
	`desc` varchar(256) NULL COMMENT '商品描述',
	`money` BIGINT(20) UNSIGNED DEFAULT 0 NOT NULL COMMENT '商品单价（单位：分）',
	`residue` INT(11) UNSIGNED DEFAULT 1 NOT NULL COMMENT '剩余库存',
	`version` INT(11) UNSIGNED DEFAULT 1 NOT null COMMENT '版本',
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '修改时间',
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '库存表';

-- 账户表
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` varchar(32) NOT NULL COMMENT '用户ｉｄ',
  `balance` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '账户余额',
  `version` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '版本',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户表'

-- 订单表
CREATE TABLE `order` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`commodity_id` varchar(32) NOT NULL COMMENT '商品code',
	`user_id` varchar(32) NOT NULL COMMENT '用户ｉｄ',
	`money` BIGINT(20) UNSIGNED DEFAULT 1 NOT NULL COMMENT '订单金额（单位：分）',
	`count` INT(11) UNSIGNED DEFAULT 1 NOT NULL COMMENT '商品数量',
	`version` INT(11) UNSIGNED DEFAULT 1 NOT null COMMENT '版本',
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL COMMENT '修改时间',
	 PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '订单表';

CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO t_order.`order`
(name, `desc`, commodity_id, user_id, money, count, version, create_time, update_time)
VALUES('海盗船ｋ70', '一个机械机械键盘', '', '', 1, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 库存
INSERT INTO storage
(commodity_id, name, `desc`, money, residue)
VALUES('cd35b2dc48d811e997290242ac110002', '海盗船ｋ70RGB', '一个机械机械键盘', 137000, 500);

--- 账户
INSERT INTO account
(user_id, balance)
VALUES('7621d91e48d911e997290242ac110002', 200000);