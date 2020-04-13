package ro.pub.cs.systems.eim.Colocviu1_13;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {
    private TextView pressedButtonsText;
    private int buttonCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("COUNTER")) {
                buttonCounter = savedInstanceState.getInt("COUNTER");
            }
            else {
                buttonCounter = 0;
            }
        }

        pressedButtonsText = (TextView) findViewById(R.id.pressedButtonsText);
        Button northButton = (Button)findViewById(R.id.northButton);
        Button westButton = (Button)findViewById(R.id.westButton);
        Button eastButton = (Button)findViewById(R.id.eastButton);
        Button southButton = (Button)findViewById(R.id.southButton);
        Button navigateToButton = (Button)findViewById(R.id.navigateToActivityButton);

        pressedButtonsText.setText("");
        ButtonClickListener buttonClickListener = new ButtonClickListener(pressedButtonsText, buttonCounter, this);
        northButton.setOnClickListener(buttonClickListener);
        westButton.setOnClickListener(buttonClickListener);
        eastButton.setOnClickListener(buttonClickListener);
        southButton.setOnClickListener(buttonClickListener);
        navigateToButton.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNTER", buttonCounter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("COUNTER")) {
            buttonCounter = savedInstanceState.getInt("COUNTER");
        }
        else
            buttonCounter = 0;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {
            Toast.makeText(this, resultCode == 1 ? "REGISTER" : "CANCEL", Toast.LENGTH_LONG).show();
        }
    }
}


class ButtonClickListener implements View.OnClickListener {

    private TextView pressedText;
    private int counter;
    private Activity activity;

    ButtonClickListener(TextView pressedText, int counter, Activity activity) {
        this.pressedText = pressedText;
        this.counter = counter;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.northButton:
                pressedText.setText(pressedText.getText() + " North");
                counter++;
                break;

            case R.id.westButton:
                pressedText.setText(pressedText.getText() + " West");
                counter++;
                break;

            case R.id.eastButton:
                pressedText.setText(pressedText.getText() + " East");
                counter++;
                break;

            case R.id.southButton:
                pressedText.setText(pressedText.getText() + " South");
                counter++;
                break;

            case R.id.navigateToActivityButton:
                Intent intent = new Intent(activity, Colocviu1_13SecondaryActivity.class);
                intent.putExtra("INSTRUCTIONS", pressedText.getText());
                activity.startActivityForResult(intent, 123);
                pressedText.setText("");
                counter = 0;
                break;
        }
    }
}