package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText idText, birthText, emailText, passwordText;
    private Button register_fin_button;

    public static RegisterActivity newInstance() {
        return new RegisterActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_fin_button = (Button)this.findViewById(R.id.register_fin_button);

        idText = (EditText) this.findViewById(R.id.idText);
        birthText = (EditText) this.findViewById(R.id.birthText);
        emailText = (EditText) this.findViewById(R.id.emailText);
        passwordText = (EditText) this.findViewById(R.id.passwordText);

        register_fin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(idText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (birthText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "나이를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (emailText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "메일 주소를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (passwordText.getText().toString().length() < 8) {
                    Toast.makeText(getApplicationContext(), "비밀번호는 8자리 이상으로 해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

}
