package com.panoslice.zyephr.data.model.others;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FormData implements Serializable, Parcelable
{

    @SerializedName("field-name")
    @Expose
    private String fieldName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("required")
    @Expose
    private Boolean required;
    @SerializedName("min")
    @Expose
    private Integer min;
    @SerializedName("max")
    @Expose
    private Integer max;
    public final static Creator<FormData> CREATOR = new Creator<FormData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FormData createFromParcel(android.os.Parcel in) {
            return new FormData(in);
        }

        public FormData[] newArray(int size) {
            return (new FormData[size]);
        }

    }
            ;
    private final static long serialVersionUID = 5510724425224006938L;

    protected FormData(android.os.Parcel in) {
        this.fieldName = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.required = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.min = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.max = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public FormData() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(fieldName);
        dest.writeValue(type);
        dest.writeValue(required);
        dest.writeValue(min);
        dest.writeValue(max);
    }

    public int describeContents() {
        return 0;
    }

}