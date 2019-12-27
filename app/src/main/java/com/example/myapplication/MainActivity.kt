package com.example.myapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtDOB.setOnClickListener() {
            val c: Calendar = Calendar.getInstance()
            val currentDay = c.get(Calendar.DAY_OF_MONTH)
            val currentMonth = c.get(Calendar.MONTH)
            val currentYear = c.get(Calendar.YEAR)

            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener
                { view, year, month, day ->
                    txtDOB.setText(day.toString() + "/" + (month + 1).toString() + "/" + year.toString())

                    //todo: calculate age and investment amount
                    val age = currentYear - year
                    txtAge.setText(age.toString())
                    val basic=getBasic()
                    txtBasic.setText("RM "+basic.toString())
                    val allow = basic *0.3
                    txtAllow.setText("RM" + allow.toString())

                }, currentYear, currentMonth, currentDay
            )
            dpd.show()
        }
    }
    fun getBasic():Int{
        return when(Integer.valueOf(txtAge.getText().toString())){

            in 16..20->5000;
            in 21..25->14000;
            in 26..30->29000;
            in 31..35->50000;
            in 36..40->78000;
            in 41..45->116000;
            in 46..50->165000;
            in 51..55->228000;

            else ->0
        }
    }
}
