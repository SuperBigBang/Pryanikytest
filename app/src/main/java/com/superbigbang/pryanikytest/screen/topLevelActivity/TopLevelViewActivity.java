package com.superbigbang.pryanikytest.screen.topLevelActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.superbigbang.pryanikytest.ExtendApplication;
import com.superbigbang.pryanikytest.R;
import com.superbigbang.pryanikytest.adapter.ListItemRvAdapter;

import butterknife.ButterKnife;

public class TopLevelViewActivity extends MvpAppCompatActivity implements TopLevelView {

    private static final String APP_PREFERENCES = "PRYANIKYTEST_PREFERENCES";
    @InjectPresenter
    TopLevelPresenter mTopLevelPresenter;
    SharedPreferences mSettings;

    RecyclerView mRecyclerSongsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        ButterKnife.bind(this);
        ;

        LinearLayoutManager managerList = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
     //   mRecyclerSongsList.setLayoutManager(managerList);
     //   mTopLevelPresenter.showList();
    }

    @Override
    public void showList(ListItemRvAdapter listItemRvAdapter) {
        mRecyclerSongsList.setAdapter(listItemRvAdapter);
        listItemRvAdapter.setOnItemChildClickListener((adapter, view, position) -> {
           /* if (view.getId() == R.id.) {
              mTopLevelPresenter. ;
            }*/
            view.startAnimation(ExtendApplication.getAnimFadein());
        });
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
