package com.example.konyvtardoga;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;

    public class BookAdapter extends ArrayAdapter<Book> {
        private Context context;
        private List<Book> books;

        public BookAdapter(Context context, List<Book> books) {
            super(context, 0, books);
            this.context = context;
            this.books = books;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.activity_details, parent, false);
            }

            Book book = books.get(position);

            TextView tvTitle = convertView.findViewById(R.id.tvTitle);
            TextView tvAuthor = convertView.findViewById(R.id.tvAuthor);
            TextView tvPages = convertView.findViewById(R.id.tvPages);
            Button btnDelete = convertView.findViewById(R.id.btnDelete);

            tvTitle.setText(book.getTitle());
            tvAuthor.setText(book.getAuthor());
            tvPages.setText("Oldalak: " + book.getPages());


            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("title", book.getTitle());
            intent.putExtra("author", book.getAuthor());
            intent.putExtra("pages", book.getPages());
            context.startActivity(intent);
            btnDelete.setOnClickListener(v -> {
                    new AlertDialog.Builder(context).setMessage("biztosan törölni szeretnéd?").setPositiveButton("igen", null).show();
                            books.remove(position);
                });
                return convertView;
            }

        }




