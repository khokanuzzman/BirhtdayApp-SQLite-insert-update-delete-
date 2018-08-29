package com.example.khokan.friendsbirthday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BirthdayOfFriends extends AppCompatActivity {
    private TextView nameView;
    private ListView lv;
    String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_of_friends);

        nameView =findViewById(R.id.friend_name);
        lv=findViewById(R.id.friend_list_view);

        MyDBFunctions mf = new MyDBFunctions(getApplicationContext());

        data = mf.my_data();

        lv.setAdapter(new ArrayAdapter(getApplicationContext(), R.layout.data_list, R.id.friend_name, data));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), SingleBd.class);
                i.putExtra("MyKEY", position);
                startActivity(i);
            }
        });
    }
}
