package com.example.signin_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    EditText unameEdit,passwordEdit;
    Button signInBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        unameEdit = findViewById(R.id.unameEdit);
        passwordEdit = findViewById(R.id.passwordEdit);
        signInBtn = findViewById(R.id.signInBtn);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                String usernameSU = bundle.getString("usernameSU");
                String passwordSU = bundle.getString("passwordSU");

                String usernameSI = unameEdit.getText().toString();
                String passwordSI = passwordEdit.getText().toString();

                if(usernameSI.equals(usernameSU) && passwordSI.equals(passwordSU)){
                    Toast.makeText(SignInActivity.this,"SignIn Successfull",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SignInActivity.this,"Wrong Username or Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}