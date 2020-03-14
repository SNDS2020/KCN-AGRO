package com.args.kcnagro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class home_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);



    }



    @Override// to display menu items
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }




    @Override//when menu items are clicked
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.account:
                Intent acc = new Intent(home_activity.this,Account_activity.class);
                startActivity(acc);
                return true;


            case R.id.about://when about is clicked
                Intent about = new Intent(home_activity.this,About_activity.class);
                startActivity(about);
                return true;

            default: return super.onOptionsItemSelected(item);


        }

    }
}
