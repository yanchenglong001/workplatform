package com.app.study.thread;

import java.util.concurrent.Callable;

public class TaskResult<T> implements Callable<T> {

    private T id;

    public TaskResult(T id) {
        this.id = id;
    }

    @Override
    public T call() throws Exception {
        return id;
    }

}
