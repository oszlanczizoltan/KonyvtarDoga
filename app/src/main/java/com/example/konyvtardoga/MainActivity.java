package com.example.konyvtardoga;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText etTitle, etAuthor, etPages;
    private ListView lvBooks;
    private List<Book> books = new ArrayList<>();
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etAuthor = findViewById(R.id.etAuthor);
        etPages = findViewById(R.id.etPages);
        lvBooks = findViewById(R.id.lvBooks);
        Button btnAdd = findViewById(R.id.btnAdd);

        adapter = new BookAdapter(this, books);
        lvBooks.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> {
            String title = etTitle.getText().toString().trim();
            String author = etAuthor.getText().toString().trim();
            String pagesStr = etPages.getText().toString().trim();

            if (title.isEmpty() || author.isEmpty() || pagesStr.isEmpty()) {
                Toast.makeText(this, "Minden mezőt tölts ki!", Toast.LENGTH_SHORT).show();
                return;
            }

            int pages = Integer.parseInt(pagesStr);
            if (pages < 50) {
                Toast.makeText(this, "Az oldalszámnak legalább 50-nek kell lennie!", Toast.LENGTH_SHORT).show();
                return;
            }

            books.add(new Book(title, author, pages));
            adapter.notifyDataSetChanged();
            etTitle.setText("");
            etAuthor.setText("");
            etPages.setText("");
        });

    }
}
