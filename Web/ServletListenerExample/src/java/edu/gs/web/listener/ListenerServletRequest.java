package edu.gs.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ListenerServletRequest implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent event) {
        System.out.println("ListenerServletRequest.requestDestroyed");
    }

    public void requestInitialized(ServletRequestEvent event) {
        System.out.println("ListenerServletRequest.requestInitialized");
    }
}
