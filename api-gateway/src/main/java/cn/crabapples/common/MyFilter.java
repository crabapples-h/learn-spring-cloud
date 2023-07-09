package cn.crabapples.common;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
// 使用Order注解和实现Ordered接口的效果一样，都是指定过滤器的优先级
//@Order(-1)
public class MyFilter implements GlobalFilter, Ordered {
    /**
     * 全局过滤器的作用也是处理一切进入网关的请求和微服务响应，和GatewayFilter的作用一样
     * 区别在于Gateway通过配置定义，处理逻辑是固定的。而GlobalFilter的逻辑需要自己写代码实现
     * 实现方式是实现GlobalFilter接口
     *
     * @param exchange 请求上下文，包含了Request，Response等信息
     * @param chain    用来把请求委托(转发)给下一个过滤器
     * @return {@code Mono<Void>} 返回标识当前过滤器业务结束
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取request对象
        ServerHttpRequest request = exchange.getRequest();
        // 获取headers
        HttpHeaders headers = request.getHeaders();
        // 判断headers中是否存在名为auth的请求头
        boolean contains = headers.containsKey("auth");
        if (contains) {
            // 获取名为auth的请求头
            List<String> auths = headers.get("auth");
            // 获取请求头中auth的值
            String auth = auths.stream().findFirst().orElse("");
            if (auth.equals("admin")) {
                // 校验成功，将exchange对象传给过滤器链中的下一个过滤器
                return chain.filter(exchange);
            }
        }
        // 禁止访问
        // 从exchange中获取response对象
        ServerHttpResponse response = exchange.getResponse();
        // 设置响应状态码
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        // 调用setComplete()方法直接结束
        return exchange.getResponse().setComplete();
    }

    /**
     * @return 过滤器的优先级
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
