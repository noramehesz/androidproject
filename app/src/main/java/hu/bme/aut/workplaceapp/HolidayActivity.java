package hu.bme.aut.workplaceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import hu.bme.aut.workplaceapp.data.DataManager;

public class HolidayActivity extends AppCompatActivity implements DatePickerDialogFragment.OnDateSelectedListener {

    private PieChart chartHoliday;
    private Button btnTakeHoliday;

    private DataManager dataManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);

        dataManager = DataManager.getInstance();

        chartHoliday = (PieChart) findViewById(R.id.chartHoliday);

        btnTakeHoliday = (Button) findViewById(R.id.btnTakeHoliday);
        btnTakeHoliday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialogFragment().show(getSupportFragmentManager(), "DATE_TAG");
            }
        });

        loadHolidays();
    }

    private void loadHolidays() {
        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(dataManager.getHolidays(), "Taken"));
        entries.add(new PieEntry(dataManager.getRemainingHolidays(), "Remaining"));

        PieDataSet dataSet = new PieDataSet(entries, "Holidays");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData(dataSet);
        chartHoliday.setData(data);
        chartHoliday.invalidate();
    }

    @Override
    public void onDateSelected(int year, int month, int day) {
        int numHolidays = dataManager.getHolidays();
        Calendar choosenDay = Calendar.getInstance();
        choosenDay.set(Calendar.DAY_OF_MONTH, day);
        choosenDay.set(Calendar.MONTH, month);
        choosenDay.set(Calendar.YEAR, year);
        Calendar today = Calendar.getInstance();

        long dif = choosenDay.getTimeInMillis() - today.getTimeInMillis();

    if ( dif > 0 ) {
        if (dataManager.getRemainingHolidays() > 0) {
            dataManager.setHolidays(numHolidays + 1);
        }

        if (dataManager.getRemainingHolidays() == 0) {
            btnTakeHoliday.setEnabled(false);
        }
    }

        // Update chart
        loadHolidays();
    }
}
