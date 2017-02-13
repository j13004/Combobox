package com.example.onoda.spinner_sotsuken;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    String str;
    Spinner spinner;
    EditText edit;
    AlertDialog.Builder Alert1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Alert1 = new AlertDialog.Builder(this);
        DisplayMetrics metrics = getResources().getDisplayMetrics();

        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        String[] data = getResources().getStringArray(R.array.item_label); //string.xmlに記載したスピナーの項目要素のXMLを読み込む
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,data); //スピナーの項目要素のXMLをArrayAdapter<String>クラスに設定
        spinner1.setAdapter(adapter);//ArrayAdapter<String>クラスのインスタンを生成
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//spinnerのレイアウト変更
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView parent, View view, final int position, long id) {

                spinner = (Spinner) parent;
                str = spinner.getSelectedItem().toString();
                edit = (EditText)findViewById(R.id.edit);
                edit.setText(str);

                Button btn01 = (Button)findViewById(R.id.btn1); //送信ボタンの作成、ID選択
                btn01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { //クリックされた時の処理
                        String str = edit.getText().toString(); //edittextに入力されている文字をtext1に入れる
                            Alert1.setTitle("結果");
                            Alert1.setPositiveButton("OK", null);
                            Alert1.setMessage(str); //Alert1にtext1の値を入れる
                            AlertDialog dialog = Alert1.show(); //アラートの表示
                             TextView messageView = (TextView)dialog.findViewById(message);
                            messageView.setGravity(Gravity.CENTER);
                        }
                    });
                }
                public void onNothingSelected(AdapterView parent) {
                  }
             });
        }
}