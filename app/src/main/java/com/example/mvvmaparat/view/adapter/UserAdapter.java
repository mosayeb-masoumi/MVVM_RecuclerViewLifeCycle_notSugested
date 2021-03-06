package com.example.mvvmaparat.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmaparat.R;
import com.example.mvvmaparat.databinding.ItemUserBinding;
import com.example.mvvmaparat.viewmodel.UserViewModel;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.CustomHolder> {

    private ArrayList<UserViewModel> arrayList = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public UserAdapter(ArrayList<UserViewModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

         if(layoutInflater==null)
            layoutInflater = LayoutInflater.from(parent.getContext());

         ItemUserBinding userBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_user,parent,false);
         return new CustomHolder(userBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {

        UserViewModel userViewModel = arrayList.get(position);
        holder.bind(userViewModel);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class CustomHolder extends RecyclerView.ViewHolder {
        private ItemUserBinding itemUserBinding;

        public CustomHolder(ItemUserBinding itemUserBinding) {
            super(itemUserBinding.getRoot());
            this.itemUserBinding = itemUserBinding;
        }

        private void bind(UserViewModel userViewModel) {
            this.itemUserBinding.setItem(userViewModel);
            this.itemUserBinding.executePendingBindings();
        }

        //getter
        public ItemUserBinding getItemUserBinding() {
            return itemUserBinding;
        }
    }
}
