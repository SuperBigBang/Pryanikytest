package com.superbigbang.pryanikytest.model;

import android.provider.DocumentsContract;

import com.squareup.moshi.Json;
import com.superbigbang.pryanikytest.entity.ItemsForRecyclerView;

import org.w3c.dom.Document;

import io.reactivex.Observable;
import okhttp3.Credentials;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PryanikyTestApi {

    @GET("/tmp/JSONSample.json")
    Observable<Response> getJSONFile();
}
