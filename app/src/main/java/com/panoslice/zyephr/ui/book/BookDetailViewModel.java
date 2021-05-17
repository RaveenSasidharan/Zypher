package com.panoslice.zyephr.ui.book;

import com.panoslice.zyephr.data.DataManager;
import com.panoslice.zyephr.ui.base.BaseViewModel;
import com.panoslice.zyephr.utils.rx.SchedulerProvider;

public class BookDetailViewModel extends BaseViewModel<BookDetailNavigator> {
    public BookDetailViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
