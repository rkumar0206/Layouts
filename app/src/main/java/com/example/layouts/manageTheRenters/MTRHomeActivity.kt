package com.example.layouts.manageTheRenters

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.layouts.Functions.Companion.closeKeyboard
import com.example.layouts.Functions.Companion.hide
import com.example.layouts.Functions.Companion.show
import com.example.layouts.R
import kotlinx.android.synthetic.main.manage_the_renters_home_layout.*
import kotlinx.coroutines.*

class MTRHomeActivity : AppCompatActivity(), View.OnClickListener {

    private var isSearchViewVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.manage_the_renters_home_layout)

        initListeners()
    }

    private fun initListeners() {

        searchRenterBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v?.id) {

            searchRenterBtn.id -> {

                if(!isSearchViewVisible) {

                    showSearchView()
                }else {

                    hideSearchView()
                }
            }
        }
    }

    private fun showSearchView() {

        isSearchViewVisible = !isSearchViewVisible

        renterSV.show()
        renterSV.animate().translationY(0f).alpha(1f).setDuration(350).start()

        searchET.requestFocus()
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        inputMethodManager.showSoftInput(searchET, InputMethodManager.SHOW_IMPLICIT)
    }

    private fun hideSearchView() {

        isSearchViewVisible = !isSearchViewVisible

        renterSV.animate().translationY(-50f).alpha(0f).setDuration(350).start()

        GlobalScope.launch {

            delay(360)

            closeKeyboard(this@MTRHomeActivity)
            withContext(Dispatchers.Main) {

                renterSV.hide()
                searchET.setText("")
            }
        }
    }
}