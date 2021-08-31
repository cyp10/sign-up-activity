package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText EmailEditText,PasswordEditText;
    Button SignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmailEditText = findViewById(R.id.EmailEditText);
        PasswordEditText = findViewById(R.id.PasswordEditText);
        SignUpButton = findViewById(R.id.SignUpButton);

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = EmailEditText.getText().toString();
                String Password = PasswordEditText.getText().toString();

                if(!isValidPassword(Password)){
                    Toast.makeText(MainActivity.this, "Password Does't match the rules",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("Email", Email);
                intent.putExtra("Password",Password);
                startActivity(intent);


            }
        });

    }
    Pattern lowercase = Pattern.compile("^.*[a-z].*$");
    Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
    Pattern numbers = Pattern.compile("^.*[0-9].*$");
    Pattern specialCharacters = Pattern.compile("^.*[a-zA-Z0-9].*$");


    private Boolean isValidPassword(String password){
        if(password.length()<8){
            return false;
        }
        if(!lowercase.matcher(password).matches()) {
            return false;
        }
        if(!uppercase.matcher(password).matches()){
            return false;
        }
        if(!numbers.matcher(password).matches()){
            return false;
        }
        if(!specialCharacters.matcher(password).matches()){
            return false;
        }
        return true;
    }
}