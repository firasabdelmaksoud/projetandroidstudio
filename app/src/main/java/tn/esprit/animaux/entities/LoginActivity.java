package tn.esprit.animaux.entities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import tn.esprit.animaux.R;

public class LoginActivity extends AppCompatActivity {
    EditText usernamel;
    EditText passwordl;
    Button Login;
    Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernamel = findViewById(R.id.usernamel);
        passwordl = findViewById(R.id.passwordl);
        Login = findViewById(R.id.Login);
        signin = findViewById(R.id.signin);
        Login.setOnClickListener(view -> {
            String username = usernamel.getText().toString();
            String password = passwordl.getText().toString();
            /* insertion data base */
            if ((username.equals("user")) && (password.equals("user"))) {
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
            }
        });
        signin.setOnClickListener(view -> {


            Intent intent = new Intent(this, SigninActivity.class);
            startActivity(intent);

        });
    }
}
