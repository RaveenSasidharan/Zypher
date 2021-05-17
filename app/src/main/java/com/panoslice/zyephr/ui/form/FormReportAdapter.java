package com.panoslice.zyephr.ui.form;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.panoslice.zyephr.data.model.db.FormEntity;
import com.panoslice.zyephr.databinding.ListBookItemBinding;
import com.panoslice.zyephr.databinding.ListFormReportItemBinding;
import com.panoslice.zyephr.ui.base.BaseViewHolder;
import com.panoslice.zyephr.ui.home.books.BookAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

public class FormReportAdapter extends RecyclerView.Adapter<FormReportAdapter.ReportHolder> {
    private List<FormEntity> mFormEntityList;

    public void setFormEntityList(List<FormEntity> formEntityList) {
        this.mFormEntityList = formEntityList;
    }

    public FormReportAdapter()
    {

    }

    @NonNull
    @Override
    public ReportHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ListFormReportItemBinding listFormReportItemBinding = ListFormReportItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ReportHolder(listFormReportItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (mFormEntityList == null)
            return 0;
        else
            return mFormEntityList.size();
    }

    public class ReportHolder extends BaseViewHolder
    {
        private  ListFormReportItemBinding reportItemBinding;

        public ReportHolder(ListFormReportItemBinding binding)
        {
            super(binding.getRoot());
            reportItemBinding = binding;
        }

        @Override
        public void onBind(int position) {
            reportItemBinding.id.setText(mFormEntityList.get(position).getId());
            try {
                JSONObject responseOBject = new JSONObject(mFormEntityList.get(position).getResponse());

                Iterator<?> keys = responseOBject.keys();
                while(keys.hasNext() ) {
                    String key = (String)keys.next();
                    String value = responseOBject.get(key).toString();

                    TextView textView =  new TextView(reportItemBinding.getRoot().getContext());
                    textView.setTextColor(Color.WHITE);
                    textView.setText(key +" : "+value);

                    reportItemBinding.resultlayout.addView(textView);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
}
