package com.technohack.viewmode_livedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView numberValue;
    private Button incrementBtn,resetBtn;

    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberValue=findViewById(R.id.main_text_resultId);
        incrementBtn=findViewById(R.id.main_buttonId);
        resetBtn=findViewById(R.id.main_reset_buttonId);

        //to increment the number
        incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValue();
            }
        });

        //to reset the value
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetValue();
            }
        });

        //using viewModel and LiveData
        viewModel=ViewModelProviders.of(this).get(MyViewModel.class);
        viewModel.getResultValue().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {

                //We are setting only once inside the UI thread that's why we can restrict THE RECREATION OF UI
                numberValue.setText(String.valueOf(integer));

            }
        });


    }

    //to reset the result of the value
    private void resetValue() {
        viewModel.addScore();
    }

    //to add or increment the number
    private void addValue() {
        viewModel.resetValue();
    }

}
