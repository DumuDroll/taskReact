package com.dddd.croom.demo.websocket;


import com.dddd.croom.demo.config.ConfigCreateService;
import com.dddd.croom.demo.constants.Constants;
import com.dddd.croom.demo.model.Message;
import com.dddd.croom.demo.service.UserService;
import com.dddd.croom.demo.websocket.decoder.MessageDecoder;
import com.dddd.croom.demo.websocket.encoder.MessageEncoder;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ServerEndpoint(value = "/classroomEndpoint",
        decoders = MessageDecoder.class,
        encoders = MessageEncoder.class)
public class ClassroomEndpoint {

    private final UserService userService;

    private static final List<Session> sessions = new ArrayList<>();

    public ClassroomEndpoint() {
        userService = ConfigCreateService.service();
    }

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(Message message) {
        switch (message.getAction()) {
            case Constants.CONNECT -> broadcastConnect(message);
            case Constants.HAND_STATE -> broadcastHandUp(message);
            case Constants.DISCONNECT -> broadcastDisconnect(message);
        }
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable thr) {}

    private void broadcastConnect(Message message) {
        message.setUsers(userService.listAll());
        ClassroomEndpoint.sessions.forEach(session -> {
            try {
                session.getBasicRemote().sendObject(message);
            } catch (IOException | EncodeException e) {
                e.printStackTrace();
            }
        });
    }

    private void broadcastHandUp(Message message) {
        userService.setHand_upByName(message.getUser(), message.isHand_state());
        message.setUsers(userService.listAll());
        ClassroomEndpoint.sessions.forEach(session -> {
            try {
                session.getBasicRemote().sendObject(message);
            } catch (IOException | EncodeException e) {
                e.printStackTrace();
            }
        });
    }

    private void broadcastDisconnect(Message message) {
        userService.deleteByName(message.getUser());
        message.setUsers(userService.listAll());
        ClassroomEndpoint.sessions.forEach(session -> {
            try {
                session.getBasicRemote().sendObject(message);
            } catch (IOException | EncodeException e) {
                e.printStackTrace();
            }
        });
    }

}
