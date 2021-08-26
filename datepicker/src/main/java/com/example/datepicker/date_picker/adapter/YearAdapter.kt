package com.example.datepicker.date_picker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datepicker.R
import com.example.datepicker.date_picker.adapter.YearAdapter.*
import com.example.datepicker.date_picker.model.YearData
import java.util.zip.Inflater

class YearAdapter(
    var context: Context,
    val yearSelector: (year:String) -> Unit,
    var listYear: ArrayList<YearData>
) : RecyclerView.Adapter<YearAdapter.MyYearViewHolder>() {

    inner class MyYearViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        private val year: AppCompatTextView = ItemView.findViewById(R.id.year_no)
        fun addView(data: YearData) {
            year.text = data.year.toString()

            year.setOnClickListener(View.OnClickListener {
               yearSelector(year.text.toString())
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyYearViewHolder {
        return MyYearViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.year_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyYearViewHolder, position: Int) {
        holder.addView(listYear.get(position))
    }

    override fun getItemCount(): Int {
        return listYear.size
    }
}