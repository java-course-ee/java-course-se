package edu.gs.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListenerHttpSession implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("ListenerHttpSession.sessionCreated");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("ListenerHttpSession.sessionDestroyed");
    }
}
