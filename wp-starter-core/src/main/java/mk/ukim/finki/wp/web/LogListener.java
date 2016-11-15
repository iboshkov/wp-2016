package mk.ukim.finki.wp.web;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by 131223 on 11/15/2016.
 */
public class LogListener implements ServletRequestListener, ServletContextListener, HttpSessionListener
{
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("[WP-Log] requestDestroyed");
    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("[WP-Log] requestInitialized");
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("[WP-Log] contextInitialized");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("[WP-Log] contextDestroyed");
    }

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("[WP-Log] sessionCreated");
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("[WP-Log] sessionDestroyed");
    }
}
