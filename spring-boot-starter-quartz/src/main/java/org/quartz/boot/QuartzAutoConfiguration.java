package org.quartz.boot;

import org.quartz.ApplicationContextJobFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.spi.JobFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnClass(value = org.quartz.Scheduler.class)
@EnableConfigurationProperties(value = QuartzProperties.class)
@Configuration
public class QuartzAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(JobFactory.class)
    public ApplicationContextJobFactory applicationContextJobFactory(ApplicationContext applicationContext) {
        return new ApplicationContextJobFactory(applicationContext);
    }

    @Bean
    @ConditionalOnMissingBean(StdSchedulerFactory.class)
    public StdSchedulerFactory schedulerFactory(QuartzProperties properties) throws SchedulerException {
        return new StdSchedulerFactory(properties.build());
    }

    @Bean
    @ConditionalOnMissingBean(Scheduler.class)
    public Scheduler scheduler(SchedulerFactory schedulerFactory, JobFactory jobFactory) throws SchedulerException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.setJobFactory(jobFactory);
        return scheduler;
    }

}
