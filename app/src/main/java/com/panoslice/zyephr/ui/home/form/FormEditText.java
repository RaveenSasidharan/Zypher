package com.panoslice.zyephr.ui.home.form;

import android.content.Context;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.appcompat.widget.AppCompatEditText;

import com.panoslice.zyephr.data.model.others.FormData;
import com.panoslice.zyephr.data.model.others.FormResponse;
import com.panoslice.zyephr.databinding.FormInputLayoutBinding;
import com.panoslice.zyephr.databinding.ListBookItemBinding;

public class FormEditText  extends FrameLayout implements IFormControl {

    private FormData formData;
    private FormInputLayoutBinding mFormBinding;

    public FormEditText(Context context, FormData formData) {
        super(context);
        this.formData = formData;
        init();
    }

    public FormEditText(Context context) {
        super(context);
    }

    public FormEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FormEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void init()
    {
        mFormBinding = FormInputLayoutBinding.inflate(LayoutInflater.from(getContext()));


        if (formData.getType().equals("number"))
            mFormBinding.formInputEdit.setInputType(InputType.TYPE_CLASS_NUMBER);

        if (formData.getType().equals("multiline"))
            mFormBinding.formInputEdit.setSingleLine(false);
        else
            mFormBinding.formInputEdit.setSingleLine(true);

        mFormBinding.formInputEdit.setHint(formData.getFieldName());
        mFormBinding.formInputLayout.setHint(formData.getFieldName());
        addView(mFormBinding.getRoot());

    }


    @Override
    public FormResponse getFormResponse() {
        if (mFormBinding.formInputEdit.getText() == null && TextUtils.isEmpty(mFormBinding.formInputEdit.getText().toString()))
            return null;

        FormResponse formResponse = new FormResponse();
        formResponse.setFormTitle(formData.getFieldName());
        formResponse.setFormValue(mFormBinding.formInputEdit.getText().toString());

        return formResponse;
    }

    @Override
    public void clearData() {
        mFormBinding.formInputEdit.setText(null);
    }
}
