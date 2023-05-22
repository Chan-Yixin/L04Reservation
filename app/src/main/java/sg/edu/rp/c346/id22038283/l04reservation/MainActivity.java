package sg.edu.rp.c346.id22038283.l04reservation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextMobile;
    private EditText editTextGroupSize;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private RadioButton radioButtonSmoking;
    private RadioButton radioButtonNonSmoking;
    private Button buttonConfirm;
    private Button buttonReset;

    private int defaultYear = 2020;
    private int defaultMonth = 5; // 0-based index
    private int defaultDay = 1;
    private int defaultHour = 19;
    private int defaultMinute = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextMobile = findViewById(R.id.editTextMobile);
        editTextGroupSize = findViewById(R.id.editTextGroupSize);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        radioButtonSmoking = findViewById(R.id.radioButtonSmoking);
        radioButtonNonSmoking = findViewById(R.id.radioButtonNonSmoking);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        buttonReset = findViewById(R.id.buttonReset);

        datePicker.updateDate(defaultYear, defaultMonth, defaultDay);
        timePicker.setHour(defaultHour);
        timePicker.setMinute(defaultMinute);

        buttonConfirm.setOnClickListener(view -> {
            String name = editTextName.getText().toString();
            String mobile = editTextMobile.getText().toString();
            String groupSize = editTextGroupSize.getText().toString();
            String date = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();
            String time = timePicker.getHour() + ":" + String.format("%02d", timePicker.getMinute());
            String smokingArea = radioButtonSmoking.isChecked() ? "Smoking" : "Non-smoking";

            String confirmationMessage = "Name: " + name + "\n"
                    + "Mobile: " + mobile + "\n"
                    + "Group size: " + groupSize + "\n"
                    + "Date: " + date + "\n"
                    + "Time: " + time + "\n"
                    + "Area: " + smokingArea;

            Toast.makeText(this, "Your reservation is completed. Details: \n" + confirmationMessage, Toast.LENGTH_LONG).show();
        });

        buttonReset.setOnClickListener(view -> {
            editTextName.setText("");
            editTextMobile.setText("");
            editTextGroupSize.setText("");
            datePicker.updateDate(defaultYear, defaultMonth, defaultDay);
            timePicker.setHour(defaultHour);
            timePicker.setMinute(defaultMinute);
            radioButtonNonSmoking.setChecked(true);
        });
    }
}
