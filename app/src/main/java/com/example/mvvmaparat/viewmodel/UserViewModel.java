package com.example.mvvmaparat.viewmodel;


import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.mvvmaparat.BR;
import com.example.mvvmaparat.model.User;


public class UserViewModel extends BaseObservable {

    private String name;
    private String phone;

    private Context context;

    public UserViewModel(User user) {
        this.name = name;
        this.phone = phone;
    }


    public UserViewModel(Context context) {
        this.context = context;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }
}
