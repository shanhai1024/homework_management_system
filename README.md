# 1. 演示地址
```
http://1.94.3.242:5714
```
## 1. 默认用户名密码
登录用户名：`18187294890`
密码：`11`
通用验证码：`1234`
## 2.运行效果：
![img.png](./img/img.png)
![img_1.png](./img/img_1.png)
![img_2.png](./img/img_2.png)
![img_3.png](./img/img_3.png)
# 2. 前端

 #### 1. 安装yarn
 ```
 npm install -g yarn
 ```
#### 2. 运行应用
 1. 使用本地环境
```
yarn run dev --mode development
```

 2. 使用云端环境
```
yarn run dev --mode production
```
### 注意： 网页暂未做响应式建议最大化浏览器后刷新一下



# 3. 后端
## 1. 所需环境：
```
redis
mysql
maven
```
## 2. 注意：
验证码由于阿里云部署验证码需要审核时间不够只能找开发者申请添加测试手机号
开发者手机号：
```
18187294890
```
或者说使用`1234`作为验证码
1234是为了方便测试留的通用验证码
## 3. mysql配置
```
spring:
  datasource:
#    数据库名字：`personnel_managements`
#    密码：`12345678`
    url: jdbc:mysql://localhost:3307/personnel_managements
    driver-class-name: com.mysql.cj.jdbc.Driver
    password: 12345678
```
# 注意： mysql端口是3307！！！
# 4. 数据库


因为引入了flyway所以只需要创建一个叫`personnel_managements`的数据库然后修改密码和端口即可

