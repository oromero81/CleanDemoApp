package com.oromero.cleandemoapp.presentation.invoker;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Oscar on 21/12/15.
 */
public class BackgroundInvokerImpl implements BackgroundInvoker<Runnable> {
    private static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static final int KEEP_ALIVE_TIME = 1;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    private ThreadPoolExecutor threadPoolExecutor;

    public BackgroundInvokerImpl() {
        int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        threadPoolExecutor = new ThreadPoolExecutor(
                NUMBER_OF_CORES,
                NUMBER_OF_CORES,
                KEEP_ALIVE_TIME,
                KEEP_ALIVE_TIME_UNIT,
                queue);
    }

    @Override
    public void run(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("RunnableObject to execute can't be null");
        }
        threadPoolExecutor.execute(runnable);
    }
}
