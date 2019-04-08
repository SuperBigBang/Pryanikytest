package com.superbigbang.pryanikytest.model;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PryanikyTestApi {

    @GET("/tmp/JSONSample.json")
    Observable<Response> getJSONFile();
}
