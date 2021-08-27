package com.example.datepicker.date_picker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datepicker.R
import com.example.datepicker.date_picker.model.AllMonths
import com.example.datepicker.date_picker.model.Day

class DaysAdapter(
    val context: Context,
    val dayAndMonthSelector: ((year: Int, month: Int, day: String) -> Unit)? = null,
    private val dates: ArrayList<Day>
) : RecyclerView.Adapter<DaysAdapter.DaysViewHolder>() {
    inner class DaysViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val date_: AppCompatTextView = itemView.findViewById(R.id.days)

        fun bind(date: Day) {
            date_.text = date.day

            date_.setOnClickListener(View.OnClickListener {

                date.month?.let { it1 ->
                    date.year?.let { it2 ->
                        dayAndMonthSelector?.let {
                            it(
                                it2,
                                it1,
                                date.day
                            )
                        }

                    }
                }
                Toast.makeText(
                    context,
                    date.day + "/" + date.month?.plus(1).toString() + "/" + date.year.toString(),
                    Toast.LENGTH_LONG
                )
                    .show()
            })
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