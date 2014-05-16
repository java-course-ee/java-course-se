package edu.gs.web.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class ListenerHttpSessionBinding implements HttpSessionBindingListener {

    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("ListenerHttpSessionBinding.valueBound:" + event.getName() + " " + event.getValue());
    }

    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("ListenerHttpSessionBinding.valueUnbound:" + event.getName() + " " + event.getValue());
    }
    
}
