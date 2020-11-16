package com.aman_ar.realworld_io.fragments.auth

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.aman_ar.realworld_io.R
import com.aman_ar.realworld_io.viewmodels.UsersViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.etEmail
import kotlinx.android.synthetic.main.fragment_register.etPassword

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    var viewModel: UsersViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProviders.of(it).get(UsersViewModel::class.java)
        }

        btnLogin.setOnClickListener {
            viewModel?.loginUser(
                etEmail.text.toString(),
                etPassword.text.toString()
            )
        }

        viewModel?.currentUser?.observe(
            { lifecycle },
            {
                Toast.makeText(context, "Logged in as " + it.username, Toast.LENGTH_SHORT).show()
                activity?.supportFragmentManager?.popBackStack()
            }
        )
    }

}