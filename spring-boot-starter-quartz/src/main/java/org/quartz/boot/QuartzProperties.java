package org.quartz.boot;

import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

import java.util.Properties;

@ConfigurationProperties(prefix = "spring.quartz")
public class QuartzProperties {

    private String schedulerInstanceName = "DefaultQuartzScheduler";
    private boolean schedulerRmiExport = false;
    private boolean schedulerRmiProxy = false;
    private boolean schedulerWrapJobExecutionInUserTransaction = false;

    private String threadPoolClass = "org.quartz.simpl.SimpleThreadPool";
    private String threadPoolThreadNamePrefix = "";
    private int threadPoolThreadCount = 10;
    private int threadPoolThreadPriority = 5;
    private boolean threadPoolThreadsInheritContextClassLoaderOfInitializingThread = true;

    private String jobStoreClass = "org.quartz.simpl.RAMJobStore";
    private long jobStoreMisfireThreshold = 60000;

    public String getSchedulerInstanceName() {
        return schedulerInstanceName;
    }

    public void setSchedulerInstanceName(String schedulerInstanceName) {
        this.schedulerInstanceName = schedulerInstanceName;
    }

    public boolean isSchedulerRmiExport() {
        return schedulerRmiExport;
    }

    public void setSchedulerRmiExport(boolean schedulerRmiExport) {
        this.schedulerRmiExport = schedulerRmiExport;
    }

    public boolean isSchedulerRmiProxy() {
        return schedulerRmiProxy;
    }

    public void setSchedulerRmiProxy(boolean schedulerRmiProxy) {
        this.schedulerRmiProxy = schedulerRmiProxy;
    }

    public boolean isSchedulerWrapJobExecutionInUserTransaction() {
        return schedulerWrapJobExecutionInUserTransaction;
    }

    public void setSchedulerWrapJobExecutionInUserTransaction(boolean schedulerWrapJobExecutionInUserTransaction) {
        this.schedulerWrapJobExecutionInUserTransaction = schedulerWrapJobExecutionInUserTransaction;
    }

    public String getThreadPoolClass() {
        return threadPoolClass;
    }

    public void setThreadPoolClass(String threadPoolClass) {
        this.threadPoolClass = threadPoolClass;
    }

    public String getThreadPoolThreadNamePrefix() {
        return threadPoolThreadNamePrefix;
    }

    public void setThreadPoolThreadNamePrefix(String threadPoolThreadNamePrefix) {
        this.threadPoolThreadNamePrefix = threadPoolThreadNamePrefix;
    }

    public int getThreadPoolThreadCount() {
        return threadPoolThreadCount;
    }

    public void setThreadPoolThreadCount(int threadPoolThreadCount) {
        this.threadPoolThreadCount = threadPoolThreadCount;
    }

    public int getThreadPoolThreadPriority() {
        return threadPoolThreadPriority;
    }

    public void setThreadPoolThreadPriority(int threadPoolThreadPriority) {
        this.threadPoolThreadPriority = threadPoolThreadPriority;
    }

    public boolean isThreadPoolThreadsInheritContextClassLoaderOfInitializingThread() {
        return threadPoolThreadsInheritContextClassLoaderOfInitializingThread;
    }

    public void setThreadPoolThreadsInheritContextClassLoaderOfInitializingThread(boolean threadPoolThreadsInheritContextClassLoaderOfInitializingThread) {
        this.threadPoolThreadsInheritContextClassLoaderOfInitializingThread = threadPoolThreadsInheritContextClassLoaderOfInitializingThread;
    }

    public String getJobStoreClass() {
        return jobStoreClass;
    }

    public void setJobStoreClass(String jobStoreClass) {
        this.jobStoreClass = jobStoreClass;
    }

    public long getJobStoreMisfireThreshold() {
        return jobStoreMisfireThreshold;
    }

    public void setJobStoreMisfireThreshold(long jobStoreMisfireThreshold) {
        this.jobStoreMisfireThreshold = jobStoreMisfireThreshold;
    }

    Properties build() {
        Properties properties = new Properties();
        properties.setProperty(StdSchedulerFactory.PROP_SCHED_INSTANCE_NAME, schedulerInstanceName);
        properties.setProperty(StdSchedulerFactory.PROP_SCHED_RMI_EXPORT, Boolean.toString(schedulerRmiExport));
        properties.setProperty(StdSchedulerFactory.PROP_SCHED_RMI_PROXY, Boolean.toString(schedulerRmiProxy));
        properties.setProperty(StdSchedulerFactory.PROP_SCHED_WRAP_JOB_IN_USER_TX, Boolean.toString(schedulerWrapJobExecutionInUserTransaction));

        properties.setProperty(StdSchedulerFactory.PROP_THREAD_POOL_CLASS, threadPoolClass);
        if (!StringUtils.isEmpty(threadPoolThreadNamePrefix)) {
            properties.setProperty(StdSchedulerFactory.PROP_THREAD_POOL_PREFIX.concat(".threadNamePrefix"), threadPoolThreadNamePrefix);
        }
        properties.setProperty(StdSchedulerFactory.PROP_THREAD_POOL_PREFIX.concat(".threadCount"), Integer.toString(threadPoolThreadCount));
        properties.setProperty(StdSchedulerFactory.PROP_THREAD_POOL_PREFIX.concat(".threadPriority"), Integer.toString(threadPoolThreadPriority));
        properties.setProperty(StdSchedulerFactory.PROP_THREAD_POOL_PREFIX.concat(".threadsInheritContextClassLoaderOfInitializingThread"), Boolean.toString(threadPoolThreadsInheritContextClassLoaderOfInitializingThread));

        properties.setProperty(StdSchedulerFactory.PROP_JOB_STORE_CLASS, jobStoreClass);
        properties.setProperty(StdSchedulerFactory.PROP_JOB_STORE_PREFIX.concat("misfireThreshold"), Long.toString(jobStoreMisfireThreshold));

        return properties;
    }
}
