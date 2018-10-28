package hu.bme.aut.workplaceapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ViewPager vpProfile = (ViewPager) findViewById(R.id.vpProfile);
        vpProfile.setAdapter(new ProfilePagerAdapter(getSupportFragmentManager()));
    }
}
