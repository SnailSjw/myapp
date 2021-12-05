package com.snailjw.socket.bio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 连接池
 *
 * @author : snail
 * @date : 2021-11-29 10:16
 **/
public class HandlerExecutorPool {
    private ExecutorService executorService;

    public HandlerExecutorPool(int maxPoolSize, int queueSize) {
        this.executorService = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                maxPoolSize,
                120L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize)
                );
    }
    public void executor(Runnable task){
        this.executorService.execute(task);
    }
}
