# 本地测试环境
## 1.安装 docker
- [官方文档](https://docs.docker.com/engine/install/centos/)
## 2.配置环境&国内镜像
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
## 3.安装 docker compose
- [官方文档](https://docs.docker.com/compose/install/)
- 重启 docker
  - systemctl restart docker
## 4.docker compose nacos server
- 运行 nacos-server
  - cd ${PROJECT_HOME}/nacos-test-env/
  - docker-compose -f compose-nacos/standalone-mysql-5.7.yaml start
