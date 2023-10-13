package com.example.hw1_3;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etTheme, etMessage;

    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        onClick();
        navigateNext();
    }

    private void findId() {
        etEmail = findViewById(R.id.et_email);
        etTheme = findViewById(R.id.et_theme);
        etMessage = findViewById(R.id.et_message);
        btnNext = findViewById(R.id.btn_next);
    }

    private void onClick() {
        btnNext.setOnClickListener(view -> {
            navigateNext();
        });
    }

    private void navigateNext() {
        String email = etEmail.getText().toString();
        String theme = etTheme.getText().toString();
        String message = etMessage.getText().toString();

        Intent emIntent = new Intent(Intent.ACTION_SEND);
        emIntent.setType("plain/text");
        emIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        emIntent.putExtra(Intent.EXTRA_SUBJECT, theme);
        emIntent.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(Intent.createChooser(emIntent, "Message..."));
    }
}