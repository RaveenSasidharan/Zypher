package com.panoslice.zyephr.di.component;

import com.panoslice.zyephr.di.module.FragmentModule;
import com.panoslice.zyephr.di.scope.FragmentScope;
import com.panoslice.zyephr.ui.home.books.BookFragment;
import com.panoslice.zyephr.ui.home.form.FormFragment;

import dagger.Component;


@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {
    void inject(BookFragment fragment);

    void inject(FormFragment fragment);

}
