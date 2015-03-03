package com.oromero.cleandemoapp.data.model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oromero on 02/03/15.
 */
public class ResponseBean {

    private List<ResultBean> results = new ArrayList<>();

    public List<ResultBean> getResults() {
        return results;
    }

    public void setResults(List<ResultBean> results) {
        this.results = results;
    }
}
