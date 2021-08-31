package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText EmailEditText,PasswordEditText;
    Button LoginButton;
    int Counter = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EmailEditText = findViewById(R.id.EmailEditText1);
        PasswordEditText = findViewById(R.id.PasswordEditText1);
        LoginButton = findViewById(R.id.LoginButton);

        String registeredEmail = getIntent().getStringExtra("Email");
        String registeredPassword = getIntent().getStringExtra("Password");

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = EmailEditText.getText().toString();
                String Password = PasswordEditText.getText().toString();

                if(registeredEmail.equals(Email) && registeredPassword.equals(Password)){
                    Intent intent = new Intent(LoginActivity.this, LoginSuccessActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Invalid Credentials",Toast.LENGTH_LONG).show();
                }
                Counter--;
                if(Counter == 0){
                    Toast.makeText(getBaseContext(),"Login Failed Attempts",Toast.LENGTH_LONG).show();
                    LoginButton.setEnabled(false);

                }
            }
        });

    }
}