package com.example.nguyenhuutai.androidasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.title);

        try {
            WebServiceAsyncTask webServiceAsynchTask  = new WebServiceAsyncTask();
            webServiceAsynchTask.execute("https://jsonplaceholder.typicode.com/todos/1");
            textView.setText(webServiceAsynchTask.get().getTitle());
        }
        catch (Exception e){
            Log.e("ERROR",e.toString());
        }
    }
}
