package com.example.konyvtardoga;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvAuthor = findViewById(R.id.tvAuthor);
        TextView tvPages = findViewById(R.id.tvPages);
        TextView tvYear = findViewById(R.id.tvYear);
        Button btnBack = findViewById(R.id.btnBack);
        Button btnDelete = findViewById(R.id.btnDelete);


        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author");
        int pages = intent.getIntExtra("pages", 0);

        Random random = new Random();
        int randomYear = random.nextInt(2023 - 1900 + 1) + 1900;

        tvTitle.setText("Cím: " + title);
        tvAuthor.setText("Szerző: " + author);
        tvPages.setText("Oldalak száma: " + pages);
        tvYear.setText("Megjelenési év: " + randomYear);



        btnBack.setOnClickListener(view -> {
            finish();
        });
    }
}