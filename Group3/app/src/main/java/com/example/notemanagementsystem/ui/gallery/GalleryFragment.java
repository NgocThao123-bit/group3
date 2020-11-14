package com.example.notemanagementsystem.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemanagementsystem.Database.AppDatabase;
import com.example.notemanagementsystem.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import java.util.Calendar;

public class GalleryFragment extends Fragment implements View.OnClickListener{

    private GalleryViewModel galleryViewModel;
    private FloatingActionButton fABtnAdd;
    private RecyclerView rvCategory;
    private CategoryAdapter mAdapter;
    private AppDatabase mDb;
    ArrayList<Category> categoryList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        fABtnAdd = root.findViewById(R.id.fABtnAdd);
        fABtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommentDialog.class);
                startActivity(intent);
            }
        });
        rvCategory = root.findViewById(R.id.rvCategory);
        rvCategory.setLayoutManager(new LinearLayoutManager());
        mAdapter = new CategoryAdapter(this);
//        categoryList = new ArrayList<>();

        if (getArguments() != null){
            String value = getArguments().getString("category");
            categoryList.add(new Category(value.toString(), (Calendar.getInstance().getTime()).toString()));
        }

        CategoryAdapter adapter = new CategoryAdapter(categoryList);

        rvCategory.setAdapter(adapter);

        rvCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.fABtnAdd:
                DialogFragment commentDialog = CommentDialog.newInstance();
                commentDialog.show(getParentFragmentManager(),"commentDialog");
        }
    }
}