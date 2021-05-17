package com.panoslice.zyephr.data.model.others;

public class FormResponse {
    private String formTitle;

    public FormResponse(String formTitle, String formValue) {
        this.formTitle = formTitle;
        this.formValue = formValue;
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
