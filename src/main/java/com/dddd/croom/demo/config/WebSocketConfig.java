package com.dddd.croom.demo.config;

import com.dddd.croom.demo.websocket.ClassroomEndpoint;
import com.dddd.croom.demo.websocket.LoginEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    }

    @Bean
    public ClassroomEndpoint classRoomEndPoint() {
        return new ClassroomEndpoint();
    }

    @Bean
    public LoginEndpoint loginEndPoint() {
        return new LoginEndpoint();
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}