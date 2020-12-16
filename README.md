# 介绍

## nacos本地测试环境

### 1.安装 docker

- [官方文档](https://docs.docker.com/engine/install/centos/)

### 2.配置环境&国内镜像

- current user 添加 docker 用户组
    - 略
- vim /etc/docker/daemon.json
    - ```json
    {
      "registry-mirrors": [
        "https://registry.docker-cn.com",
        "https://docker.mirrors.ustc.edu.cn",
        "http://hub-mirror.c.163.com",
        "https://cr.console.aliyun.com/"
      ]
    }
    ```

### 3.安装 docker compose

- [官方文档](https://docs.docker.com/compose/install/)
- 重启 docker
    - systemctl restart docker

### 4.docker compose nacos server

- 运行 nacos-server
    - cd ${PROJECT_HOME}/local-test-env/
    - docker-compose -f compose-nacos/standalone-mysql-5.7.yaml start

## 使用的组件介绍

### 1. [Spring Cloud Alibaba](https://github.com/alibaba/spring-cloud-alibaba/blob/master/README-zh.md)

#### 1.1 [nacos](https://github.com/alibaba/Nacos)

- 服务注册中心, 提供服务发现能力
- 配置中心, 提供可视化的配置, client端有刷新配置功能

#### 1.2 [sentinel](https://github.com/alibaba/Sentinel)

- 把流量作为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性.

#### 1.3  soul

- 业务网关

## 其他

### 代码自动生成

- 模块名: code-generator
- 代码自动生成相关配置
    - [Constant](code-generator/src/main/java/com/winfred/dataworks/general/Constant.java)
- 代码生成模板配置(不会经常变更)
    - [templates](code-generator/src/main/resources/templates)
- 生成代码
    - 运行 [CodeGeneral](code-generator/src/main/java/com/winfred/dataworks/general/CodeGeneral.java)
