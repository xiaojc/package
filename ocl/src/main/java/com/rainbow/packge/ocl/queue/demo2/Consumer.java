package com.rainbow.packge.ocl.queue.demo2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by xiaojc on 2015/9/8.
 */
public class Consumer implements Runnable {

    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
       while (true){
           try {
               String temp = queue.take();
               System.out.println("Consumer:"+temp);
//               Thread.sleep(3000);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
    }
}
