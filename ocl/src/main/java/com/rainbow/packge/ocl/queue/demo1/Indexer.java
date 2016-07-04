package com.rainbow.packge.ocl.queue.demo1;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Created by xiaojc on 2015/9/7.
 */
public class Indexer implements Runnable {

    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true){
                indexFile(queue.take());
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    private void indexFile(File take) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===========>filename:"+take.getPath()+"/"+take.getName());
    }
}
