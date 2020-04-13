package ro.pub.cs.systems.eim.Colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Colocviu1_13SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_13_secondary);

        TextView textView = (TextView)findViewById(R.id.secondaryText);
        Button registerButton = (Button)findViewById(R.id.registerButton);
        Button cancelButton = (Button)findViewById(R.id.cancelButton);
        Intent intent = getIntent();

        if (intent != null && intent.getExtras().containsKey("INSTRUCTIONS")) {
            textView.setText(intent.getStringExtra("INSTRUCTIONS"));
        }

        MyButtonClickListener buttonClickListener = new MyButtonClickListener(this);
        registerButton.setOnClickListener(buttonClickListener);
        cancelButton.setOnClickListener(buttonClickListener);
    }
}

class MyButtonClickListener implements View.OnClickListener {
    private Activity activity;

    MyButtonClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.registerButton:
                activity.setResult(1, null);
                break;
            case R.id.cancelButton:
                activity.setResult(2, null);
                break;
        }
        activity.finish();
    }
}
