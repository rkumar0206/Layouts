package com.example.layouts

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.layouts.manageTheRenters.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {

        mtrHomeBtn.setOnClickListener(this)
        mtrAddPayment.setOnClickListener(this)
        mtrAddRenter.setOnClickListener(this)
        mtrProfile.setOnClickListener(this)
        mtrShowBill.setOnClickListener(this)
        mtrRenter.setOnClickListener(this)
        testActivityBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        when (p0?.id) {

            mtrHomeBtn.id -> {

                val intent = Intent(this@MainActivity, MTRHomeActivity::class.java)
                startActivity(intent)
            }

            mtrAddPayment.id -> {

                val intent = Intent(this@MainActivity, MTRAddPaymentActivity::class.java)
                startActivity(intent)
            }

            mtrAddRenter.id -> {

                val intent = Intent(this@MainActivity, MTRAddRenterActivity::class.java)
                startActivity(intent)
            }

            mtrProfile.id -> {

                val intent = Intent(this@MainActivity, MTRProfileActivity::class.java)
                startActivity(intent)
            }

            mtrRenter.id -> {

                val intent = Intent(this@MainActivity, MTR_RenterActivity::class.java)
                startActivity(intent)
            }

            mtrShowBill.id -> {

                val intent = Intent(this@MainActivity, MTRShowBillActivity::class.java)
                startActivity(intent)
            }

            testActivityBtn.id -> {

                val intent = Intent(this@MainActivity, TestActivity::class.java)
                startActivity(intent)
            }
        }
    }

}