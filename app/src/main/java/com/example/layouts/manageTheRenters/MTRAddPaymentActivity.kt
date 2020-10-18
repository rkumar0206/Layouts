package com.example.layouts.manageTheRenters

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.layouts.Functions.Companion.hide
import com.example.layouts.Functions.Companion.show
import com.example.layouts.R
import com.example.layouts.databinding.ActivityMTRAddPaymentBinding
import kotlinx.coroutines.*

class MTRAddPaymentActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {

    private lateinit var binding: ActivityMTRAddPaymentBinding

    private var monthList: List<String>? = null
    private var currencyList: List<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMTRAddPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()

        monthList = ArrayList()          //List of months
        currencyList = ArrayList()       //List of currency Symbols

        //List of months
        monthList = resources.getStringArray(R.array.months).toList()

        //List of currency symbols of different places
        currencyList = resources.getStringArray(R.array.currency_symbol).toList()

        setUpCurrencySymbolList()
        setUpSpinnerMonth()
    }

    private fun initListeners() {

        binding.include.periodTypeRG.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(rg: RadioGroup?, selectedID: Int) {

        if (rg?.checkedRadioButtonId == binding.include.byMonthRB.id) {

            showByMonthSpinner()
        } else {

            showByDateCL()
        }
    }

    private fun showByMonthSpinner() {

        try {

            binding.include.monthSelectSpinner.show()
            binding.include.monthSelectSpinner.animate().alpha(1f).setDuration(350).start()
            binding.include.byDateCL.animate().alpha(0f).setDuration(350).start()

            GlobalScope.launch {
                delay(350)
                withContext(Dispatchers.Main) {

                    binding.include.byDateCL.hide()
                }
            }
        } catch (e: Exception) {

            e.printStackTrace()
        }
    }

    private fun showByDateCL() {

        try {

            binding.include.byDateCL.show()
            binding.include.byDateCL.animate().alpha(1f).setDuration(350).start()
            binding.include.monthSelectSpinner.animate().alpha(0f).setDuration(350).start()

            GlobalScope.launch {
                delay(350)
                withContext(Dispatchers.Main) {

                    binding.include.monthSelectSpinner.hide()
                }
            }
        } catch (e: Exception) {

            e.printStackTrace()
        }
    }


    private fun setUpCurrencySymbolList() {

        binding.include.moneySymbolSpinner.let { spinner ->

            if (currencyList != null) {
                spinner.adapter = ArrayAdapter(
                    this,
                    R.layout.support_simple_spinner_dropdown_item,
                    currencyList!!
                )

                spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                    override fun onNothingSelected(parent: AdapterView<*>?) {

                        spinner.setSelection(0)
                        //currencySymbol = currencyList!![0]
                    }

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {

                        spinner.setSelection(position)
                        /*currencySymbol = currencyList!![position]
                        showToast(requireContext(), "${currencyList!![position]} is selected..")*/
                    }
                }
            }
        }

    }

    private fun setUpSpinnerMonth() {

        binding.include.monthSelectSpinner.let { spinner ->

            if (monthList != null) {
                spinner.adapter = ArrayAdapter(
                    this,
                    R.layout.support_simple_spinner_dropdown_item,
                    monthList!!
                )

                spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                    override fun onNothingSelected(parent: AdapterView<*>?) {

                        spinner.setSelection(0)

                    }

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {

                        spinner.setSelection(position)
                        /*billMonth = monthList!![position]
                        showLogI("${monthList!![position]} is selected..")*/
                    }
                }
            }
        }

    }

}