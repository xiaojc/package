package com.rainbow.packge.ocl.queue.FutureTask;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by xiaojc on 2015/9/9.
 */
public class FutureTaskTest {

    public static void main(String[] args) throws InterruptedException {
        Callable<PrivateAccount> privateAccountCallable = new PrivateAccount();
        FutureTask futureTask = new FutureTask(privateAccountCallable);

        Long startTime = System.currentTimeMillis();
        System.out.println("线程开始时间是:"+startTime);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("主线程开始执行其他任务");

        int ortherTaltal = new Random().nextInt(1000);
        System.out.println("其它账户有人民币:"+ortherTaltal+"元");

        //轮循 FutrueTask 任务结果是否完成.
        while (!futureTask.isDone()){
            Thread.sleep(500);//休眠500毫秒(不休眠会一直打印下面的语句)
            System.out.println("私有账户计算未完成继续等待...");
        }

        Long endTime = System.currentTimeMillis();
        System.out.println("futureTask线程计算完毕，此时时间为" + endTime +"一共花费时间:"+(endTime-startTime)+"ms");
        try {
            Integer privateAccount = (Integer) futureTask.get();
            System.out.println("您现在的总金额为：" + (ortherTaltal + privateAccount.intValue()));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}


