package com.example.hw6_3;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class FragmentChild extends Fragment {
    Button btnSend;
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_child, container, false);

        btnSend = v.findViewById(R.id.btnSend);
        editText = v.findViewById(R.id.editText);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                String txt = editText.getText().toString();
                FragmentTwo fragment2 = new FragmentTwo();
                Bundle bundle = new Bundle();
                bundle.putString("text", txt);
                fragment2.setArguments(bundle);
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment2, fragment2)
                        .addToBackStack(null)
                        .commit();
                editText.setText("");

            }
        });
        return v;
    }
}