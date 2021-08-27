package com.example.datepicker.date_picker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.datepicker.R
import com.example.datepicker.date_picker.model.AllMonths
import com.example.datepicker.date_picker.model.Day
import com.example.datepicker.date_picker.model.Months

class MonthAdapter(
    val context: Context,
    private val monthsList: ArrayList<AllMonths>,
    val dayAndMonthSelector: (dateIndex: Int) -> Unit
) : RecyclerView.Adapter<MonthAdapter.MonthViewHolder>() {

    inner class MonthViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val day: RecyclerView = itemView.findViewById(R.id.weekOfTheDay)
        private val date: RecyclerView = itemView.findViewById(R.id.monthOfTheDay)

        fun bind(month: AllMonths) {
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


            val list: ArrayList<Day> = ArrayList()
            when (month.startingDayOfWeek) {
                2 -> {
                    list.add(Day(""))
                }
                3 -> {
                    list.add(Day(""))
                    list.add(Day(""))
                }
                4 -> {
                    list.add(Day(""))
                    list.add(Day(""))
                    list.add(Day(""))
                }
                5 -> {
                    list.add(Day(""))
                    list.add(Day(""))
                    list.add(Day(""))
                    list.add(Day(""))
                }
                6 -> {
                    list.add(Day(""))
                    list.add(Day(""))
                    list.add(Day(""))
                    list.add(Day(""))
                    list.add(Day(""))
                }
            }
            dayAndMonthSelector(month.startingDayOfWeek)
            for (i in 1..month.dayCountOfMonth) {
                list.add(Day(i.toString(), month.year, month.months))
            }

            val daysAdapter: DaysAdapter = DaysAdapter(context, dates = list)
            date.adapter = daysAdapter
            date.layoutManager = GridLayoutManager(context, 7)
            date.hasFixedSize()


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        return MonthViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.month_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        holder.bind(monthsList.get(position))
    }

    override fun getItemCount(): Int {
        return monthsList.size
    }
}