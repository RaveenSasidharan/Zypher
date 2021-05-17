package com.panoslice.zyephr.di.component;

import com.panoslice.zyephr.di.module.DialogModule;
import com.panoslice.zyephr.di.scope.DialogScope;

import dagger.Component;

/*
 * Author: rotbolt
 */

@DialogScope
@Component(modules = DialogModule.class, dependencies = AppComponent.class)
public interface DialogComponent {

    //void inject(RateUsDialog dialog);

}
