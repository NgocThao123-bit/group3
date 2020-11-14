package com.example.notemanagementsystem.ui.note;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notemanagementsystem.R;
import com.example.notemanagementsystem.ui.Status.StatusViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NoteFragment extends Fragment  implements View.OnClickListener{

    private NoteViewModel noteViewModel;
    private FloatingActionButton fabAdd;

    public static NoteFragment newInstance() {
        return new NoteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        noteViewModel =
                ViewModelProviders.of(this).get(NoteViewModel.class);
        View root = inflater.inflate(R.layout.status_fragment, container, false);

        fabAdd = root.findViewById(R.id.fab);
        fabAdd.setOnClickListener(this);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fabAdd:

        }

    }
}