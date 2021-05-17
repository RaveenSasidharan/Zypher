package com.panoslice.zyephr.ui.form;

import com.panoslice.zyephr.data.model.db.FormEntity;
import com.panoslice.zyephr.ui.base.Navigator;

import java.util.List;

public interface FormReportNavigator extends Navigator {
    void populateReport(List<FormEntity> formEntityList);
}
