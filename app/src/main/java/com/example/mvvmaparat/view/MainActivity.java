package com.example.mvvmaparat.view;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvvmaparat.R;
import com.example.mvvmaparat.databinding.ActivityMainBinding;
import com.example.mvvmaparat.model.User;
import com.example.mvvmaparat.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        UserViewModel userViewModel= new UserViewModel(this);
        mainBinding.setUser(userViewModel);



    }
}
