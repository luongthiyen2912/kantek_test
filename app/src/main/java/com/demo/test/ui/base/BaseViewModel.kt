package com.demo.test.ui.base

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.coreservice.utils.Event

abstract class BaseViewModel : ViewModel() {
    private val showToastPrivate = MutableLiveData<Event<Any>>()
    val showToast: LiveData<Event<Any>> get() = showToastPrivate

    fun showToastMessage(@StringRes message: Int) {
        showToastPrivate.value = Event(message)
    }

    fun showToastMessage(message: String) {
        showToastPrivate.value = Event(message)
    }
}