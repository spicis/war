/**
 * 
 */
package com.war.web;

import javax.servlet.ServletContextEvent;
import javax.sql.DataSource;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author <a href='mailto:chenxx@chances.com.cn'>chenxx</a><br/>
 *         Copyright Shanghai Chances. 2016<br/>
 */
public class ChancesContextLoaderListener extends ContextLoaderListener {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.context.ContextLoaderListener#contextInitialized
     * (javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);

        WebApplicationContext appContext = WebApplicationContextUtils
                .getWebApplicationContext(event.getServletContext());
        String[] names = appContext.getBeanNamesForType(DataSource.class);

        for (String name : names) {
            Object obj = appContext.getBean(name);
            event.getServletContext().setAttribute(name, obj);
        }
    }

}
