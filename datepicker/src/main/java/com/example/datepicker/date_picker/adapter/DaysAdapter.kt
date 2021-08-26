package com.example.datepicker.date_picker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datepicker.R
import com.example.datepicker.date_picker.model.Day

class DaysAdapter(
    val context: Context,
    private val dates: ArrayList<Day>
) : RecyclerView.Adapter<DaysAdapter.DaysViewHolder>() {
    inner class DaysViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val day: AppCompatTextView = itemView.findViewById(R.id.days)

        fun bind(date: Day) {
            day.text = date.day.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaysViewHolder {
        return DaysViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.days_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DaysViewHolder, position: Int) {
        holder.bind(dates.get(position))
    }

    override fun getItemCount(): Int {
        return dates.size
    }
}