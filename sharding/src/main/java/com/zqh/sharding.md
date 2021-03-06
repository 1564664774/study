# ShardingSphere

## 什么是ShardingSphere

1. 一套开源分布式数据库中间件解决方案
2. 有三个产品JDBC、Proxy 和 Sidecar, 重点学习前两个
3. 定位为关系型数据库中间件, 合理在分布式环境下使用关系型数据库操作

## 什么是分库分表

> 数据库中数据量是不可控的, 会随着时间和业务的发展, 数据库是表的数据越来越多, 如果再对表进行crud操作时, 处理时间升高, 造成的性能问题.
> 数据库分库分表就是为了解决由于数据量过大而照成的数据库性能降低的问题.

### 分库分表的方式

1. 我们对数据库分库分表有两种方式, 一种是垂直拆分; 一种是水平拆分.

#### 垂直拆分

##### 垂直分表

1. 操作数据库的某张表, 把这张表中的一部分字段放在一个新的表中, 再把另一部分的字段存到另一张表中.

> 当数据库中有一张表字段过多, 或者其中一个字段过大, 或者这张表中一些字段经常使用, 而另一些字段的使用频率远低于那些字段, 我们可以考虑垂直分表, 让一个表格分为多个表格, 通过id关联
> 例如: 在商品信息表中, 我们需要在商品列表中展示商品标题名称价格等字段, 但对于商品的具体描述信息, 是我们需要点入商品后才会进行查询显示的, 这是我们就可以考虑使用垂直分表, 将商品详细描述信息放在新的一张表中.

###### 特点

垂直拆分之后两张表的行数都和原表一样, 未分表前一个表有10000条数据, 分表之后两个表各有一万条数据.

##### 垂直分库

1. 把单一数据库按照业务进行划分, 专库专表.

> 如: 上述例子中, 商品会产生订单数据, 这时我们可以考虑将这两张表放到不同数据库中, 这样两个数据库的运行, 在我们同时查询订单表和商品表时有两台服务器分担压力.

#### 水平拆分

1. 水平拆分, 分表和分库思路差不多, 当单表数据过多的时候, 影响数据库性能, 我们自然想到的是, 一张表往多张表放, 这样一张表一万条就可以变成两张表各五千条. 水平拆分就是把一张表的数据根据某种规则放到多个表中

> 特点是字段不变, 但是总数分到了各个表中

##### 水平分表

##### 水平分库

#### 总结

1. 垂直分表垂直分库都是针对结构, 进行修改.
2. 水平分库分表是根据数据量进行修改.

#### 应用

1. 在数据库设计的时候就可以直接考虑垂直分库分表.
2. 虽然考虑到数据库的数据量会随着时间增长, 我们不要考虑马上使用水平拆分, 首先考虑缓存, 读写分离, 索引等方式, 如果这些问题不能根本解决问题, 再考虑使用水平分表

#### 问题

1. 跨节点连接查询问题, 在进行垂直分库之后, 不能进行关联查询, 因为两张表放到了不同的数据库中, 还有分页, 排序问题, 水平拆分之后进行分页排序时会比较麻烦.
2. 多数据源管理, 要进行多个数据库进行管理

## Sharding JDBC

1. 轻量级框架, 可以理解为增强版的JDBC
2. Sharding JDBC并不是做分库分表, 只是帮我们做多个数据库多个表的操作. 可以让我们不需要想着该用哪个数据源, 该操作哪个数据库. 简化我们的操作.

### 实现水平分表

#### 一、环境搭建


