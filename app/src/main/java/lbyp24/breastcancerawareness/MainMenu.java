package lbyp24.breastcancerawareness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Button a= (Button) findViewById(R.id.button);
        Button b= (Button) findViewById(R.id.button2);
        Button c= (Button) findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position=1;
                Intent intent = new Intent(getBaseContext(), WhatToHappen.class);
                intent.putExtra("Position", position);
                startActivity(intent);
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), WhatToKnow.class);
                startActivity(intent);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position=2;
                Intent intent = new Intent(getBaseContext(), WhatToHappen.class);
                intent.putExtra("Position", position);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
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
        if (id == R.id.a_Home) {


            startActivity(new Intent(MainMenu.this,
                    MainMenu.class));


            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
