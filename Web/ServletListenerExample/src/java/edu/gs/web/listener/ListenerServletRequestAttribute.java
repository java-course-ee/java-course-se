package edu.gs.web.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class ListenerServletRequestAttribute implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println("ListenerServletRequestAttribute.attributeAdded:" + event.getName() + " " + event.getValue());
    }

    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println("ListenerServletRequestAttribute.attributeRemoved:" + event.getName() + " " + event.getValue());
    }

    public void attributeReplaced(ServletRequestAttributeEvent event) {
        System.out.println("ListenerServletRequestAttribute.attributeReplaced:" + event.getName() + " " + event.getValue());
    }
    
}
