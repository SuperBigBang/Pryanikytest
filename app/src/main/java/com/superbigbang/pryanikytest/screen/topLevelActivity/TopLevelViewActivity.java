package com.superbigbang.pryanikytest.screen.topLevelActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.superbigbang.pryanikytest.R;
import com.superbigbang.pryanikytest.adapter.ListItemRvAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopLevelViewActivity extends MvpAppCompatActivity implements TopLevelView {

    private static final String APP_PREFERENCES = "PRYANIKYTEST_PREFERENCES";
    @InjectPresenter
    TopLevelPresenter mTopLevelPresenter;
    SharedPreferences mSettings;

    @BindView(R.id.RecyclerList)
    RecyclerView mRecyclerList;
    @BindView(R.id.progressBar4)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
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
                case R.id.name:
                    if (adapter.getViewByPosition(position, R.id.textData).getVisibility() == View.GONE) {
                        adapter.getViewByPosition(position, R.id.progressBar).setVisibility(View.VISIBLE);
                        mTopLevelPresenter.loadSelectedPositionInfo((String) (((Button) adapter.getViewByPosition(position, R.id.name)).getText()), adapter, view, position);
                    } else {
                        adapter.getViewByPosition(position, R.id.imageData).setVisibility(View.GONE);
                        adapter.getViewByPosition(position, R.id.textData).setVisibility(View.GONE);
                    }
                    break;
                //case R.id.
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
    protected void onStop() {
        super.onStop();
        //Save on sharedpreference when app stop
        SharedPreferences.Editor editor = mSettings.edit();
        //  editor.put
        editor.apply();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void clearStateStrategyPull() {
    }

    public void showErrorMessages(int errorId) {
      /*  switch (errorId) {
            case 100:
                Toast.makeText(this, getText(R.string.).show();
                break;
        }*/
    }

    public void showMessage(int messageId, String additionalText) {
        switch (messageId) {
        /*    case 200:
                Toast.makeText(this, getText(R.string.), Toast.LENGTH_SHORT).show();
                break;
        }*/
        }
    }
}
