package com.panoslice.zyephr.di.module;


import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.panoslice.zyephr.ViewModelProviderFactory;
import com.panoslice.zyephr.data.DataManager;
import com.panoslice.zyephr.ui.base.BaseActivity;
import com.panoslice.zyephr.ui.book.BookDetailViewModel;
import com.panoslice.zyephr.ui.form.FormReportViewModel;
import com.panoslice.zyephr.ui.home.HomeViewModel;
import com.panoslice.zyephr.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;



@Module
public class ActivityModule {
    private BaseActivity<?, ?> activity;

    public ActivityModule(BaseActivity<?, ?> activity) {
        this.activity = activity;
    }



    @Provides
    HomeViewModel provideHomeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<HomeViewModel> supplier = () -> new HomeViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<HomeViewModel> factory = new ViewModelProviderFactory<>(HomeViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(HomeViewModel.class);
    }

    @Provides
    BookDetailViewModel provideBookDetailViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<BookDetailViewModel> supplier = () -> new BookDetailViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<BookDetailViewModel> factory = new ViewModelProviderFactory<>(BookDetailViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(BookDetailViewModel.class);
    }

    @Provides
    FormReportViewModel provideFormDetailViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<FormReportViewModel> supplier = () -> new FormReportViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<FormReportViewModel> factory = new ViewModelProviderFactory<>(FormReportViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(FormReportViewModel.class);
    }
}
