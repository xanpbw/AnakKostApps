package com.xan.mvpapp;
//ondate 21/05/2019
//nim: 10116035
//nama:prabowo adi perwira
//kelas:AKB-1(IF-1)
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Logout extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_logout, container, false);
        return view;
    }
    @Override
    public void onViewCreated(View views, @Nullable Bundle savedInstanceState) {
        TextView nama = getView().findViewById(R.id.tv_namaMain);
        nama.setText(Preferences.getLoggedInUser(getActivity().getBaseContext()));
        getView().findViewById(R.id.button_logoutMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences.clearLoggedInUser(getActivity().getBaseContext());
                startActivity(new Intent(getActivity().getBaseContext(), LoginActivity.class));
                getActivity().finish();
            }
        });
    }
}
