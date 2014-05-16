package edu.gs.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ListenerContextAttribute implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("ListenerContextAttribute.attributeAdded:" + event.getName() + " " + event.getValue());
    }

    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("ListenerContextAttribute.attributeRemoved:" + event.getName() + " " + event.getValue());
    }

    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("ListenerContextAttribute.attributeReplaced:" + event.getName() + " " + event.getValue());
    }
}
