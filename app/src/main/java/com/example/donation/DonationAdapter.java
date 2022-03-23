package com.example.donation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class DonationAdapter extends ArrayAdapter {

    private Context context;
    private List<Donation> donations;

    public DonationAdapter(@NonNull Context context, List<Donation> donationList) {
        super(context, R.layout.row_donate, donationList);
        this.context = context;
        this.donations = donationList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_donate, parent, false);
        Donation donation = donations.get(position);
        TextView amountView = (TextView) view.findViewById(R.id.row_amount);
        TextView methodView = (TextView) view.findViewById(R.id.row_method);
        amountView.setText("$" + donation.getAmount());
        methodView.setText(donation.getMethod());
        return view;
    }


}
