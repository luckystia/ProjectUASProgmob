package com.example.rasanusantara;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.rasanusantara.databinding.ActivityTambahResepBinding;

import java.util.Objects;


public class TambahResepActivity extends AppCompatActivity {

    private ActivityTambahResepBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTambahResepBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        binding.simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClicked();
                Toast.makeText(TambahResepActivity.this, "Data Resep Berhasil Ditambah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnClicked() {
        String nama = binding.inputNama.getText().toString();
        binding.hasilNama.setText(nama);
        String nik = binding.inputNik.getText().toString();
        binding.hasilNik.setText(nik);
        String umur = binding.inputUmur.getText().toString();
        binding.hasilUmur.setText(umur);
        String alamat = binding.inputAlamat.getText().toString();
        binding.hasilAlamat.setText(alamat);
    }

    public void submit(View view) {
    }
}