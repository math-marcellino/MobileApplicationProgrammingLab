package id.ac.umn.matthewmarcellino_00000036291_if570_el_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {

    EditText etLogin;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        etLogin = findViewById(R.id.et_login);
        btnNext = findViewById(R.id.nextButton);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLibraryPage();
            }
        });
    }

    private void openLibraryPage() {
        if(etLogin.getText().toString().length() == 0){
            etLogin.setError("Harap mengisi nama anda!");
        } else{
            Intent libraryIntent = new Intent(this, LibraryActivity.class);
            String namaUser = etLogin.getText().toString();
            libraryIntent.putExtra("NamaUser", namaUser);
            startActivity(libraryIntent);
        }
    }
}