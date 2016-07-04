package com.rainbow.packge.ocl.queue.FutureTask;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by xiaojc on 2015/9/9.
 */
public class PrivateAccount implements Callable{

    @Override
    public Object call() throws Exception {
        //模拟计算时长(当前线程休眠5秒)
        Thread.sleep(5000);
        Integer privateAccount = new Integer(new Random().nextInt(10000));
        System.out.println("当前您账户共有人民币:"+privateAccount+"元");
        return privateAccount;
    }
}
