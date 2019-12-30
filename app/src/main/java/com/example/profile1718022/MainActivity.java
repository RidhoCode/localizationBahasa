package com.example.profile1718022;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.profile1718022.Helper.LocaleHelper;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    TextView textview1;
    TextView textview2;
    TextView textview3;
    TextView textview4;
    Button button;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView)findViewById(R.id.textview);
        textview1 = (TextView)findViewById(R.id.textview1);
        textview2 = (TextView)findViewById(R.id.textview2);
        textview3 = (TextView)findViewById(R.id.textview3);
        textview4 = (TextView)findViewById(R.id.textview4);
        button = (Button)findViewById(R.id.button);


        Paper.init(this);

        String language = Paper.book().read("Language");
        if(language == null)
            Paper.book().write("language","en");

        updateView((String)Paper.book().read("language"));
    }

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this, lang);
        Resources resources = context.getResources();

        textview.setText(resources.getString(R.string.photo));
        textview1.setText(resources.getString(R.string.followers));
        textview2.setText(resources.getString(R.string.following));
        textview3.setText(resources.getString(R.string.sociallife));
        textview4.setText(resources.getString(R.string.send));
        button.setText(resources.getString(R.string.start));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.language_en){
            Paper.book().write("language","en");
            updateView((String)Paper.book().read("language"));
        }
        else if(item.getItemId() == R.id.language_in){
            Paper.book().write("language","in");
            updateView((String)Paper.book().read("language"));
        }
        return true;
    }
}
