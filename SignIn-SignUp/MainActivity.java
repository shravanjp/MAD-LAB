package com.example.signin_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText unameEdit,passwordEdit;
    Button signUpBtn;
    String regex = "^(?=.*[0-9])"
                  +"(?=.*[a-z])(?=.*[A-Z])"
                  +"(?=.*[$%#@^+=])"
                  +"(?=\\S+$).{8,20}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unameEdit = findViewById(R.id.unameEdit);
        passwordEdit = findViewById(R.id.passwordEdit);
        signUpBtn = findViewById(R.id.signUpBtn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = unameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(validatePassword(password)){
                    Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("usernameSU",username);
                    bundle.putString("passwordSU",password);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Password is not Strong Enough",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    public boolean validatePassword(String password){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}