package com.example.donation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.donation.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @SuppressLint("SetTextI18n")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.amountPickerId.setMaxValue(1000);
        binding.amountPickerId.setMinValue(0);
        binding.progressBarId.setMax(History.maxTarget);
        binding.progressBarId.setProgress(History.totalAmount);
        binding.textViewTotal.setText("Total so Far  $" + History.totalAmount);

        binding.donateButton.setOnClickListener(view1 -> {
            int amount = binding.amountPickerId.getValue();
            int radioId = binding.paymentGroup.getCheckedRadioButtonId();
            String method = "";

            if (radioId == R.id.paypalRadio) {
                method = "Paypal";
            } else {
                method = "Direct";
            }

            History.totalAmount += amount;
            Donation donation = new Donation(amount, method);
//            History.donations.add(donation);
            History.dbManager.add(donation);
            binding.progressBarId.setProgress(History.totalAmount);
            binding.textViewTotal.setText("Total so Far  $" + History.totalAmount);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public static void reset() {
        History.totalAmount = 0;
        History.dbManager.reset();
//        binding.textViewTotal.setText("Total so Far  $" + History.totalAmount);
//        binding.progressBarId.setProgress(History.totalAmount);
    }

}