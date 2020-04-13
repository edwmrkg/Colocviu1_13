package ro.pub.cs.systems.eim.Colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {
    public TextView pressedButtonsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pressedButtonsText = (TextView) findViewById(R.id.pressedButtonsText);
        Button northButton = (Button)findViewById(R.id.northButton);
        Button westButton = (Button)findViewById(R.id.westButton);
        Button eastButton = (Button)findViewById(R.id.eastButton);
        Button southButton = (Button)findViewById(R.id.southButton);
        Button navigateToButton = (Button)findViewById(R.id.navigateToActivityButton);

        pressedButtonsText.setText("");
        ButtonClickListener buttonClickListener = new ButtonClickListener(pressedButtonsText);
        northButton.setOnClickListener(buttonClickListener);
        westButton.setOnClickListener(buttonClickListener);
        eastButton.setOnClickListener(buttonClickListener);
        southButton.setOnClickListener(buttonClickListener);
    }




}


class ButtonClickListener implements View.OnClickListener {

    private TextView pressedText;

    ButtonClickListener(TextView pressedText) {
        this.pressedText = pressedText;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.northButton:
                pressedText.setText(pressedText.getText() + " North");
                break;

            case R.id.westButton:
                pressedText.setText(pressedText.getText() + " West");
                break;

            case R.id.eastButton:
                pressedText.setText(pressedText.getText() + " East");
                break;

            case R.id.southButton:
                pressedText.setText(pressedText.getText() + " South");
                break;
        }
    }
}