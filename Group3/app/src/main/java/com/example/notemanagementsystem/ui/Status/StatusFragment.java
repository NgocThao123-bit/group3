package com.example.notemanagementsystem.ui.Status;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notemanagementsystem.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StatusFragment extends Fragment implements View.OnClickListener{

    private StatusViewModel statusViewModel;
    private FloatingActionButton fab;


    public static StatusFragment newInstance() {
        return new StatusFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        statusViewModel =
                ViewModelProviders.of(this).get(StatusViewModel.class);
        View root = inflater.inflate(R.layout.status_fragment, container, false);

        fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(this);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        statusViewModel = ViewModelProviders.of(this).get(StatusViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.fab:

        }
    }
}