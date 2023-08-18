package ru.max.learn.springwebfluxlearn.infra.configuration;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ReactorNettyConfig {

    @Bean
    public NettyServerCustomizer reactorNettyServerCustomizer() {
        return httpServer -> {
            // Customizing the server to use a single event loop thread
            EventLoopGroup eventLoopGroup = new NioEventLoopGroup(30);
            eventLoopGroup.register(new NioServerSocketChannel());
            httpServer.requestTimeout(Duration.ofMillis(15000));
            httpServer.readTimeout(Duration.ofMillis(10000));
            return httpServer.runOn(eventLoopGroup);
        };
    }
}
