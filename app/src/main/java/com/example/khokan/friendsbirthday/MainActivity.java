package com.example.khokan.friendsbirthday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView name,bdate;
    private Button save,show;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        bdate=findViewById(R.id.bdate);

        save=findViewById(R.id.save);
        show=findViewById(R.id.show);
        final MyDBFunctions mf=new MyDBFunctions(getApplicationContext());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fname= name.getText().toString();
                String fbdate=bdate.getText().toString();
                DataTemp dt=new DataTemp(fname,fbdate);
                mf.addingDataToTable(dt);
                Toast.makeText(MainActivity.this, "Data Added successfully..", Toast.LENGTH_SHORT).show();
                name.setText(" ");
                bdate.setText(" ");
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),BirthdayOfFriends.class));
            }
        });
    }
}
