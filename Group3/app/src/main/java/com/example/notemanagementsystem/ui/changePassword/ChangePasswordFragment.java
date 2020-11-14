package com.example.notemanagementsystem.ui.changePassword;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.notemanagementsystem.R;
import com.example.notemanagementsystem.ui.note.NoteViewModel;

public class ChangePasswordFragment extends Fragment implements View.OnClickListener{

    private ChangePasswordViewModel changePasswordViewModel;
    private EditText etCurrentPass, etNewPass, etPassAgain;
    private Button btnChange, btnHome;

    public static ChangePasswordFragment newInstance() {
        return new ChangePasswordFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        changePasswordViewModel =
                ViewModelProviders.of(this).get(ChangePasswordViewModel.class);
        View root = inflater.inflate(R.layout.edit_profile_fragment, container, false);

        etCurrentPass = root.findViewById(R.id.etCurrentpass);
        etNewPass = root.findViewById(R.id.etNewPass);
        etPassAgain = root.findViewById(R.id.etPassAgain);

        btnChange = root.findViewById(R.id.btnChange);
        btnHome = root.findViewById(R.id.btnHome);

        btnChange.setOnClickListener(this);
        btnHome.setOnClickListener(this);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        changePasswordViewModel = ViewModelProviders.of(this).get(ChangePasswordViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.btnChange):

                break;
            case (R.id.btnHome):

                break;
        }

    }
}