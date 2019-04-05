package com.superbigbang.pryanikytest.screen.topLevelActivity;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;


@InjectViewState
public class TopLevelPresenter extends MvpPresenter<TopLevelView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    void showList() {
        // getViewState().showList();
    }

    public void clearStateStrategyPull() {
        getViewState().clearStateStrategyPull();
    }
}

