package com.superbigbang.pryanikytest.screen.topLevelActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.superbigbang.pryanikytest.ExtendApplication;
import com.superbigbang.pryanikytest.R;
import com.superbigbang.pryanikytest.adapter.ListItemRvAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopLevelViewActivity extends MvpAppCompatActivity implements TopLevelView {

    @InjectPresenter
    TopLevelPresenter mTopLevelPresenter;

    @BindView(R.id.TopLevelActivityRecyclerList)
    RecyclerView mRecyclerList;
    @BindView(R.id.topLevelActivityProgressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        ButterKnife.bind(this);

        LinearLayoutManager managerList = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerList.setLayoutManager(managerList);
        mTopLevelPresenter.showList();
    }

    @Override
    public void showList(ListItemRvAdapter listItemRvAdapter) {
        mRecyclerList.setAdapter(listItemRvAdapter);
        listItemRvAdapter.bindToRecyclerView(mRecyclerList);
        listItemRvAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (view.getId()) {
                case R.id.name_picture_item:
                    if (adapter.getViewByPosition(position, R.id.text_picture_item).getVisibility() == View.GONE) {
                        adapter.getViewByPosition(position, R.id.progressBar_picture_item).setVisibility(View.VISIBLE);
                        mTopLevelPresenter.loadSelectedPositionInfo((String) (((Button) view).getText()), adapter, view, position);
                    } else {
                        adapter.getViewByPosition(position, R.id.image_picture_item).setVisibility(View.GONE);
                        adapter.getViewByPosition(position, R.id.text_picture_item).setVisibility(View.GONE);
                    }
                    break;
                case R.id.name_HZ_item:
                    if (adapter.getViewByPosition(position, R.id.textData_HZ_item).getVisibility() == View.GONE) {
                        adapter.getViewByPosition(position, R.id.progressBar_HZ_item).setVisibility(View.VISIBLE);
                        mTopLevelPresenter.loadSelectedPositionInfo((String) (((Button) view).getText()), adapter, view, position);
                    } else {
                        adapter.getViewByPosition(position, R.id.textData_HZ_item).setVisibility(View.GONE);
                    }
                    break;
                case R.id.name_selector_item:
                    if (adapter.getViewByPosition(position, R.id.selector_list).getVisibility() == View.GONE) {
                        adapter.getViewByPosition(position, R.id.progressBar_selector_item).setVisibility(View.VISIBLE);
                        mTopLevelPresenter.loadSelectedPositionInfo((String) (((Button) view).getText()), adapter, view, position);
                    } else {
                        adapter.getViewByPosition(position, R.id.selector_list).setVisibility(View.GONE);
                    }
                    break;
            }
            if (view instanceof Button) {
                mTopLevelPresenter.sendMessageToScreen(200, "Button " + ((Button) view).getText() + ", has clicked at position: " + String.valueOf(position));
            } else if (view instanceof ImageView) {
                mTopLevelPresenter.sendMessageToScreen(200, "Image has clicked at position: " + String.valueOf(position));
                view.startAnimation(ExtendApplication.getAnimFadein());
            } else if (view instanceof TextView) {
                mTopLevelPresenter.sendMessageToScreen(200, "Text: " + ((TextView) view).getText() + ", has clicked at position: " + String.valueOf(position));
                view.startAnimation(ExtendApplication.getAnimFadein());
            } else if (view instanceof ProgressBar) {
                mTopLevelPresenter.sendMessageToScreen(200, "ProgressBar has clicked at position: " + String.valueOf(position) + ". Waiting data.");
                view.startAnimation(ExtendApplication.getAnimFadein());
            }
        });
    }

    public void changeVisibilityForProgressBar(boolean visible) {
        if (visible) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void clearStateStrategyPull() {
    }

    public void showErrorMessages(int errorId) {
        switch (errorId) {
            case 100:
                Toast.makeText(this, getString(R.string.error_loading_data), Toast.LENGTH_LONG).show();
                break;
        }
    }

    public void showMessage(int messageId, String additionalText) {
        switch (messageId) {
            case 200:
                Toast.makeText(this, additionalText, Toast.LENGTH_LONG).show();
                break;
        }
        }
    }

