package com.example.navbaryhui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    private TextView saldoTextView, namaTextView;
    private Button editProfilButton;
    private static final int EDIT_PROFILE_REQUEST = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        saldoTextView = view.findViewById(R.id.saldoTextView);
        namaTextView = view.findViewById(R.id.namaHome);
        editProfilButton = view.findViewById(R.id.editProfilButton);

        // Mengisi data saldo dan nama (gantilah dengan data nyata)
        String saldo = "Saldo Anda: Rp 1,000,000";
        String nama = "John Doe";

        saldoTextView.setText(saldo);
        namaTextView.setText(nama);

        editProfilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Buka EditProfileActivity ketika tombol edit profil diklik
                Intent intent = new Intent(getActivity(), ProfileFragment.class);
                startActivityForResult(intent, EDIT_PROFILE_REQUEST);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDIT_PROFILE_REQUEST && resultCode == AppCompatActivity.RESULT_OK && data != null) {
            // Terima data yang telah diperbarui dari EditProfileActivity
            String namaBaru = data.getStringExtra("nama");
            String saldoBaru = data.getStringExtra("saldo");

            // Perbarui tampilan dengan data yang baru
            namaTextView.setText(namaBaru);
            saldoTextView.setText(saldoBaru);
        }
    }
}
