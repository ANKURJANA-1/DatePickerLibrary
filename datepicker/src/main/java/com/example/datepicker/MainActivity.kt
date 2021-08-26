package com.example.datepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.datepicker.date_picker.DatePicker
import com.example.datepicker.date_picker.model.YearData

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.click)


        button.setOnClickListener(View.OnClickListener {
            val list:ArrayList<YearData> = ArrayList()

            list.add(YearData(2000))
            list.add(YearData(2001))
            list.add(YearData(2002))
            list.add(YearData(2003))
            list.add(YearData(2004))
            list.add(YearData(2005))
            list.add(YearData(2006))
            list.add(YearData(2007))
            list.add(YearData(2008))
            list.add(YearData(2009))
            list.add(YearData(2010))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))
            list.add(YearData(2000))

            DatePicker(this,list)
        })
    }
}