package com.demo.coreservice.utils

import android.app.Service
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.demo.coreservice.R

fun View.showKeyboard() {
    (context?.getSystemService(Service.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.showSoftInput(this, 0)
}

fun View.hideKeyboard() {
    (context?.getSystemService(Service.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.hideSoftInputFromWindow(this.windowToken, 0)
}

fun View.toVisible() {
    this.visibility = View.VISIBLE
}

fun View.toGone() {
    this.visibility = View.GONE
}

fun View.toInvisible() {
    this.visibility = View.GONE
}



fun View.showToast(
        lifecycleOwner: LifecycleOwner,
        snackbarEvent: LiveData<Event<Any>>,
        timeLength: Int
) {
    snackbarEvent.observe(lifecycleOwner, Observer { event ->
        event.getContentIfNotHandled()?.let {
            when (it) {
                is String -> Toast.makeText(context, it, timeLength).show()
                is Int -> Toast.makeText(context, context.getString(it), timeLength).show()
                else -> {
                }
            }
        }
    })
}

fun ImageView.loadImage(@DrawableRes resId: Int) = Glide.with(this).load(resId).into(this)
fun ImageView.loadImage(url: String) = Glide.with(this).load(url).into(this)

fun AppCompatTextView.setTextFutureExt(text: String) =
        setTextFuture(
                PrecomputedTextCompat.getTextFuture(
                        text,
                        TextViewCompat.getTextMetricsParams(this),
                        null
                )
        )

fun AppCompatEditText.setTextFutureExt(text: String) =
        setText(
                PrecomputedTextCompat.create(text, TextViewCompat.getTextMetricsParams(this))
        )
