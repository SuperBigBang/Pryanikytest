package com.superbigbang.pryanikytest.screen.topLevelActivity;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.superbigbang.pryanikytest.ExtendApplication;
import com.superbigbang.pryanikytest.R;
import com.superbigbang.pryanikytest.adapter.ListItemRvAdapter;
import com.superbigbang.pryanikytest.model.PryanikyTestService;
import com.superbigbang.pryanikytest.model.Response;
import com.superbigbang.pryanikytest.screen.BasePresenter;

import org.json.JSONObject;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;


@InjectViewState
public class TopLevelPresenter extends BasePresenter<TopLevelView> {

    @Inject
    PryanikyTestService mPryanikyTestService;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

public TopLevelPresenter(){
    ExtendApplication.getBaseComponent().inject(this);}

    void showList() {
        //Local testing
               Disposable disposable = mPryanikyTestService.getJSONFile()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(json -> {
                    Timber.e("Success");
                    for (int i = 0; i <json.getData().size() ; i++) {
                       Timber.e(json.getData().get(i).getName()); /**Continue work from this place*/
                    }
                }, exception -> {
                    Timber.e("Exception%s", exception.getMessage());
                });

        unsubscribeOnDestroy(disposable);

    //    ListItemRvAdapter listItemRvAdapter = new ListItemRvAdapter()
    }

    public void clearStateStrategyPull() {
        getViewState().clearStateStrategyPull();
    }
}

