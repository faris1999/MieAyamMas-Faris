package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

import static android.R.string.no;
import static android.os.Build.VERSION_CODES.N;


public class MainActivity extends AppCompatActivity {
    TextView rtx;
    private Button button;
    public void opensecondActity(){
        Intent intent = new Intent(this, secondActivity.class);
        startActivity(intent);}
    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensecondActity();
            }
        });
        rtx = (TextView) findViewById(R.id.rtx);
        rtx.setSelected(true);
    }


    public void increment(View view){
        if(quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity-1 ;
        display (quantity);
    }
    public void decrement(View view){
        if (quantity==10){
            Toast.makeText(this,"pesanan maximal 10",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity +1;
        display(quantity);
    }
    public void Submitorder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.edt_name);
        String name=nameEditText.getText().toString();
        Log.v("MainActivity","Nama:"+name);

        CheckBox mieAyamChekBox= (CheckBox) findViewById(R.id.Mie_Ayam);
        boolean hasmieAyam=mieAyamChekBox.isChecked();
        Log.v("MainActivity","has Mie Ayam:"+hasmieAyam);

        CheckBox miePangsitChekBox= (CheckBox) findViewById(R.id.Mie_Pangsit);
        boolean hasmiePangsit=miePangsitChekBox.isChecked();
        Log.v("MainActivity","has whippedcream:"+hasmiePangsit);

        int price=calculateprice(hasmieAyam,hasmiePangsit);
        String pricemessage=createOrderSummary(price,name,hasmieAyam,hasmiePangsit);


        displayMessage(pricemessage);

    }
    private int calculateprice(boolean addmieAyam,boolean addmiePangsit){//jumlah pesanan * harga
        int harga=0;

        if(addmieAyam){
            harga=harga+10000;
        }

        if (addmiePangsit){
            harga=harga+7000;
        }

        return quantity * harga;
    }
    private String createOrderSummary(int price, String name, boolean addmiePangsit, boolean addmieAyam) {
        String pricemessage=" Atas Nama ="+name;
        pricemessage+="\n Total Rp"+price;
        pricemessage+="\n Apakah Yakin dengan Pilihan Anda?";
        pricemessage+="\n Klik Tombol 'Kirim Pesanan' untuk konfirmasi pesanan Anda";
        return  pricemessage;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
