package com.superbigbang.pryanikytest.model;

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
