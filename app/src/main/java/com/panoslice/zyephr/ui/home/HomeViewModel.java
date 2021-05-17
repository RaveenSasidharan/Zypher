package com.panoslice.zyephr.ui.home;

import com.panoslice.zyephr.data.DataManager;
import com.panoslice.zyephr.ui.base.BaseViewModel;
import com.panoslice.zyephr.utils.rx.SchedulerProvider;

public class HomeViewModel extends BaseViewModel<HomeNavigator> {
    public HomeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
