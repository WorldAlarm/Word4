package com.example.rambler.word4;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactsActivity extends  AppCompatActivity {

    private EditText nameEt,mobileEt,qqET,danweiET,addressEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        nameEt = (EditText) findViewById(R.id.name);
        mobileEt = (EditText) findViewById(R.id.mobile);
        qqET = (EditText) findViewById(R.id.qq);
        danweiET = (EditText) findViewById(R.id.danwei);
        addressEt = (EditText) findViewById(R.id.address);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,1,"保存");
        menu.add(0,2,3,"返回");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case 1:
                if(!nameEt.getText().toString().equals("")){
                    User user = new User();
                    user.setName(nameEt.getText().toString());
                    user.setMobile(mobileEt.getText().toString());
                    user.setDanwei(danweiET.getText().toString());
                    user.setQq(qqET.getText().toString());
                    user.setAddress(addressEt.getText().toString());
                    ContactsTable ct = new ContactsTable(this);
                    finish();
                    if(ct.addData(user)){
                        Toast.makeText(this,"添加成功!",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(this,"添加失败!",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(this, "请先输入姓名!", Toast.LENGTH_LONG).show();
                }
                break;
            case 2:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
