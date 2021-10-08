package id.ac.umn.matthewmarcellino_00000036291_if570_el_uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailSFXActivity extends AppCompatActivity {
    private TextView detail_title;
    private TextView detail_kategori;
    private Toolbar detail_toolbar;
    private Button btn_play;
    private MediaPlayer med_player;
    private int URI;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sfx);

        detail_toolbar = findViewById(R.id.detail_toolbar);
        detail_toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.arrow_back));
        detail_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(med_player != null){
                    med_player.stop();
                }
                finish();
            }
        });

        detail_title = (TextView) findViewById(R.id.detail_title);
        detail_kategori = (TextView) findViewById(R.id.detail_kategori);
        btn_play = (Button) findViewById(R.id.btn_play);

        Intent intentLibrary = getIntent();
        Bundle bundle = intentLibrary.getExtras();

        SumberSFX src_sfx = (SumberSFX) bundle.getSerializable("DetailSFXActivity");

        detail_title.setText(src_sfx.getTitle());
        detail_kategori.setText(src_sfx.getKategori());
        detail_toolbar.setTitle(src_sfx.getTitle());

        URI = Integer.parseInt(src_sfx.getSFX_URI());
    }

    public void playSFX(View view){
        if(med_player == null){
            med_player = MediaPlayer.create(this, URI);
        }
        med_player.start();
    }
}