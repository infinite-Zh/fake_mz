package com.infinite.fake_mz.entity;

/**
 * Created by inf on 2016/11/8.
 */

public class BaseValue<T> {
    public boolean error;
    public T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
