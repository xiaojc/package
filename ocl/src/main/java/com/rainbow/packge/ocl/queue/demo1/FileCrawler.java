package com.rainbow.packge.ocl.queue.demo1;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by xiaojc on 2015/9/7.
 */
public class FileCrawler implements Runnable{

    private final BlockingQueue<File> fileQueue;
    private final FileFilter fileFilter;
    private final File root;

    public FileCrawler(BlockingQueue<File> fileQueue, FileFilter fileFilter, File root) {
        this.fileQueue = fileQueue;
        this.fileFilter = fileFilter;
        this.root = root;
    }

    @Override
    public void run() {
        try {
            crawl(root);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void crawl(File root) throws InterruptedException {
        File[] entries = root.listFiles(fileFilter);
        if (entries != null){
            Thread.sleep(5000);
            System.out.println("");
            for (File entry : entries){
                if (entry.isDirectory()){
                    crawl(entry);
                }else {
                    fileQueue.put(entry);
                }
            }
        }
    }
}
