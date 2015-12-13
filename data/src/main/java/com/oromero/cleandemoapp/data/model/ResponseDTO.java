package com.oromero.cleandemoapp.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oromero on 02/03/15.
 */
public class ResponseDTO {

    private List<ResultDTO> results = new ArrayList<>();

    public List<ResultDTO> getResults() {
        return results;
    }

    public void setResults(List<ResultDTO> results) {
        this.results = results;
    }
}
