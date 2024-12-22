package com.example.sneha5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner countrySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        initializeViews();
        setupCountrySpinner();
        setupInsuranceTypeCards();

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initializeViews() {
        countrySpinner = findViewById(R.id.countrySpinner);
    }

    private void setupCountrySpinner() {
        String[] countries = new String[]{"Malaysia"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this, 
            android.R.layout.simple_spinner_dropdown_item,
            countries
        );
        countrySpinner.setAdapter(adapter);
    }

    private void setupInsuranceTypeCards() {
        int[] cardIds = {
            R.id.jewelryGoldCard,
            R.id.diamondStonesCard,
            R.id.moneyServicesCard,
            R.id.luxuryWatchesCard,
            R.id.pawnbrokersCard
        };

        String[] insuranceTypes = {
            getString(R.string.jewelry_gold),
            getString(R.string.diamond_stones),
            getString(R.string.money_services),
            getString(R.string.luxury_watches),
            getString(R.string.pawnbrokers)
        };

        for (int i = 0; i < cardIds.length; i++) {
            final int index = i;
            CardView card = findViewById(cardIds[i]);
            card.setOnClickListener(v -> showInsuranceDetails(insuranceTypes[index]));
        }
    }

    private void showInsuranceDetails(String insuranceType) {
        Intent intent = new Intent(this, CoverageDetailsActivity.class);
        intent.putExtra("insurance_type", insuranceType);
        startActivity(intent);
    }
}