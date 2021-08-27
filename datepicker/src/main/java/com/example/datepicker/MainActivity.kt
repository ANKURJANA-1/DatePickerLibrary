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
            DatePicker(this)
        })
    }
}