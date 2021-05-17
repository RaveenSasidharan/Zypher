package com.panoslice.zyephr.di.module;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.panoslice.zyephr.ViewModelProviderFactory;
import com.panoslice.zyephr.data.DataManager;
import com.panoslice.zyephr.ui.base.BaseFragment;
import com.panoslice.zyephr.ui.home.books.BookViewModel;
import com.panoslice.zyephr.ui.home.form.FormViewModel;
import com.panoslice.zyephr.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;



@Module
public class FragmentModule {

    private BaseFragment<?, ?> fragment;

    public FragmentModule(BaseFragment<?, ?> fragment) {
        this.fragment = fragment;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(fragment.getActivity());
    }

    @Provides
    FormViewModel provideFormViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<FormViewModel> supplier = () -> new FormViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<FormViewModel> factory = new ViewModelProviderFactory<>(FormViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(FormViewModel.class);
    }

    @Provides
    BookViewModel provideBookViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        Supplier<BookViewModel> supplier = () -> new BookViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<BookViewModel> factory = new ViewModelProviderFactory<>(BookViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(BookViewModel.class);
    }

}
