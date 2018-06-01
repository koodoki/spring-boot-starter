package org.quartz;

import org.springframework.context.ApplicationContext;

/**
 * Job定义，支持Spring
 */
public abstract class ApplicationContextJob implements Job {

    protected ApplicationContext applicationContext;

    void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

}