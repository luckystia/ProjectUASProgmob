package com.example.rasanusantara.ui.resep;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rasanusantara.AdapterRecyclerView;
import com.example.rasanusantara.ItemModel;
import com.example.rasanusantara.MyItem;
import com.example.rasanusantara.TambahResepActivity;
import com.example.rasanusantara.databinding.FragmentResepBinding;

import java.util.ArrayList;
import java.util.Objects;

public class ResepFragment extends Fragment {
    private FragmentResepBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentResepBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView.LayoutManager recylerViewLayoutManager = new LinearLayoutManager(getActivity());
        ArrayList<ItemModel> data = new ArrayList<>();

        for (int i = 0; i < MyItem.Headline.length; i++) {
            data.add(new ItemModel(
                    MyItem.Headline[i],
                    MyItem.Subhead[i],
                    MyItem.iconList[i]
            ));
        }

        AdapterRecyclerView adapter = new AdapterRecyclerView(data);

        binding.rvResep.setLayoutManager(recylerViewLayoutManager);
        binding.rvResep.setHasFixedSize(true);
        binding.rvResep.setAdapter(adapter);

        binding.fabAddResep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), TambahResepActivity.class);
                requireContext().startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}