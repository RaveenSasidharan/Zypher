package com.panoslice.zyephr.ui.home.form;

import com.panoslice.zyephr.data.model.others.FormResponse;

public interface IFormControl {

    FormResponse getFormResponse();
    void clearData();
}
