package com.example.snehaAssignment1.fragment

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.viewModels
import com.example.snehaAssignment1.R
import com.example.snehaAssignment1.databinding.FragmentSignUpBinding
import com.example.snehaAssignment1.viewModel.SignUpViewModel
import java.text.SimpleDateFormat
import java.util.*

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        binding.vm = signUpViewModel

        val date = Calendar.getInstance().time
        binding.tvDob.text = formatter.format(date)

        binding.tvDob.setOnClickListener {
            fun clickDataPicker(view: View) {
                val c = Calendar.getInstance()

                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val date = c.get(Calendar.DAY_OF_MONTH)

                val dpd = DatePickerDialog(
                    requireActivity(),
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                        binding.tvDob.text = "$year - ${monthOfYear + 1} - $dayOfMonth"

                    }, year, month, date
                )
                dpd.show()
            }
        }

        binding.btnSignUp.setOnClickListener {
            signUpViewModel.onSignUpClick()
        }

        binding.tvLoginTitle.setOnClickListener {
            signUpViewModel.onLoginClick()
        }

      }

    }
