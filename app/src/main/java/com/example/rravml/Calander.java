package com.example.rravml;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast; import android.graphics.Color;
import android.graphics.drawable.Drawable;
public class Calander extends AppCompatActivity {
private Button clander;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calander);
        clander = (Button)findViewById(R.id.clander);
        clander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCa();
            }
        });
        CalendarView simpleCalendarView;
        simpleCalendarView = (CalendarView) findViewById(R.id.simpleCalendarView); // get the r

        simpleCalendarView.setFocusedMonthDateColor(Color.RED); // set the red color for the da

        simpleCalendarView.setUnfocusedMonthDateColor(Color.BLUE); // set the yellow color for

        simpleCalendarView.setSelectedWeekBackgroundColor(Color.RED); // red color for the sele

        simpleCalendarView.setWeekSeparatorLineColor(Color.GREEN); // green color for the week

        // perform setOnDateChangeListener event on CalendarView
        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {


            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(), dayOfMonth + "/" + month + "/" + year,
                        Toast.LENGTH_LONG).show();
            } });
            }
            public void openCa(){
                Intent intent=new Intent(Calander.this,MainActivity.class);
                startActivity(intent);
            }
        }
