package hu.bme.aut.workplaceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton btnProfile = (ImageButton) findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(MenuActivity.this, ProfileActivity.class);
                startActivity(profileIntent);
            }
        });

        ImageButton btnHoliday = (ImageButton) findViewById(R.id.btnHoliday);
        btnHoliday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent holidayIntent = new Intent(MenuActivity.this, HolidayActivity.class);
                startActivity(holidayIntent);
            }
        });
    }


}
