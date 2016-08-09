package com.example.damon.nowiltolive;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.damon.nowiltolive.IntentIntegrator;
import com.example.damon.nowiltolive.IntentResult;

/**
 * Created by damon on 2016/08/02.
 */
public class MainScreen extends Fragment implements View.OnClickListener
{
    //Assign what the user sees to this variable, which XML for example
    View MyView;
    TextView Result,Result2;
    Button Scan;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        MyView = inflater.inflate(R.layout.home_screen,container,false);
        Scan=(Button)MyView.findViewById(R.id.btnScan);
        Result=(TextView)MyView.findViewById(R.id.txtResult);
        Result2=(TextView)MyView.findViewById(R.id.txtResult2);

        Scan.setOnClickListener(this);
        return MyView;
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId()==R.id.btnScan)
        {
            IntentIntegrator ScanIntegrator = new IntentIntegrator(getActivity());
            ScanIntegrator.initiateScan();
        }
    }
     public void onActivityResult(int RequestCode, int ResultCode, Intent Intent)
     {
         //Receive Scan Result
         IntentResult ScanningResult= IntentIntegrator.parseActivityResult(RequestCode,ResultCode,Intent);
         if (ScanningResult != null)
         {
             String ScanContent=ScanningResult.getContents();
             String ScanFormat=ScanningResult.getFormatName();

             Result.setText("FORMAT: " + ScanFormat);
             Result2.setText("CONTENT :" + ScanContent);
         }
         else
         {
             Toast Toasts = Toast.makeText(getActivity().getApplicationContext(),"No Scan Data Received... ",Toast.LENGTH_LONG);
             Toasts.show();
         }

     }
}
