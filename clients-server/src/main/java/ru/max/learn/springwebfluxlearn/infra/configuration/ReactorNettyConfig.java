//package ru.max.learn.springwebfluxlearn.infra.configuration;
//
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.reactive.ReactorResourceFactory;
//import reactor.netty.http.server.HttpServer;
//import reactor.netty.tcp.TcpServer;
//
//import java.time.Duration;
//
//@Slf4j
//@Configuration
//public class ReactorNettyConfig {
//
//    @Bean
//    public NettyServerCustomizer reactorNettyServerCustomizer() {
//        return httpServer -> {
//            // Customizing the server to use a single event loop thread
//            EventLoopGroup eventLoopGroup = new NioEventLoopGroup(1);
//            final NioServerSocketChannel channel = new NioServerSocketChannel();
//            channel.config().setConnectTimeoutMillis(10);
//            eventLoopGroup.register(channel);
//            return httpServer
//                    .runOn(eventLoopGroup)
//                    .doOnConnection(connection -> {
//                log.info("New connection is established: {}", connection);
//            });
//        };
//    }
//}
