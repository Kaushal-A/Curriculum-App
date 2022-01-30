package com.adgvit.courseApp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adgvit.courseApp.Models.SettingsItems;
import com.adgvit.courseApp.R;
import com.adgvit.courseApp.rvAdapters.Settings_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Settings extends AppCompatActivity {
    RecyclerView recy2,recy3;
    TextView userName, college;
    List<SettingsItems> lst1,lst2,lst3;
    ImageView back;
    CardView signedIn,notSignedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        back = findViewById(R.id.settings_back);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        recy1 = findViewById(R.id.rcy1);
        recy2 = findViewById(R.id.rcy2);
        recy3 = findViewById(R.id.rcy3);
        lst1 = new ArrayList<>();
        lst2 = new ArrayList<>();
        lst3 = new ArrayList<>();
//        recy1.setNestedScrollingEnabled(false);
        recy2.setNestedScrollingEnabled(false);
        recy3.setNestedScrollingEnabled(false);





//        recy1.setLayoutManager(new LinearLayoutManager(this));
        recy2.setLayoutManager(new LinearLayoutManager(this));
        recy3.setLayoutManager(new LinearLayoutManager(this));

//        recy1.setAdapter(new Settings_Adapter(this,lst1));

        lst2.add(new SettingsItems(R.drawable.ic_contact_us,"Contact Us"));
        lst2.add(new SettingsItems(R.drawable.ic_share,"Share with Peers"));
        lst2.add(new SettingsItems(R.drawable.ic_ig,"Our Instagram"));
        lst2.add(new SettingsItems(R.drawable.ic_twit,"Our Twitter"));
        lst2.add(new SettingsItems(R.drawable.ic_fb,"Our Facebook"));
        lst2.add(new SettingsItems(R.drawable.ic_linkedin_settings,"Our LinkedIn"));

        recy2.setAdapter(new Settings_Adapter(this,lst2));


        lst3.add(new SettingsItems(R.drawable.ic_about_us,"About Us"));
        lst3.add(new SettingsItems(R.drawable.ic_privacy,"Privacy Policy"));
        recy3.setAdapter(new Settings_Adapter(this,lst3));



    }

    @Override
    public void onBackPressed() {

                finish();


    }
}