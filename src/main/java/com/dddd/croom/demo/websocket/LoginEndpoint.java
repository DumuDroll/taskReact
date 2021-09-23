package com.dddd.croom.demo.websocket;

import com.dddd.croom.demo.config.ConfigCreateService;
import com.dddd.croom.demo.model.Message;
import com.dddd.croom.demo.service.UserService;
import com.dddd.croom.demo.websocket.decoder.MessageDecoder;
import com.dddd.croom.demo.websocket.encoder.MessageEncoder;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/loginEndpoint",
        decoders = MessageDecoder.class,
        encoders = MessageEncoder.class)
public class LoginEndpoint {

    private final UserService userService;

    public LoginEndpoint() {
        userService = ConfigCreateService.service();
    }

    @OnMessage
    public void onMessage(Session session, Message message) {
        message.setUsers(userService.listAll());
        try {
            session.getBasicRemote().sendObject(message);
        } catch (IOException | EncodeException e) {
            e.printStackTrace();
        }
    }
}
