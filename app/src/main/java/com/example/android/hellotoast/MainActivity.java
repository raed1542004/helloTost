package com.example.android.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final String COUNT_KEY = "count";

    private int mCount = 0;
    private TextView mShowCount;
    private Button mButtonZero;
    private Button mButtonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = findViewById(R.id.show_count);
        mButtonZero = findViewById(R.id.button_zero);
        mButtonCount = findViewById(R.id.button_count);

        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt(COUNT_KEY, 0);
            mShowCount.setText(String.valueOf(mCount));
            updateButtonColors();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT_KEY, mCount);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void showCount(View view) {
        mCount++;
        mShowCount.setText(String.valueOf(mCount));
        updateButtonColors();
    }

    public void showZero(View view) {
        mCount = 0;
        mShowCount.setText(String.valueOf(mCount));
        updateButtonColors();
    }

    private void updateButtonColors() {
        if (mCount == 0) {
            mButtonZero.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.zero_inactive));
        } else {
            mButtonZero.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.zero_active));
        }

        if (mCount == 0) {
            mButtonCount.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.colorPrimary));
        } else if (mCount % 2 == 0) {
            mButtonCount.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.count_even));
        } else {
            mButtonCount.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.count_odd));
        }
    }
}
