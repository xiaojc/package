package com.rainbow.packge.ocl.queue.demo2;

import java.util.concurrent.*;

/**
 * Created by xiaojc on 2015/9/8.
 */
public class MainThread {

    public static void main(String[] args){
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(5);

        ExecutorService service = Executors.newCachedThreadPool();

        Producter producter = new Producter(queue);
        Consumer consumer = new Consumer(queue);


        service.submit(producter);
        service.submit(consumer);
        /*for (int i = 0; i < 5; i++){
            new Thread(producter,"Thread"+(i+1)).start();
            new Thread(consumer,"Thread"+(i+1)).start();

        }*/
    }
}
