package id.ac.umn.matthewmarcellino_00000036291_if570_el_uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {
    Toolbar profile_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profile_toolbar = (Toolbar) findViewById(R.id.profile_toolbar);
        profile_toolbar.setTitle("Profile");
        profile_toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.arrow_back));
        profile_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}