package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText idText, passwordText;
    Button login_button, register_return, second_register_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idText = (EditText) this.findViewById(R.id.idText);
        passwordText = (EditText) this.findViewById(R.id.passwordText);

        login_button = (Button) this.findViewById(R.id.login_button);
        register_return = (Button)this.findViewById(R.id.register_return);
        second_register_return = (Button)this.findViewById(R.id.second_register_return);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(idText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if(passwordText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if(passwordText.getText().toString().length() < 8) {
                    Toast.makeText(getApplicationContext(), "아이디 혹은 비밀번호가 맞지 않습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "환영합니다.", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        // mentee
        register_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        //mentor
        second_register_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SecondRegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
