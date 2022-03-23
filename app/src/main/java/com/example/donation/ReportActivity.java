package com.example.donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.donation.databinding.ActivityReportBinding;

public class ReportActivity extends AppCompatActivity {

    ActivityReportBinding binding;

//    static final String[] numbers = new String[] {
//            "Amount, Pay method",
//            "10, Direct",
//            "100, PayPal",
//            "1000, Direct",
//            "10, PayPal",
//            "5000, PayPal"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        binding = ActivityReportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ListView listView = binding.reportList;
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numbers);
//        DonationAdapter adapter = new DonationAdapter(this, History.donations);
        DonationAdapter adapter = new DonationAdapter(this, History.dbManager.getAll());
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menuReport) {
            Toast toast = Toast.makeText(this, "Report click!", Toast.LENGTH_LONG);
            toast.show();
//            Intent intent = new Intent(this, ActivityReport.class);
//            startActivity(intent);
            return true;
        } else if (id == R.id.menuDonate) {
//            Toast toast = Toast.makeText(this, "Report click!", Toast.LENGTH_LONG);
//            toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}