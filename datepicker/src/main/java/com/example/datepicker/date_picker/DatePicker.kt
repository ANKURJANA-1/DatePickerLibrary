package com.example.datepicker.date_picker

import android.app.Dialog
import android.content.Context
import android.graphics.ColorSpace.match
import android.opengl.Visibility
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.datepicker.R
import com.example.datepicker.databinding.DatePickerLayoutBinding
import com.example.datepicker.date_picker.adapter.MonthAdapter
import com.example.datepicker.date_picker.adapter.MonthAndDateAdapter
import com.example.datepicker.date_picker.adapter.YearAdapter
import com.example.datepicker.date_picker.model.Day
import com.example.datepicker.date_picker.model.YearData
import java.util.*
import kotlin.collections.ArrayList

class DatePicker(
    private val context: Context,
    private val yearList: ArrayList<YearData>
) {
    private var binding = DatePickerLayoutBinding.inflate(
        LayoutInflater.from(context),
        null,
        false
    )
    private val calendar: Calendar = Calendar.getInstance()
    private val dialog = Dialog(context)
    private lateinit var yearAdapter: YearAdapter
    private lateinit var monthAdapter: MonthAdapter
    private lateinit var monthsAdapter: MonthAndDateAdapter

    init {
        dialog.apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(binding.root)
            window
                ?.setLayout(
                    CoordinatorLayout.LayoutParams.MATCH_PARENT,
                    CoordinatorLayout.LayoutParams.WRAP_CONTENT
                )
            window?.setBackgroundDrawableResource(android.R.color.transparent)
            setCancelable(true)
            setOnCancelListener {

            }
            binding.cancelButton.setOnClickListener(View.OnClickListener {
                dialog.dismiss()
            })
            binding.okButton.setOnClickListener(View.OnClickListener {
                dialog.dismiss()
            })
        }.show()

        binding.currentDate.text =
            ((calendar.get(Calendar.DATE)).toString() + "/" + (calendar.get(Calendar.MONTH) + 1).toString() + "/" + calendar.get(
                Calendar.YEAR
            ).toString())
        showYear(yearList)
        showDates()
        showMonths()

    }

    private fun showYear(yearList: ArrayList<YearData>) {
        binding.year.setOnClickListener(View.OnClickListener {
            binding.two.visibility = View.GONE
            yearAdapter = YearAdapter(
                context, {
                    binding.year.text = it
                }, yearList
            )
            binding.monthGrid.layoutManager = LinearLayoutManager(context)
            binding.monthGrid.adapter = yearAdapter
            binding.monthGrid.hasFixedSize()
            binding.monthGrid.smoothScrollBy(0, 100)
        })
    }

    private fun showDates() {

        val dayCount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        Log.d("day", dayCount.toString())

        calendar.set(Calendar.DATE, 1)
        val getDay: Int = calendar.get(Calendar.DAY_OF_WEEK)
        Log.d("day", getDay.toString())
        Log.d("day", calendar.get(Calendar.MONTH).toString())


        val dates: ArrayList<Day> = ArrayList()
        when (getDay) {
            2 -> {
                dates.add(Day(""))
            }
            3 -> {
                dates.add(Day(""))
                dates.add(Day(""))
            }
            4 -> {
                dates.add(Day(""))
                dates.add(Day(""))
                dates.add(Day(""))
            }
            5 -> {
                dates.add(Day(""))
                dates.add(Day(""))
                dates.add(Day(""))
                dates.add(Day(""))
            }
            6 -> {
                dates.add(Day(""))
                dates.add(Day(""))
                dates.add(Day(""))
                dates.add(Day(""))
                dates.add(Day(""))
            }
        }
        for (i in 1..dayCount) {
            dates.add(Day(i.toString()))
        }

        monthAdapter = MonthAdapter(
            context,
            dates
        )
        binding.monthGrid.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.monthGrid.adapter = monthAdapter
        PagerSnapHelper().attachToRecyclerView(binding.monthGrid)
        binding.monthGrid.hasFixedSize()

        binding.nextMonth.setOnClickListener(View.OnClickListener {
            val month = calendar.get(Calendar.MONTH)
            calendar.add(Calendar.MONTH, 1)

            val dayCount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            Log.d("day", dayCount.toString())

            calendar.set(Calendar.DATE, 1)
            val getDay: Int = calendar.get(Calendar.DAY_OF_WEEK)
            Log.d("day", getDay.toString())
            Log.d("day", calendar.get(Calendar.MONTH).toString())
            dates.clear()

//            val dates: ArrayList<Day> = ArrayList()
            when (getDay) {
                2 -> {
                    dates.add(Day(""))
                }
                3 -> {
                    dates.add(Day(""))
                    dates.add(Day(""))
                }
                4 -> {
                    dates.add(Day(""))
                    dates.add(Day(""))
                    dates.add(Day(""))
                }
                5 -> {
                    dates.add(Day(""))
                    dates.add(Day(""))
                    dates.add(Day(""))
                    dates.add(Day(""))
                }
                6 -> {
                    dates.add(Day(""))
                    dates.add(Day(""))
                    dates.add(Day(""))
                    dates.add(Day(""))
                    dates.add(Day(""))
                }
            }
            for (i in 1..dayCount) {
                dates.add(Day(i.toString()))
            }
            monthAdapter.notifyDataSetChanged()
            binding.currentDate.text =
                ((calendar.get(Calendar.MONTH) + 1).toString() + "/" + calendar.get(Calendar.YEAR)
                    .toString())
            monthAdapter.notifyDataSetChanged()
        })

        binding.previousMonth.setOnClickListener(View.OnClickListener {
            val month = calendar.get(Calendar.MONTH)
            calendar.add(Calendar.MONTH, -1)

            val dayCount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            Log.d("day", dayCount.toString())

            calendar.set(Calendar.DATE, 1)
            val getDay: Int = calendar.get(Calendar.DAY_OF_WEEK)
            Log.d("day", getDay.toString())
            Log.d("day", calendar.get(Calendar.MONTH).toString())
            dates.clear()

//            val dates: ArrayList<Day> = ArrayList()
            when (getDay) {
                2 -> {
                    dates.add(Day(""))
                }
                3 -> {
                    dates.add(Day(""))
                    dates.add(Day(""))
                }
                4 -> {
                    dates.add(Day(""))
                    dates.add(Day(""))
                    dates.add(Day(""))
                }
                5 -> {
                    dates.add(Day(""))
                    dates.add(Day(""))
                    dates.add(Day(""))
                    dates.add(Day(""))
                }
                6 -> {
                    dates.add(Day(""))
                    dates.add(Day(""))
                    dates.add(Day(""))
                    dates.add(Day(""))
                    dates.add(Day(""))
                }
            }
            for (i in 1..dayCount) {
                dates.add(Day(i.toString()))
            }
            binding.currentDate.text =
                ((calendar.get(Calendar.MONTH) + 1).toString() + "/" + calendar.get(Calendar.YEAR)
                    .toString())
            monthAdapter.notifyDataSetChanged()
        })

    }

    private fun showMonths() {
        binding.currentDate.setOnClickListener(View.OnClickListener {
            binding.two.visibility = View.GONE
            monthsAdapter = MonthAndDateAdapter(
                context
            )
            binding.monthGrid.layoutManager =
                LinearLayoutManager(context)
            binding.monthGrid.adapter = monthsAdapter
            binding.monthGrid.hasFixedSize()
        })
    }


}