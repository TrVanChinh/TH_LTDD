package com.example.danhsachcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.params.CoreConnectionPNames;

import java.util.ArrayList;

public class DanhBa extends AppCompatActivity {
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 1001;
    ListView lvDanhBa;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> adapterDanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);
        addControls();
        showAllContactFromDevice();
    }
    private void showAllContactFromDevice(){
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri.,null,null,null,null);
        dsDanhBa.clear();
        while (cursor.moveToNext()){
            String tenCotName = ContactsContract.Contacts.DISPLAY_NAME;
            String tencotPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            int vitricotName = cursor.getColumnIndex(tenCotName);
            int vitricotPhone = cursor.getColumnIndex(tencotPhone);

            String name = cursor.getString(vitricotName) ;
            String phone = cursor.getString(vitricotPhone);
            Contact Contact = new Contact(name,phone);
            dsDanhBa.add(contact);
            adepterDanhBa.notifyDataSetChanged();





        }

    }
    private void addControls(){
        lvDanhBa = findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter<>(
                DanhBa.this, android.R.layout.simple_list_item_1,dsDanhBa
        );
        lvDanhBa.setAdapter(adapterDanhBa);
    }
}