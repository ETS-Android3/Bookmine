package com.example.bookmine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BOOKMINE3 extends AppCompatActivity {
    TextView secondPageSearchContent3;
    String title,coverlink,author,category,noofpages,year,amazonredirecturl,authorlink,fivestarrating,fourstarrating,booklinks,onestarrating,ratingcount,reviewrating,worldcatredirectlink;
    public static final String EXTRA_TEXT_LAST = "com.example.bookmine.extra.last";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_o_o_k_m_i_n_e3);
        getSupportActionBar().hide();

        //My code


        Intent intent1 = getIntent();
        title = intent1.getStringExtra(MainActivity2.EXTRA_TEXT1);
        coverlink = intent1.getStringExtra(MainActivity2.EXTRA_TEXT2);
        author = intent1.getStringExtra(MainActivity2.EXTRA_TEXT3);
        category = intent1.getStringExtra(MainActivity2.EXTRA_TEXT4);
        noofpages = intent1.getStringExtra(MainActivity2.EXTRA_TEXT5);
        year = intent1.getStringExtra(MainActivity2.EXTRA_TEXT6);
        amazonredirecturl = intent1.getStringExtra(MainActivity2.EXTRA_TEXT7);
        authorlink= intent1.getStringExtra(MainActivity2.EXTRA_TEXT8);
        fivestarrating = intent1.getStringExtra(MainActivity2.EXTRA_TEXT9);
        fourstarrating = intent1.getStringExtra(MainActivity2.EXTRA_TEXT10);
        booklinks = intent1.getStringExtra(MainActivity2.EXTRA_TEXT11);
        onestarrating = intent1.getStringExtra(MainActivity2.EXTRA_TEXT12);
        ratingcount = intent1.getStringExtra(MainActivity2.EXTRA_TEXT13);
        reviewrating = intent1.getStringExtra(MainActivity2.EXTRA_TEXT14);
        worldcatredirectlink = intent1.getStringExtra(MainActivity2.EXTRA_TEXT15);

        setDetailspage3(title,coverlink,author,category,noofpages,year,amazonredirecturl,authorlink,fivestarrating,fourstarrating,booklinks,onestarrating,ratingcount,reviewrating,worldcatredirectlink);


    }

    public void setDetailspage3( String bookname, String coverlink, String authorname, String category, String noofpages, String year, String amazon_redirect_url, String author_link, String five_star_rating, String four_star_rating, String booklinks, String onr_star_rating, String rating_count, String review_count, String worldcat_redirect_link)
    {

        TextView book_name = findViewById(R.id.booknametext1);
        TextView author_name = findViewById(R.id.authornametext1);
        TextView Category_name = findViewById(R.id.categorytext1);
        TextView year_published = findViewById(R.id.yeartext1);
        ImageView image = findViewById(R.id.imageView);

        book_name.setText(bookname);
        author_name.setText(authorname);
        Category_name.setText(category);
        year_published.setText(year);
        Glide.with(getApplicationContext()).load(coverlink).into(image);

    }

}