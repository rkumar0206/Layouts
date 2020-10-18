package com.example.layouts

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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

            try {

                this.visibility = View.GONE
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        suspend fun closeKeyboard(activity: Activity) {
            try {
                withContext(Dispatchers.IO) {

                    val view = activity.currentFocus

                    if (view != null) {

                        val inputMethodManager =
                            activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

                        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
                    }

                }
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }

    }
}