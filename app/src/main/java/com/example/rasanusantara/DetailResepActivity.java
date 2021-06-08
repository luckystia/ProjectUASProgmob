package com.example.rasanusantara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.rasanusantara.databinding.ActivityDetailResepBinding;

import java.util.Objects;

public class DetailResepActivity extends AppCompatActivity {
    private ActivityDetailResepBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailResepBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ItemModel data = getIntent().getParcelableExtra("extra_object");

        binding.tvHeadline.setText(data.getName());
        binding.tvSubhead.setText(data.getType());
        binding.ivDish.setImageResource(data.getImage());
        binding.tvIngredient.setText(MyItem.ingredients);
        binding.tvStep.setText(MyItem.step);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}