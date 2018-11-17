package my.edu.taruc.lab_34pickers;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button buttonDate;
    TextView textAges;
    TextView textViewMin;
    EditText balance;
    Double temp=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonDate = findViewById(R.id.buttonDOB);
        textAges=findViewById(R.id.textAge);
        textViewMin=findViewById(R.id.textViewEligibleAmount);
        balance=findViewById(R.id.editTextAccountBalance);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);

        Double tempBalance=Double.parseDouble(balance.getText().toString());

        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);
        //Toast.makeText(this, "Date: " + dateMessage,
        //       Toast.LENGTH_SHORT).show();
        buttonDate.setText(dateMessage);

        int currentYear= Calendar.getInstance().get(Calendar.YEAR);
        int userAge=currentYear-year;
        String age_string=Integer.toString(userAge);
        String ageMessage=("Age: "+age_string);
        textAges.setText(ageMessage);

        if(userAge>=16&&userAge<=20&&tempBalance>=5000){
            temp=tempBalance*30/100;
        }else if(userAge>=21&&userAge<=25&&tempBalance>=5000){
            temp=tempBalance*30/100;
        }else if(userAge>=26&&userAge<=30){
            temp=tempBalance*30/100;
        }else if(userAge>=31&&userAge<=35){
            temp=tempBalance*30/100;
        }else if(userAge>=36&&userAge<=40){
            temp=tempBalance*30/100;
        }else if(userAge>=41&&userAge<=45){
            temp=tempBalance*30/100;
        }else if(userAge>=46&&userAge<=50){
            temp=tempBalance*30/100;
        }else if(userAge>=51&&userAge<=55){
            temp=tempBalance*30/100;
        }


    }
    public void Calculate(View view){
        textViewMin.setText(Double.toString(temp));
    }
}