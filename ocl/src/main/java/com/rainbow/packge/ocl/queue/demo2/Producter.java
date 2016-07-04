package com.rainbow.packge.ocl.queue.demo2;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by xiaojc on 2015/9/8.
 */
public class Producter implements Runnable {

    BlockingQueue<String> queue = null;

    public Producter(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
       while (true){
           try {
               String tem = "I am productA:"+ Thread.currentThread().getName();
               System.out.println("I have made a product:" + Thread.currentThread().getName());
               queue.put(tem);
//               Thread.sleep(3000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
