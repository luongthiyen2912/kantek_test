package com.demo.test.ui.component.login

import android.accounts.NetworkErrorException
import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import com.demo.coreservice.data.remote.network.Resource
import com.demo.coreservice.models.User
import com.demo.coreservice.utils.EUtils.Companion.isValidEmail
import com.demo.coreservice.utils.observe
import com.demo.test.R
import com.demo.test.ui.base.BaseActivity
import com.demo.test.ui.base.ViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity() {
    @Inject
    lateinit var loginViewModel: LoginViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    override val layoutId: Int
        get() = R.layout.activity_login

    override fun initViewModel() {
        loginViewModel = viewModelFactory.create(LoginViewModel::class.java)
    }

    override fun observeViewModel() {
        observe(loginViewModel.loginLiveData, ::handleLogin)
        observeToast(container, loginViewModel.showToast)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            if (email.isEmpty()) {
                showErrorEmail(R.string.err_input_email)
            }

            if (password.isEmpty()) {
                showErrorPassword(R.string.err_input_password)
            } else {
                tvErrorPassword.visibility = GONE
            }

            if (email.isNotEmpty() && !isValidEmail(email)) {
                showErrorEmail(R.string.err_invalid_email)
            }

            if (email.isNotEmpty() && isValidEmail(email)) {
                tvErrorEmail.visibility = GONE
            }
            if (email.isNotEmpty() && isValidEmail(email) && password.isNotEmpty()) {
                loginViewModel.login(email, password)
            }
        }

    }

    fun showErrorEmail(message: Int) {
        tvErrorEmail.visibility = VISIBLE
        tvErrorEmail.setText(message)
    }

    fun showErrorPassword(message: Int) {
        tvErrorPassword.visibility = VISIBLE
        tvErrorPassword.setText(message)
    }

    private fun handleLogin(user: Resource<User.UserRespond>) {
        when (user) {
            is Resource.Loading -> showProgressDialog()
            is Resource.Success -> user.data?.let {
                dismissProgressDialog()
                when (it.result) {
                    true -> {
                        User.clearLoginInfo()
                        User.saveUserInfo(it)
                        loginViewModel.showToastMessage(it.message)
                    }
                    else -> loginViewModel.showToastMessage(it.message)
                }
            }
            is Resource.Error ->
                user.t?.let {
                    dismissProgressDialog()
                    if (it is NetworkErrorException) {
                        loginViewModel.showToastMessage(R.string.err_connect_internet)
                    } else {
                        loginViewModel.showToastMessage(R.string.err_try_again)
                    }
                }
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }


}
