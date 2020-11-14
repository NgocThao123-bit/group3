package com.example.notemanagementsystem.ui.editProfile;

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

public class EditProfileFragment extends Fragment implements View.OnClickListener{

    private EditProfileViewModel editProfileViewModel;
    private EditText etFirstName, etLastName, etEmail;
    private Button btnChange, btnHome;

    public static EditProfileFragment newInstance() {
        return new EditProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        editProfileViewModel =
                ViewModelProviders.of(this).get(EditProfileViewModel.class);
        View root = inflater.inflate(R.layout.edit_profile_fragment, container, false);

        etFirstName = root.findViewById(R.id.etFirstName);
        etLastName = root.findViewById(R.id.etLastName);
        etEmail = root.findViewById(R.id.etEmail);

        btnChange = root.findViewById(R.id.btnChange);
        btnHome = root.findViewById(R.id.btnHome);

        btnChange.setOnClickListener(this);
        btnHome.setOnClickListener(this);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        editProfileViewModel = ViewModelProviders.of(this).get(EditProfileViewModel.class);
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