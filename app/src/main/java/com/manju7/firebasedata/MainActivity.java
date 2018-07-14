package com.manju7.firebasedata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    EditText firstText,lastText,mesgText;
    Button add1;

    Firebase mRootref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootref = new Firebase(" enter your database url ");

        firstText=(EditText) findViewById(R.id.firstName);
        lastText=(EditText) findViewById(R.id.lastName);
        mesgText=(EditText) findViewById(R.id.message1);

        add1=(Button) findViewById(R.id.add1);


        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String first= firstText.getText().toString();
                String last= lastText.getText().toString();
                String msg= mesgText.getText().toString();

                String key = first+" "+last;

                Firebase childRef = mRootref.child(key);

                childRef.setValue(msg);

                firstText.setText("");
                lastText.setText("");
                mesgText.setText("");

                Toast.makeText(MainActivity.this,"Your message successfully sent to Manju",Toast.LENGTH_LONG).show();

            }
        });


    }

}
