package com.example.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.layouts.Functions.Companion.hide
import com.example.layouts.Functions.Companion.show
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
    }

    private fun hideSearchView() {

        isSearchViewVisible = !isSearchViewVisible

        renterSV.animate().translationY(-50f).alpha(0f).setDuration(350).start()

        GlobalScope.launch {

            delay(360)

            withContext(Dispatchers.Main){

                renterSV.hide()
            }
        }
    }
}