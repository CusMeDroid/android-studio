package com.myandroid.app.sqliteoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    CusmeText Name, Pass , updateold, updatenew, delete;
    CusmeDbAdapter helper;
    CusmeLayout layout1, layout2, layout3;
    CusmeView img_dev;
    CusmeButton viewdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText) findViewById(R.id.editName);
        Pass = (EditText) findViewById(R.id.editPass);
        updateold = (EditText) findViewById(R.id.editText3);
        updatenew = (EditText) findViewById(R.id.editText5);
        delete = (EditText) findViewById(R.id.editText6);
        helper = new myDbAdapter(this);
        layout1 = (LinearLayout) findViewById(R.id.form_main);
        layout2 = (LinearLayout) findViewById(R.id.edit_user);
        layout3 = (LinearLayout) findViewById(R.id.bground);
        img_dev = (ImageView) findViewById(R.id.ImageDevlop);
        viewdata = (ImageButton) findViewById(R.id.button2);
    }

    public void addUser(View view) {
        String t1 = Name.getText().toString();
        String t2 = Pass.getText().toString();
        if(t1.isEmpty() || t2.isEmpty()) {
            Message.message(getApplicationContext(),"Masukkan Nama Dan Password");
        }
        else {
            long id = helper.insertData(t1,t2);
            if(id<=0) {
                Message.message(getApplicationContext(),"Gagal Memasukan Data User");
                Name.setText("");
                Pass.setText("");
            } else {
                Message.message(getApplicationContext(),"Sukses Memasukan Data User");
                Name.setText("");
                Pass.setText("");
                layout1.setVisibility(view.GONE);
                layout2.setVisibility(view.VISIBLE);
                layout3.setVisibility(view.GONE);
                img_dev.setVisibility(view.GONE);
            }
        }
    }

    public void viewdata(View view) {
        String data = helper.getData();
        Message.message(this,data);
    }

    public void update( View view) {
        String u1 = updateold.getText().toString();
        String u2 = updatenew.getText().toString();
        if(u1.isEmpty() || u2.isEmpty()) {
            Message.message(getApplicationContext(),"Masukkan Nama User");
        }
        else {
            int a= helper.updateName( u1, u2);
            if(a<=0)
            {
                Message.message(getApplicationContext(),"Gagal!");
                updateold.setText("");
                updatenew.setText("");
            } else {
                Message.message(getApplicationContext(),"Berhasil Mengubah Nama!");
                updateold.setText("");
                updatenew.setText("");
            }
        }

    }

    public void delete( View view) {
        String uname = delete.getText().toString();
        if(uname.isEmpty()) {
            Message.message(getApplicationContext(),"Masukkan Nama User");
        }
        else {
            int a= helper.delete(uname);
            if(a<=0) {
                Message.message(getApplicationContext(),"Gagal!");
                delete.setText("");
            }
            else {
                Message.message(this, "Berhasil Menghapus User!");
                delete.setText("");
            }
        }
    }

    public void balikaje( View view) {
        layout1.setVisibility(view.VISIBLE);
        layout2.setVisibility(view.GONE);
        layout3.setVisibility(view.VISIBLE);
        img_dev.setVisibility(view.VISIBLE);
    }
}