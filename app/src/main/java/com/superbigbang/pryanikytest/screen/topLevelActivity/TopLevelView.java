package com.superbigbang.pryanikytest.screen.topLevelActivity;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.superbigbang.pryanikytest.adapter.ListItemRvAdapter;
import com.superbigbang.pryanikytest.customMoxyStrategies.ClearStateStrategy;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface TopLevelView extends MvpView {

    void showList(ListItemRvAdapter listItemRvAdapter);

    void showErrorMessages(int errorID);

    void showMessage(int messageId, String additionalText);

    @StateStrategyType(ClearStateStrategy.class)
    void clearStateStrategyPull();
}
