package com.demo.test.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import com.demo.coreservice.utils.Event
import com.demo.coreservice.utils.showToast
import com.demo.test.R
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var baseViewModel: BaseViewModel

    private var dialog: ProgressDialog ?= null
    abstract val layoutId: Int

    abstract fun initViewModel()

    abstract fun observeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initViewModel()
        observeViewModel()
    }

    fun showProgressDialog() {
        if (dialog == null) {
            dialog = ProgressDialog(this)
            dialog?.setCanceledOnTouchOutside(false)
            dialog?.setMessage(getString(R.string.mess_loading))
            dialog?.show()
        }

    }

    fun dismissProgressDialog() {
        if (dialog!!.isShowing) {
            dialog?.dismiss()
            dialog = null
        }
    }

     fun observeToast(view : View, event: LiveData<Event<Any>>) {
         view.showToast(this, event, Snackbar.LENGTH_LONG)
    }
}