package com.offcn.job;


import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 创建任务，设定任务执行时间，以及发送任务邮件.
 * @author Danie_l
 *
 */
public class Job_Time {

//	public static void main(String[] args) {
	public static void setTime(){
		//创建JobDetail对象，指定对象的任务名称、组名
			JobDetail jobDetail = JobBuilder.newJob(Job_Excute.class).
			withIdentity("job", "group").build();
		//创建CronTrigger对象，指定对象名称、组名  设置任务重复执行间隔时间、启动时间
			//设定时间为2018-2019年每天早晨8点执行一次，时间为30秒
			CronTrigger trigger = TriggerBuilder.newTrigger().
			withSchedule(CronScheduleBuilder.cronSchedule("0 12 21 * * ? 2018-2019"))
			.startAt(new Date()).build();
		//创建任务管理器Scheduler对象
			try {
				Scheduler sch = new StdSchedulerFactory().getDefaultScheduler();
				//注册任务
				sch.scheduleJob(jobDetail, trigger);
				sch.start();
				System.out.println("程序开始执行");
				//主线程睡眠时间设定为30秒，之后关闭
				Thread.sleep(30000);
				sch.shutdown();
				System.out.println("程序执行完成");
			} catch (Exception e) {
				e.printStackTrace();
//			}
	}
	}
}
