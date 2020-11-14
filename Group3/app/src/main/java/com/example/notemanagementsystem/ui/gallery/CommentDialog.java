package com.example.notemanagementsystem.ui.gallery;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.room.Room;

import com.example.notemanagementsystem.Database.AppDatabase;
import com.example.notemanagementsystem.Database.AppExecutors;
import com.example.notemanagementsystem.Database.Contants;
import com.example.notemanagementsystem.R;

import java.util.Calendar;
import java.util.Date;


public class CommentDialog extends DialogFragment implements View.OnClickListener {

    private EditText etComment;
    private Button btnCancel;
    private Button btnSubmit;
//    Database
    private String mCategoryName;
    private Intent intent;
    private AppDatabase mDb;
    Date currentTime = Calendar.getInstance().getTime();
    public static CommentDialog newInstance()
    {
        return new CommentDialog();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_comment, container, false);

        etComment = view.findViewById(R.id.etComment);
        btnCancel = view.findViewById(R.id.btnCancel);
        btnSubmit = view.findViewById(R.id.btnSubmit);

        btnCancel.setOnClickListener(this);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmitButtonClicked();
            }
        });

        mDb = Room.databaseBuilder(getContext(),AppDatabase.class,"app-database").build();
        intent = getActivity().getIntent();;
        if(intent!=null && intent.hasExtra(Contants.UPDATE_Category_Name))
        {
            btnSubmit.setText("Update");
            mCategoryName = intent.getStringExtra("UPDATE_Category_Name");

            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    Category category = mDb.categoryDAO().loadCategoryByName(mCategoryName);
                    populateUI(category);
                }
            });
        }
        setCancelable(false);

        onStart();

        return view;
    }

    private void onSubmitButtonClicked() {
        final Category category = new Category(
              etComment.getText().toString(),
                currentTime.toString());

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if(!intent.hasExtra(Contants.UPDATE_Category_Name))
                {
                    mDb.categoryDAO().insert(category);
                }
                else
                {
                    category.setName(mCategoryName);
                    mDb.categoryDAO().update(category);
                }

            }
        });
    }


//    private void submit()
//    {
//
////        GalleryFragment fragment = new GalleryFragment();
////        Bundle bundle = new Bundle();
////        bundle.putString("category", etComment.getText().toString());
////        fragment.setArguments(bundle);
////
////        getFragmentManager().beginTransaction().add(R.id.nav_host_fragment, fragment).commit();
//        dismiss();
//    }

    private void populateUI(Category category)
    {
        if(category == null)
        {
            return;
        }

        etComment.setText(category.getName());

    }
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if(dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnCancel:
                dismiss();
                break;
            case R.id.btnSubmit:
                onSubmitButtonClicked();
                break;
        }
    }
}
