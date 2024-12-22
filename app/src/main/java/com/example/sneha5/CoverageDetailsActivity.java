package com.example.sneha5;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class CoverageDetailsActivity extends AppCompatActivity {

    private TextView titleText;
    private TextInputEditText premiseStockInput;
    private TextInputEditText transitStockInput;
    private TextInputEditText promoCodeInput;
    private MaterialButton submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coverage_details);

        // Get insurance type from intent
        String insuranceType = getIntent().getStringExtra("insurance_type");

        initializeViews();
        setupTitle(insuranceType);
        setupSubmitButton();
    }

    private void initializeViews() {
        titleText = findViewById(R.id.titleText);
        premiseStockInput = findViewById(R.id.premiseStockInput);
        transitStockInput = findViewById(R.id.transitStockInput);
        promoCodeInput = findViewById(R.id.promoCodeInput);
        submitButton = findViewById(R.id.submitButton);
    }

    private void setupTitle(String insuranceType) {
        if (insuranceType != null) {
            titleText.setText(insuranceType.toUpperCase());
        }
    }

    private void setupSubmitButton() {
        submitButton.setOnClickListener(v -> {
            // Validate inputs
            if (validateInputs()) {
                // Process the form submission
                submitForm();
            }
        });
    }

    private boolean validateInputs() {
        boolean isValid = true;
        
        if (premiseStockInput.getText().toString().trim().isEmpty()) {
            premiseStockInput.setError("Required");
            isValid = false;
        }
        
        if (transitStockInput.getText().toString().trim().isEmpty()) {
            transitStockInput.setError("Required");
            isValid = false;
        }
        
        return isValid;
    }

    private void submitForm() {
        // TODO: Implement form submission logic
    }
} 