package org.demo.vertx.demo;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;

/**
 * App
 *
 * @Author: taomee
 * @Date: 2020/4/8 0008 22:29
 * @Description:
 */
public class HelloVertX {
    public static void main(String[] args) {
        //vertx核心
        Vertx vertx = Vertx.vertx();

        //创建一个http server
        HttpServer server = vertx.createHttpServer();

        //服务器响应
        server.requestHandler(request -> {
           request.response().end("Hello,vert.x!");
        });

        /**
         * Ctrl + shift + A 可以调出 action窗口
         * 输入 load into rest client
         * 可以调出idea的 api测试界面
         */
        server.listen(8080);
    }
}
