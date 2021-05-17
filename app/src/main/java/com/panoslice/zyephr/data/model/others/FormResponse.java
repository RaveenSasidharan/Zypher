package com.panoslice.zyephr.data.model.others;

public class FormResponse {
    private String formTitle;
    private String formType;

    public FormResponse(String formTitle, String formValue, String formType) {
        this.formTitle = formTitle;
        this.formValue = formValue;
        this.formValue = formType;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public FormResponse() {
    }

    private String formValue;

    public String getFormTitle() {
        return formTitle;
    }

    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }

    public String getFormValue() {
        return formValue;
    }

    public void setFormValue(String formValue) {
        this.formValue = formValue;
    }
}
