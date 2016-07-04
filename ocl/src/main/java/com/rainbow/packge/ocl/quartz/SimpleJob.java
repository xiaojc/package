package com.rainbow.packge.ocl.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by xiaojc on 2015/9/6.
 */
public class SimpleJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println(jobExecutionContext.getTrigger().getCalendarName()+"triggered.time is "+(new Date()));

        StringBuilder stringBuilder = new StringBuilder();
    }
}
