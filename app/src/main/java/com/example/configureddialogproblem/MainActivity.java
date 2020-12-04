package com.example.configureddialogproblem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    AlertDialog.Builder adb;
    final String[] colors={"Red","Green","Blue"};
    int[] color={0,0,0};
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout=(LinearLayout)findViewById(R.id.layout);
    }

    /**
     * This method runs when the first button is pressed
     * it shows an AlertDialog with the option to change the screen colro to one out of 3.
     * @param view
     */

    public void button1Pressed(View view)
    {
        color=new int[]{0,0,0};
        adb=new AlertDialog.Builder(this);

        adb.setTitle("Alrt Dialog");
        adb.setItems(colors, new DialogInterface.OnClickListener()
        {
           @Override
           public void onClick(DialogInterface dialog, int which)
           {
               color[which]=255;
               layout.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
           }
        });

        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });

        AlertDialog ad=adb.create();
        ad.show();
    }

    /**
     * This method runs when the second button is pressed
     * It shows an AlertDialog with the option to change the screen colro to one out of 3 color or any combination of them.
     * @param view
     */

    public void button2Pressed(View view)
    {
        adb=new AlertDialog.Builder(this);

        color=new int[]{0,0,0};
        adb.setTitle("Alrt Dialog");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked)
            {
                if (isChecked)
                {
                    color[which]=255;
                }
                else
                {
                    color[which]=0;
                }
            }
        });

        adb.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                layout.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });

        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });

        AlertDialog ad=adb.create();
        ad.show();
    }

    /**
     * This method runs when the third button is pressed
     * It changes the screen color to white
     * @param view
     */

    public void button3Pressed(View view)
    {
        layout.setBackgroundColor(Color.WHITE);
    }

    /**
     * This method runs when the forth button is pressed
     * It gets text from the user and shows a toast with this text.
     * @param view
     */
    
    public void button4Pressed(View view)
    {
        adb=new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Alert Dialog");
        final EditText eT=new EditText(this);
        eT.setHint("Type tetx here");
        adb.setView(eT);

        adb.setPositiveButton("Copy", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                String s=eT.getText().toString();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });

        AlertDialog ad=adb.create();
        ad.show();
    }

    /**
     * @param menu  the menu of this activity
     * @return      shows a menu with one option - credits
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add("Credits");

        return true;
    }

    /**
     * @param item   The item that was selected
     * @return       Goes to credits activity. Since there's only one item, there's no need to check which one was pressed.
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent si=new Intent(this, creditsActivity.class);
        startActivity(si);

        return true;
    }
}
