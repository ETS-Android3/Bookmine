 package com.example.bookmine;

 import android.content.Intent;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.EditText;
 import android.widget.ImageButton;
 import android.widget.SearchView;
 import android.widget.TextView;
 import android.widget.Toast;

 import androidx.annotation.NonNull;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.recyclerview.widget.LinearLayoutManager;
 import androidx.recyclerview.widget.RecyclerView;

 import com.firebase.ui.database.FirebaseRecyclerAdapter;
 import com.google.firebase.database.DatabaseReference;
 import com.google.firebase.database.FirebaseDatabase;
 import com.google.firebase.database.Query;

 import java.util.Objects;

 public class MainActivity extends AppCompatActivity {

     public static final String EXTRA_NAME = "com.example.bookmine.extra.searchContent";
     private SearchView mSearchField;
     private ImageButton mSearchBtn;
     RecyclerView mResultList;
     DatabaseReference mUserDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        mUserDatabase = FirebaseDatabase.getInstance().getReference("Books");

        mSearchField=findViewById(R.id.search_field);
        mSearchBtn=findViewById(R.id.search_button);

        mResultList=findViewById(R.id.recycler_view);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(this));

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = mSearchField.getQuery().toString();
                firebaseUserSearch(searchText);

            }
        });


    }

     private void firebaseUserSearch(String searchText) {

         Toast.makeText(MainActivity.this,"Searching...",Toast.LENGTH_LONG).show();

         Query firebaseSearchQueary = mUserDatabase.orderByChild("author").startAt(searchText).endAt(searchText+"\uf8ff");

         FirebaseRecyclerAdapter<Books,UsersViewHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Books, UsersViewHolder>(
                 Books.class,
                 R.layout.singlerow,
                 UsersViewHolder.class,
                 firebaseSearchQueary
         ) {
             @Override
             protected void populateViewHolder(UsersViewHolder usersViewHolder, Books books, int i) {

                 usersViewHolder.setDetails(books.getAuthor());

             }
         };
         mResultList.setAdapter(firebaseRecyclerAdapter);
     }

     public static class UsersViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setDetails(String author)
        {
            TextView user_name = mView.findViewById(R.id.nametext);
            user_name.setText(author);
        }
    }

     public void onClick(View view)
     {

        Toast.makeText(MainActivity.this,"Searching...",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity2.class);
        mSearchField= findViewById(R.id.search_field);
        String searchContent = mSearchField.getQuery().toString();
        intent.putExtra(EXTRA_NAME,searchContent);
        startActivity(intent);

     }

}