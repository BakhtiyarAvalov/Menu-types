package java.market;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView androidPhone, iOsPhone;
    RadioButton bank_radio, cash_radio;
    CheckBox checkBox_present, checkBox_address;
    Button btn_next;

    String deliveryMethod, paymentType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidPhone = findViewById(R.id.androidPhone);
        iOsPhone = findViewById(R.id.iOsPhone);

        bank_radio = findViewById(R.id.bank_radio);
        cash_radio = findViewById(R.id.cash_radio);

        checkBox_present = findViewById(R.id.checkBox_present);
        checkBox_address = findViewById(R.id.checkBox_address);

        btn_next = findViewById(R.id.btn_next);

        registerForContextMenu(androidPhone);
        registerForContextMenu(iOsPhone);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bank_radio.isChecked()){
                    paymentType = "Оплата по карте";
                } else if (cash_radio.isChecked()) {
                    paymentType = "Оплата наличными";
                }
                if (checkBox_present.isChecked()){
                    deliveryMethod = "С подарком";
                } else if (checkBox_address.isChecked()) {
                    deliveryMethod = "Доставка по адресу";
                }

                String result = "Android:"+androidPhone.getText()+"\n"+
                                "iOs:"+iOsPhone.getText()+"\n"+
                                "Тип оплаты:"+paymentType+"\n"+
                                "Способ доставки:"+deliveryMethod;
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v == androidPhone){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.android_menu, menu);
        }
        if (v == iOsPhone){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.ios_menu, menu);
        }


        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.samsungPhone) {
            androidPhone.setText("Samsung");
        } else if (itemId == R.id.mi9Phone) {
            androidPhone.setText("Mi9");
        } else if (itemId == R.id.huaweiPhone) {
            androidPhone.setText("Xuawei");
        } else if (itemId == R.id.xiaomiPhone) {
            androidPhone.setText("xiami");
        } else if (itemId == R.id.iPhone9) {
            iOsPhone.setText("iPhone 9");
        } else if (itemId == R.id.iPhone10) {
            iOsPhone.setText("iPhone 10");
        } else if (itemId == R.id.iPhone13) {
            iOsPhone.setText("iPhone 13");
        } else if (itemId == R.id.iPhone14) {
            iOsPhone.setText("iPhone 14");
        } else if (itemId == R.id.iPhone15ProMax) {
            iOsPhone.setText("iPhone 15 Pro Max");
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.menu_setting) {
            Toast.makeText(this, "Вы нажали Setting menu", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.menu_exit) {
            Toast.makeText(this, "Вы нажали exit menu", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.menu_save) {
            Toast.makeText(this, "Вы нажали save menu", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.menu_cut) {
            Toast.makeText(this, "Вы нажали cut menu", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);

    }
}