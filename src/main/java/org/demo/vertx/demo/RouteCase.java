package org.demo.vertx.demo;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Router;

/**
 * App
 *
 * @Author: taomee
 * @Date: 2020/4/8 0008 22:29
 * @Description:
 */
public class RouteCase {
    public static void main(String[] args) {
        //vertx核心
        Vertx vertx = Vertx.vertx();

        //web 路由
        Router router = Router.router(vertx);

        router.route("/case").handler(context -> {
            HttpServerRequest request = context.request();
            String name = request.getParam("name");
            StringBuilder sb = new StringBuilder("welcome to vertx/case");
            if(name!=null){
                sb.append(",");
                sb.append(name);
            }
            context.response().end(sb.toString());
        });

        //创建一个http server
        HttpServer server = vertx.createHttpServer();

        //服务器响应
        server.requestHandler(request -> {
           router.accept(request);
        });

        /**
         * Ctrl + shift + A 可以调出 action窗口
         * 输入 load into rest client
         * 可以调出idea的 api测试界面
         */
        server.listen(8080);
    }
}
