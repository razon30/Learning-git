package com.selise.razonhossain.eventbus;

/**
 * Created by razon.hossain on 2/4/2018.
 */

public class MessageEvent {
    public String message = null;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessageEvent(){
        return message;
    }

}
