package com.superbigbang.pryanikytest.model;

import com.superbigbang.pryanikytest.entity.ItemsForRecyclerView;

import org.w3c.dom.Document;

import io.reactivex.Observable;

public class PryanikyTestService {

    private PryanikyTestApi mPryanikyTestApi;

    public PryanikyTestService(PryanikyTestApi PryanikyTestApi) {
        mPryanikyTestApi = PryanikyTestApi;
    }

    public Observable<Response> getJSONFile() {
        return mPryanikyTestApi.getJSONFile();
    }
}
