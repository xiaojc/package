package com.rainbow.packge.ocl.queue.demo1;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xiaojc on 2015/9/7.
 */
public class FileMain {

    private static final int BOUND = 1;
    private static final int N_CONSUMERS = 20;

    public static void main(String[] args){
        File[] roots = File.listRoots();
        startIndexing(roots);
    }



    public static void startIndexing(File[] roots){
        BlockingQueue<File> queue = new LinkedBlockingQueue<File>(BOUND);

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        };

        for (File root : roots){
            new Thread(new FileCrawler(queue,fileFilter,root)).start();
        }
        for (int i = 0; i < N_CONSUMERS; i++){
            new Thread(new Indexer(queue)).start();
        }
    }
}
