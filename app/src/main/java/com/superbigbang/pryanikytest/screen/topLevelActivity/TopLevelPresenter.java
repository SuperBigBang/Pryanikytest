package com.superbigbang.pryanikytest.screen.topLevelActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.InjectViewState;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.superbigbang.pryanikytest.ExtendApplication;
import com.superbigbang.pryanikytest.R;
import com.superbigbang.pryanikytest.adapter.ListItemRvAdapter;
import com.superbigbang.pryanikytest.adapter.NestAdapter;
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
    public static final String ITEM_TEXT_HZ = "hz";
    public static final String ITEM_PICTURE_WITH_TEXT = "picture";
    public static final String ITEM_SELECTOR = "selector";

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
                                if (data.getName().equalsIgnoreCase(ITEM_PICTURE_WITH_TEXT)) {
                                    itemsForRecyclerViews.add(new EntityDataImageText(
                                            ItemsForRecyclerView.ITEM_DATA_IMAGE_TEXT,
                                            data.getName(),
                                            data.getData().getText(),
                                            data.getData().getUrl()));
                                } else if (data.getName().equalsIgnoreCase(ITEM_SELECTOR)) {
                                    itemsForRecyclerViews.add(new EntitySelector(
                                            ItemsForRecyclerView.ITEM_DATA_SELECTOR_LIST,
                                            data.getName(),
                                            data.getData().getSelectedId(),
                                            data.getData().getVariants()));
                                } else if (data.getName().equalsIgnoreCase(ITEM_TEXT_HZ)) {
                                    itemsForRecyclerViews.add(new EntityDataText(
                                            ItemsForRecyclerView.ITEM_DATA_TEXT,
                                            data.getName(),
                                            data.getData().getText()));
                                }
                                break;
                            }
                        }
                    }
                    ListItemRvAdapter listItemRvAdapter = new ListItemRvAdapter(itemsForRecyclerViews);
                    getViewState().changeVisibilityForProgressBar(false);
                    getViewState().showList(listItemRvAdapter);
                }, exception -> {
                    getViewState().changeVisibilityForProgressBar(false);
                    getViewState().showErrorMessages(100);
                    Timber.e("Exception%s", exception.getMessage());
                });
        unsubscribeOnDestroy(disposable);
    }

    void loadSelectedPositionInfo(BaseQuickAdapter adapter, int position) {
        ItemsForRecyclerView item = (ItemsForRecyclerView) adapter.getData().get(position);
        if (item.getName().equalsIgnoreCase(ITEM_PICTURE_WITH_TEXT)) {
                                adapter.getViewByPosition(position, R.id.image_picture_item).setVisibility(View.VISIBLE);
                                adapter.getViewByPosition(position, R.id.text_picture_item).setVisibility(View.VISIBLE);
            ((TextView) adapter.getViewByPosition(position, R.id.text_picture_item)).setText(((EntityDataImageText) item).getDataText());
                                adapter.getViewByPosition(position, R.id.progressBar_picture_item).setVisibility(View.GONE);
        } else if (item.getName().equalsIgnoreCase(ITEM_SELECTOR)) {
                                adapter.getViewByPosition(position, R.id.selector_list).setVisibility(View.VISIBLE);
                                final RecyclerView recyclerView = (RecyclerView) adapter.getViewByPosition(position, R.id.selector_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(adapter.getViewByPosition(position, R.id.selector_list)
                    .getContext(),
                    LinearLayoutManager.VERTICAL,
                    false));
                                recyclerView.setHasFixedSize(true);
            NestAdapter nestAdapter = new NestAdapter((((EntitySelector) item).getVariants()), ((EntitySelector) item).getSelectedId());
                                nestAdapter.checkedChangeListener = (buttonView, isChecked) -> {
                                    int position2 = recyclerView.findContainingViewHolder(buttonView).getLayoutPosition();
                                    if (isChecked) {
                                        SwitchCompat switchCompatSavedPosition = ((SwitchCompat) nestAdapter.getViewByPosition(nestAdapter.getSavedPositionOfSelectedID(), R.id.switch_nestSelector_item));
                                        switchCompatSavedPosition.setOnCheckedChangeListener(null);
                                        switchCompatSavedPosition.setChecked(false);
                                        switchCompatSavedPosition.setOnCheckedChangeListener(nestAdapter.getCheckedChangeListener());
                                        nestAdapter.setSavedPositionOfSelectedID(position2);
                                        sendMessageToScreen(200, "Switch at ID: "
                                                + (((TextView) nestAdapter.getViewByPosition(position2, R.id.id_nestSelector_item)).getText())
                                                + ", with Value: "
                                                + (((TextView) nestAdapter.getViewByPosition(position2, R.id.name_nestSelector_item)).getText())
                                                + ", has turn ON at position: " + String.valueOf(position2));
                                    } else {
                                        SwitchCompat switchCompatSavedPosition = ((SwitchCompat) buttonView);
                                        switchCompatSavedPosition.setOnCheckedChangeListener(null);
                                        switchCompatSavedPosition.setChecked(true);
                                        switchCompatSavedPosition.setOnCheckedChangeListener(nestAdapter.getCheckedChangeListener());
                                        sendMessageToScreen(200, "Switch at ID: "
                                                + (((TextView) nestAdapter.getViewByPosition(position2, R.id.id_nestSelector_item)).getText())
                                                + ", with Value: "
                                                + (((TextView) nestAdapter.getViewByPosition(position2, R.id.name_nestSelector_item)).getText())
                                                + ", tried to be switched at position: " + String.valueOf(position2)
                                                + ", but one option must be chosen.");
                                    }
                                };
                                recyclerView.setAdapter(nestAdapter);
                                adapter.getViewByPosition(position, R.id.progressBar_selector_item).setVisibility(View.GONE);

                                nestAdapter.bindToRecyclerView(recyclerView);
                                nestAdapter.setOnItemChildClickListener((adapter2, view2, position2) -> {
                                    switch (view2.getId()) {
                                        case R.id.name_nestSelector_item:
                                            view2.startAnimation(ExtendApplication.getAnimFadein());
                                            sendMessageToScreen(200, "Item " + ((TextView) view2).getText()
                                                    + ", has clicked at position: " + String.valueOf(position2));
                                            break;
                                        case R.id.id_nestSelector_item:
                                            view2.startAnimation(ExtendApplication.getAnimFadein());
                                            sendMessageToScreen(200, "Item \"ID\" " + ((TextView) view2).getText()
                                                    + ", has clicked at position: " + String.valueOf(position2));
                                            break;
                                    }
                                });
        } else if (item.getName().equalsIgnoreCase(ITEM_TEXT_HZ)) {
                                adapter.getViewByPosition(position, R.id.textData_HZ_item).setVisibility(View.VISIBLE);
            ((TextView) adapter.getViewByPosition(position, R.id.textData_HZ_item)).setText(((EntityDataText) item).getDataText());
                                adapter.getViewByPosition(position, R.id.progressBar_HZ_item).setVisibility(View.GONE);
                            }
    }

    void sendMessageToScreen(int messageId, String additionalText) {
        getViewState().showMessage(messageId, additionalText);
    }
}
