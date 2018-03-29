package com.offcn.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.offcn.tools.Jsoup_Veg;

public class Job_Excute implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("execute_________________-");
		Jsoup_Veg.getVegInfo();
	}

}
