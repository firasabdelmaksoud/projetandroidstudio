package tn.esprit.animaux.entities;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tn.esprit.animaux.R;


public class SigninActivity  extends AppCompatActivity {
    EditText usernamesi;
    EditText emailsi;
    EditText passwordsi;
    Button sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        usernamesi = findViewById(R.id.usernameSI);
        emailsi = findViewById(R.id.emailSI);
        passwordsi = findViewById(R.id.passwordSI);
        sign_in = findViewById(R.id.signInBtn);

        sign_in.setOnClickListener(view -> {
            String username = usernamesi.getText().toString();
            String email = emailsi.getText().toString();
            String password = passwordsi.getText().toString();

            /* insertion data base */
            if (1 == 2) {
                /*redrection*/
                Intent intent = new Intent(this, LoginActivity.class);
                /*pour passe de valeur a next activity*/
                intent.putExtra("username", username);
                startActivity(intent);
            } else {
                Toast.makeText(this, "sign in faild", Toast.LENGTH_SHORT).show();
            }


        });
    }
}
