package com.example.a0koraj06.fileio;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import android.view.MenuItem;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String dir_path = Environment.getExternalStorageDirectory().getAbsolutePath();
        EditText editText = (EditText)findViewById(R.id.editText);

        if (item.getItemId()== R.id.Save)
        {

            try
            {

                FileWriter fw = new FileWriter(dir_path + "/textedit.txt"); //true if i want to do one by one
                PrintWriter pw = new PrintWriter(fw);
                pw.println(editText.getText());
                pw.flush();
                pw.close();


            }
            catch(IOException e)
            {
                System.out.println ("I/O Error: " + e);
            }

        }
        else if (item.getItemId()== R.id.Load) {

            try
            {

                FileReader fr = new FileReader(dir_path + "/textedit.txt");
                BufferedReader br = new BufferedReader (fr);
                String line = "";
                while((line = br.readLine()) != null){

                   System.out.println(line);
                }


                br.close();


            }
            catch(IOException e)
            {
                System.out.println ("I/O Error: " + e);
            }


            return true;
        }


        return false;
    }
}
