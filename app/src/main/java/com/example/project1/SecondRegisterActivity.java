package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondRegisterActivity extends AppCompatActivity {

    EditText idText, emailText, passwordText, majorText;
    Button second_register_fin_button;

    public static SecondRegisterActivity newInstance() {
        return new SecondRegisterActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_register);

        idText = (EditText) this.findViewById(R.id.idText);
        emailText = (EditText) this.findViewById(R.id.emailText);
        passwordText = (EditText) this.findViewById(R.id.passwordText);
        majorText = (EditText) this.findViewById(R.id. majorText);

        second_register_fin_button = (Button) this.findViewById(R.id.second_register_fin_button);
        second_register_fin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(idText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (emailText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "메일 주소를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (passwordText.getText().toString().length() < 8) {
                    Toast.makeText(getApplicationContext(), "비밀번호는 8자리 이상으로 해주세요.", Toast.LENGTH_SHORT).show();
                } else if (majorText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "전공/직업을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"서비스 준비중입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}





