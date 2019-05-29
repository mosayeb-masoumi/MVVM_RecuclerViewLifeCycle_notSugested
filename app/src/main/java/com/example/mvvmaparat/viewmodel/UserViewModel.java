package com.example.mvvmaparat.viewmodel;


import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mvvmaparat.BR;
import com.example.mvvmaparat.model.User;
import com.example.mvvmaparat.view.adapter.UserAdapter;

import java.util.ArrayList;


public class UserViewModel extends BaseObservable {


   private MutableLiveData<ArrayList<UserViewModel>> arrayListMutableLiveData = new MutableLiveData<>();
   private ArrayList<UserViewModel> arrayListHolder = new ArrayList<>();



    private String name;
    private String phone;

    private Context context;

    public UserViewModel(User user) {
        this.name = user.getName();
        this.phone = user.getPhone();

    }


    public UserViewModel(Context context) {
        this.context = context;

        //conect to server IP

        // dasty
        for (int i = 0; i <5 ; i++) {
            User user = new User("hassan"+i , "09372112652");


            UserViewModel userViewModel = new UserViewModel(user);
            arrayListHolder.add(userViewModel);
        }
        arrayListMutableLiveData.setValue(arrayListHolder);
    }

 @BindingAdapter("bind:recyclerUser")
 public static void recyclerViewBinder (final RecyclerView recyclerView , MutableLiveData<ArrayList<UserViewModel>> arrayListMutableLiveData)
 {

     arrayListMutableLiveData.observe((LifecycleOwner) recyclerView.getContext(), new Observer<ArrayList<UserViewModel>>() {
         @Override
         public void onChanged(@Nullable ArrayList<UserViewModel> userViewModels) {

             UserAdapter userAdapter = new UserAdapter(userViewModels);
             recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext() , LinearLayoutManager.VERTICAL , false));
             recyclerView.setAdapter(userAdapter);
         }
     });
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


    public MutableLiveData<ArrayList<UserViewModel>> getArrayListMutableLiveData() {
        return arrayListMutableLiveData;
    }
}
