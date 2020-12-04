package com.example.configureddialogproblem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class creditsActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    /**
     * This method runs when the button is pressed
     * It goes abck to main activity
     * @param view
     */

    public void back(View view)
    {
        finish();
    }
}
