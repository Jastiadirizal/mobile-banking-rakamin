package com.example.navbaryhui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class ProfileFragment extends Fragment {

    private EditText newNameEditText, newEmailEditText, newAccountEditText, newPhoneEditText;
    private Button saveButton, logoutButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        newNameEditText = view.findViewById(R.id.newNameEditText);
        newEmailEditText = view.findViewById(R.id.newEmailEditText);
        newAccountEditText = view.findViewById(R.id.newAccountEditText);
        newPhoneEditText = view.findViewById(R.id.newPhoneEditText);
        saveButton = view.findViewById(R.id.saveButton);
        logoutButton = view.findViewById(R.id.logoutButton);

        // Terima data profil dari Intent
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            String namaLama = intent.getStringExtra("nama");
            String emailLama = intent.getStringExtra("email");
            String rekeningLama = intent.getStringExtra("rekening");
            String hpLama = intent.getStringExtra("hp");

            // Isi nilai-nilai inputan dengan data profil lama
            newNameEditText.setText(namaLama);
            newEmailEditText.setText(emailLama);
            newAccountEditText.setText(rekeningLama);
            newPhoneEditText.setText(hpLama);
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil data yang diubah oleh pengguna
                String newName = newNameEditText.getText().toString();
                String newEmail = newEmailEditText.getText().toString();
                String newAccount = newAccountEditText.getText().toString();
                String newPhone = newPhoneEditText.getText().toString();

                // Kembali ke DashboardActivity setelah menyimpan
                Intent intent = new Intent();
                // Kirim data profil yang telah diperbarui
                intent.putExtra("nama", newName);
                intent.putExtra("email", newEmail);
                intent.putExtra("rekening", newAccount);
                intent.putExtra("hp", newPhone);
                getActivity().setResult(getActivity().RESULT_OK, intent); // Atur resultCode menjadi RESULT_OK
                getActivity().finish(); // Tutup aktivitas EditProfileActivity
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Setelah logout, arahkan pengguna ke halaman login
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}
