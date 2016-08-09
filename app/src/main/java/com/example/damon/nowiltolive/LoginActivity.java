package com.example.damon.nowiltolive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by damon on 2016/08/08.
 */
public class LoginActivity extends AppCompatActivity
{
    //This class Deals with the log in/Reg part of the code, Once the user successfully logs in, the user is sent to main activity
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
    }
}
