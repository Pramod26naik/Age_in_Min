package com.example.dobcalci

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDate : Button =findViewById(R.id.btnDate)
        btnDate.setOnClickListener(){
            date()
        }
    }
    fun date(){
        val myCalender=Calendar.getInstance()
        val year=myCalender.get(Calendar.YEAR)
        val month=myCalender.get(Calendar.MONTH)
        val day=myCalender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view,year,month,dayOfMonth->
//            Toast.makeText(this,"Works",Toast.LENGTH_SHORT).show()
            val txview1 : TextView =findViewById(R.id.txv1)
            val txview2 : TextView =findViewById(R.id.txv2)
            val txview3 : TextView =findViewById(R.id.txv3)
            val selectedDate="$dayOfMonth/${month+1}/$year"
            txview1.text=selectedDate

            val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate=sdf.parse(selectedDate).time / 60000

            val curDate=sdf.parse(sdf.format(System.currentTimeMillis())).time /60000
            val diff= curDate-theDate
            val ageInyr =diff/(60*24*365)
            txview2.text="$diff"
            txview3.text="$ageInyr"
        }
            ,year,month,day).show()

    }

}