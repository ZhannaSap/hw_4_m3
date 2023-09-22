package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentABinding;

import java.util.ArrayList;


public class FragmentA extends Fragment implements OnClick{
    private FragmentABinding binding;
    private ArrayList<Continent> listContinent;
    private ContinentAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentABinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        adapter = new ContinentAdapter(listContinent, this::onClick);
        binding.rvContinent.setAdapter(adapter);
    }

    private void loadData() {
        listContinent = new ArrayList<>();
        listContinent.add(new Continent("Евразия"));
        listContinent.add(new Continent("Африка"));
        listContinent.add(new Continent(" Северная Америка"));
        listContinent.add(new Continent("Южная Америка"));
        listContinent.add(new Continent("Австралия"));
    }


    @Override
    public void onClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("key",position );

        FragmentB countryFragment = new FragmentB();
        countryFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, countryFragment).addToBackStack(null).commit();
    }
}