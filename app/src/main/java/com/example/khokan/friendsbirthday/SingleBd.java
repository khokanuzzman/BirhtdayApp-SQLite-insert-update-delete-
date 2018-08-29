package com.example.khokan.friendsbirthday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SingleBd extends AppCompatActivity {
    private EditText editBd;
    private Button update_btn,delete_bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_bd);

        editBd=findViewById(R.id.edit_data);
        update_btn=findViewById(R.id.update_bd);
        delete_bd=findViewById(R.id.delete_bd);


        final int rec_pos= getIntent().getIntExtra("MyKEY",999);
        final MyDBFunctions obj= new MyDBFunctions(getApplicationContext());
            String t=obj.fetch_bday(rec_pos+1);
            editBd.setText(t);
            editBd.setSelection(editBd.getText().length());



        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                obj.update_birthday((rec_pos+1), editBd.getText().toString());
                Toast.makeText(SingleBd.this, "Updated Successfully!"+rec_pos+1, Toast.LENGTH_SHORT).show();


            }
        });


        delete_bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj.delete_bd(obj.fetch_bday(rec_pos+1));
                Toast.makeText(getApplicationContext(), "Deleted Successfully!"+rec_pos+1, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
