package com.dddd.croom.demo.websocket.encoder;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.dddd.croom.demo.model.Message;
import com.google.gson.Gson;

public class MessageEncoder implements Encoder.Text<Message> {

    private static final Gson gson = new Gson();

    @Override
    public String encode(Message message) throws EncodeException {
        return gson.toJson(message);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
    }

    @Override
    public void destroy() {
    }
}