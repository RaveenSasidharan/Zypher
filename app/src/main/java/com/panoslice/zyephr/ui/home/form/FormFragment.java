package com.panoslice.zyephr.ui.home.form;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.panoslice.zyephr.BR;
import com.panoslice.zyephr.R;
import com.panoslice.zyephr.data.model.db.FormEntity;
import com.panoslice.zyephr.data.model.others.FormData;
import com.panoslice.zyephr.databinding.FragmentFormBinding;
import com.panoslice.zyephr.di.component.FragmentComponent;
import com.panoslice.zyephr.ui.base.BaseFragment;
import com.panoslice.zyephr.ui.form.FormReportActivity;
import com.panoslice.zyephr.utils.CommonUtils;


import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;



public class FormFragment extends BaseFragment<FragmentFormBinding, FormViewModel> implements FormNavigator{

    private FragmentFormBinding mFormBinding;
    private String mValidationSchema;
    private List<IFormControl> formControlList;
    private String mUUID;

    @Override
    public int getBindingVariable() {
        return BR.formViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_form;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUUID = UUID.randomUUID().toString();

        mFormBinding = getViewDataBinding();
        mFormBinding.setFormFragment(this);
        formControlList  = new ArrayList<>();
        try {
            setUpUI(CommonUtils.loadJSONFromAsset(getActivity(), "file_values.json"));
            mValidationSchema = CommonUtils.loadJSONFromAsset(getActivity(), "file_value_schema.json");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }



    private void setUpUI(String  inputString)
    {
        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<FormData>>() {}.getType();
        List<FormData> outputList = gson.fromJson(inputString, type);

        for (FormData formData : outputList)
        {
            FormEditText formEditText = new FormEditText(getActivity(), formData);
            formControlList.add(formEditText);
            mFormBinding.formContainer.addView(formEditText);
        }
    }




    public boolean isValidated(JSONObject responseObject) throws JSONException {
        JSONObject validationObject = new JSONObject(mValidationSchema);

        try {
            Schema schema = SchemaLoader.load(validationObject);
            schema.validate(responseObject);
            return true;
        }catch (ValidationException validationException)
        {
            Toast.makeText(getActivity(), "" + validationException.getErrorMessage(), Toast.LENGTH_LONG).show();
            return false;
        }



    }




    public void clear()
    {
        for (IFormControl formControl : formControlList)
            formControl.clearData();

        FormEntity formEntity = new FormEntity(mUUID, "");
        mViewModel.clearData(formEntity);
    }



    public void submitt()
    {
        JSONObject responseObject = new JSONObject();

        try {
            for (IFormControl formControl : formControlList)
            {
                if (formControl.getFormResponse() != null)
                {
                    if (formControl.getFormResponse().getFormType().equals("number"))
                        responseObject.put(formControl.getFormResponse().getFormTitle(), Integer.parseInt(formControl.getFormResponse().getFormValue()));
                    else
                        responseObject.put(formControl.getFormResponse().getFormTitle(), formControl.getFormResponse().getFormValue());

                }
            }

            if (isValidated(responseObject)){
                FormEntity formEntity = new FormEntity(mUUID, responseObject.toString());
                mViewModel.insertData(formEntity);

                Toast.makeText(getActivity(), "Data Saved", Toast.LENGTH_LONG).show();
            }
        } catch (JSONException e) {
            Log.e("form","error"+e.getMessage());
            e.printStackTrace();
            Toast.makeText(getActivity(), "Data Corrupted", Toast.LENGTH_LONG).show();
        }

    }



    public void showReportActivity()
    {
        startActivity(FormReportActivity.newIntent(getActivity()));
    }

}
