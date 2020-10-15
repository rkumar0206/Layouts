package com.example.layouts

import android.view.View
import java.lang.Exception

class Functions {

    companion object {

        fun View.show() {

            try{

                this.visibility = View.VISIBLE
            }catch (e : Exception) {
                e.printStackTrace()
            }
        }

        fun View.hide() {

            try{

                this.visibility = View.GONE
            }catch (e : Exception) {
                e.printStackTrace()
            }
        }

    }
}