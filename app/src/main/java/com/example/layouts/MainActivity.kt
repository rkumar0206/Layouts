package com.example.layouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {

        mtrHomeBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        when(p0?.id) {

            mtrHomeBtn.id -> {

                val intent = Intent(this@MainActivity, MTRHomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}