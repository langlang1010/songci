## songci

非常简单的项目，无任何复杂业务逻辑，只做一件事情：查询宋词。

### 基本信息
* Springboot v2.1.6 RELEASE 
* JPA 
* 开发工具: IDEA
* 数据库: MySQL 5.7.x

### 使用源码
1. 数据库准备
新建数据库songci,将项目中 `resource/static/songci.sql` 导入数据库中。即
    ```bash
    > create database songci
    > use songci
    > source /tmp/songci.sql
    ```
2. 数据库配置
使用IDEA打开项目后，需要根据实际情况修改 `application.yml` 文件，配置数据库。

3. 运行项目
