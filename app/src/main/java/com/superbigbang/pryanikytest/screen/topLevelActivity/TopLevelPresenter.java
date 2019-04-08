package com.superbigbang.pryanikytest.screen.topLevelActivity;

import com.arellomobile.mvp.InjectViewState;
import com.superbigbang.pryanikytest.ExtendApplication;
import com.superbigbang.pryanikytest.adapter.ListItemRvAdapter;
import com.superbigbang.pryanikytest.entity.EntityDataImageText;
import com.superbigbang.pryanikytest.entity.EntityDataText;
import com.superbigbang.pryanikytest.entity.EntitySelector;
import com.superbigbang.pryanikytest.entity.ItemsForRecyclerView;
import com.superbigbang.pryanikytest.model.Data;
import com.superbigbang.pryanikytest.model.PryanikyTestService;
import com.superbigbang.pryanikytest.screen.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;


@InjectViewState
public class TopLevelPresenter extends BasePresenter<TopLevelView> {
    @Inject
    PryanikyTestService mPryanikyTestService;

    public TopLevelPresenter() {
        ExtendApplication.getBaseComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    void showList() {

        Disposable disposable = mPryanikyTestService.getJSONFile()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(json -> {
                    Timber.e("Success");
                    List<ItemsForRecyclerView> itemsForRecyclerViews = new ArrayList<>();
                    for (int i = 0; i < json.getView().size(); i++) {
                        for (int j = 0; j < json.getData().size(); j++) {
                            if (json.getView().get(i).equals(json.getData().get(j).getName())) {
                                Data data = json.getData().get(j);
                                if (data.getData().getUrl()!=null) {
                                    itemsForRecyclerViews.add(new EntityDataImageText(
                                            ItemsForRecyclerView.ITEM_DATA_IMAGE_TEXT,
                                            data.getName(),
                                            data.getData().getText(),
                                            data.getData().getUrl()));
                                } else if (data.getData().getSelectedId()!=null) {
                                    Timber.e(data.getName());
                                    Timber.e(String.valueOf(data.getData().getSelectedId()));
                                    Timber.e((String.valueOf(data.getData().getVariants().size())));
                                    itemsForRecyclerViews.add(new EntitySelector(
                                            ItemsForRecyclerView.ITEM_DATA_SELECTOR_LIST,
                                            data.getName(),
                                            data.getData().getSelectedId(),
                                            data.getData().getVariants()
                                    ));
                                } else {
                                    itemsForRecyclerViews.add(new EntityDataText(
                                            ItemsForRecyclerView.ITEM_DATA_TEXT,
                                            data.getName(),
                                            data.getData().getText()
                                    ));
                                }
                                break;
                            }
                            Timber.e("count");
                        }
                    }
                    ListItemRvAdapter listItemRvAdapter = new ListItemRvAdapter(itemsForRecyclerViews);
                    getViewState().showList(listItemRvAdapter);
                }, exception -> {
                    Timber.e("Exception%s", exception.getMessage());
                });

        unsubscribeOnDestroy(disposable);
    }

    public void clearStateStrategyPull() {
        getViewState().clearStateStrategyPull();
    }
}

