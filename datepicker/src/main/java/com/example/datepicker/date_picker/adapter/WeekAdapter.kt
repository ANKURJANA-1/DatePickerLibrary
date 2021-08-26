package com.example.datepicker.date_picker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datepicker.R
import com.example.datepicker.date_picker.model.Day

class WeekAdapter(
    private val context: Context,
    private val days: ArrayList<Day>
) : RecyclerView.Adapter<WeekAdapter.WeekViewHolder>() {

    inner class WeekViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var days: AppCompatTextView = itemView.findViewById(R.id.days)

        fun bind(day: Day) {
            days.text = day.day.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
        return WeekViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.week_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WeekViewHolder, position: Int) {
        holder.bind(days.get(position))
    }

    override fun getItemCount(): Int {
        return 7
    }
}