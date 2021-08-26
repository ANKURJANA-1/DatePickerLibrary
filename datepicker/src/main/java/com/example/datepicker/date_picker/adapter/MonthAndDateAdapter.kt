package com.example.datepicker.date_picker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datepicker.R

class MonthAndDateAdapter(
    context: Context
) : RecyclerView.Adapter<MonthAndDateAdapter.MonthAndDateViewHolder>() {
    private var listOfMonth: ArrayList<String> = ArrayList()

    init {
        listOfMonth.add("January")
        listOfMonth.add("February")
        listOfMonth.add("March")
        listOfMonth.add("April")
        listOfMonth.add("May")
        listOfMonth.add("June")
        listOfMonth.add("July")
        listOfMonth.add("August")
        listOfMonth.add("September")
        listOfMonth.add("October")
        listOfMonth.add("November")
        listOfMonth.add("December")
    }


    inner class MonthAndDateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val month: AppCompatTextView = itemView.findViewById(R.id.month)

        fun bind(months: String) {
            month.text = months.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthAndDateViewHolder {
        return MonthAndDateViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.month_and_day_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MonthAndDateViewHolder, position: Int) {
        holder.bind(listOfMonth.get(position))
    }

    override fun getItemCount(): Int {
        return 12
    }
}