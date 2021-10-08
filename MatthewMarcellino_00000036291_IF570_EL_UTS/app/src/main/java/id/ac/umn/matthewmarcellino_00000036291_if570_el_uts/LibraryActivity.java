package id.ac.umn.matthewmarcellino_00000036291_if570_el_uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class LibraryActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView rvListSFX;
    DaftarSFXAdapter mAdapter;
    LinkedList<SumberSFX> daftarSFX = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        rvListSFX = (RecyclerView) findViewById(R.id.listSFX);
        mAdapter = new DaftarSFXAdapter(this, daftarSFX);
        rvListSFX.setAdapter(mAdapter);
        rvListSFX.setLayoutManager(new LinearLayoutManager(this));

        isiDaftarSFX();

        toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu);

        //Menampilkan nama yang diinput user sebelumnya pada toolbar
        Intent intentLogin = getIntent();
        String inputNama = intentLogin.getStringExtra("NamaUser");
        toolbar.setTitle(inputNama);

        //Menampilkan toast
        Toast.makeText(this, "Selamat Datang, " + inputNama, Toast.LENGTH_SHORT).show();

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.homeMenu){
                    Intent home = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(home);
                } else if(item.getItemId() == R.id.profileMenu){
                    Intent profile = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(profile);
                }
                return false;
            }
        });
    }

    public void isiDaftarSFX(){
        daftarSFX.add(new SumberSFX("Aggresive Boar",
                "Animal",
                Integer.toString(R.raw.aggresive_boar)));
        daftarSFX.add(new SumberSFX("Dog Barking",
                "Animal",
                Integer.toString(R.raw.dog_barking)));
        daftarSFX.add(new SumberSFX("Evil Laugh",
                "Cartoon",
                Integer.toString(R.raw.evil_laugh)));
        daftarSFX.add(new SumberSFX("Fall Descend",
                "Cartoon",
                Integer.toString(R.raw.fall_descend)));
        daftarSFX.add(new SumberSFX("Little Bird",
                "Animal",
                Integer.toString(R.raw.little_birds)));
        daftarSFX.add(new SumberSFX("Trumpet Sad",
                "Cartoon",
                Integer.toString(R.raw.trumpet_sad)));
    }
}