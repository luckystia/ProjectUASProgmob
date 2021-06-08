package com.example.rasanusantara.ui.home;

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
import com.example.rasanusantara.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager recylerViewLayoutManager;
    private ArrayList<ItemModel> data;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recylerViewLayoutManager = new LinearLayoutManager(getActivity());
        data = new ArrayList<>();
        for (int i = 0; i < MyItem.Headline.length; i++) {
            data.add(new ItemModel(
                    MyItem.Headline[i],
                    MyItem.Subhead[i],
                    MyItem.iconList[i]
            ));
        }
        adapter = new AdapterRecyclerView(data);

        binding.rvRekomendasi.setLayoutManager(recylerViewLayoutManager);
        binding.rvRekomendasi.setAdapter(adapter);
        binding.rvRekomendasi.setHasFixedSize(true);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}