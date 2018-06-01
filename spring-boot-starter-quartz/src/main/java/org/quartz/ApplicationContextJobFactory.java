package org.quartz;

import org.quartz.simpl.SimpleJobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.context.ApplicationContext;

public class ApplicationContextJobFactory extends SimpleJobFactory {

    private final ApplicationContext applicationContext;

    public ApplicationContextJobFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Job newJob(TriggerFiredBundle bundle, Scheduler Scheduler) throws SchedulerException {
        Job job = super.newJob(bundle, Scheduler);
        if (job instanceof ApplicationContextJob) {
            ((ApplicationContextJob) job).setApplicationContext(applicationContext);
        }
        return job;
    }

}