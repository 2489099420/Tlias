# tlias
1. 下载项目源码
从项目代码托管平台（如 Github、GitLab 等）上下载项目源代码并解压，或者使用 git 工具 进行克隆（git clone 命令）。

2. 安装后端依赖
进入后端工程目录，使用 Maven 安装项目依赖：    cd your-proejct-back mvn install

3. 配置数据库
在 mysql 数据库中创建相应的数据库和数据表，修改后端工程中 resources/application.yml 文件中的数据库连接信息。

4. 启动项目
在前端工程根目录下执行以下命令启动前端工程：    npm run dev 在后端工程目录下执行以下命令启动后端工程：    mvn spring-boot:run 至此，您已经完成本项目的安装过程

#Tip
sql文件在resource文件下 需要修改的内容有：
mysql数据库账号密码

修改application.yml文件中阿里云对象存储服务的secretId和secretKey，buckerName、endpoint 也需要修改。使用者需自行申请阿里云对象存储服务并填充application.yml文件中的密钥等信息。
