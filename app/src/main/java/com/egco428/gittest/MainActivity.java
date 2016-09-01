package com.egco428.gittest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView logImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        logImage = (ImageView) findViewById(R.id.imageView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "hello world!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    private ImageView imageView;
    private boolean flag = true;
    public final static String EXTRA_MESSAGE = "com.egco428.MESSAGE";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.add(Menu.NONE, Menu.NONE, 104, "New Toast");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM); //if toolbar has enough wide
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(MainActivity.this, "new message here", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        return true;
    }

    public void sendMethod(MenuItem item){
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        final EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        finish();
    }

    boolean img = true;
    public void  changeImage(MenuItem item){

        if(img){

            logImage.setImageResource(R.drawable.androidlogo);
            img = false;

        }

        else{

            logImage.setImageResource(R.drawable.androidrobot);
            img = true;
        }


    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
