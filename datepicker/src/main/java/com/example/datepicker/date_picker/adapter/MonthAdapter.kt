package com.example.datepicker.date_picker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.datepicker.R
import com.example.datepicker.date_picker.model.Day
import com.example.datepicker.date_picker.model.Months

class MonthAdapter(
    val context: Context,
    val daysList: ArrayList<Day>
) : RecyclerView.Adapter<MonthAdapter.MonthViewHolder>() {


    inner class MonthViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val day: RecyclerView = itemView.findViewById(R.id.weekOfTheDay)
        private val date: RecyclerView = itemView.findViewById(R.id.monthOfTheDay)

        fun bind() {

            val days: ArrayList<Day> = ArrayList()
            days.add(Day("S"))
            days.add(Day("M"))
            days.add(Day("T"))
            days.add(Day("W"))
            days.add(Day("T"))
            days.add(Day("F"))
            days.add(Day("S"))

            val weekAdapter: WeekAdapter = WeekAdapter(context, days)
            day.adapter = weekAdapter
            day.layoutManager = GridLayoutManager(context, 7)

            val daysAdapter: DaysAdapter = DaysAdapter(context,daysList)
            date.adapter=daysAdapter
            date.layoutManager=GridLayoutManager(context,7)
            date.hasFixedSize()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        return MonthViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.month_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 10
    }
}