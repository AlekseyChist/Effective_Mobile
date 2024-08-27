package com.aleksei.chistiakov.effective_mobile

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.aleksei.chistiakov.effective_mobile.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.tilEmail.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validateEmail(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.btnContinue.setOnClickListener {
            if (validateEmail(binding.tilEmail.editText?.text.toString())) {
                // Переход к экрану ввода кода подтверждения
                // TODO: Implement navigation to confirmation code screen
            }
        }

        binding.btnLogin.setOnClickListener {
            // TODO: Implement login with password
        }

        binding.btnSearchEmployees.setOnClickListener {
            // TODO: Implement navigation to employee search
        }
    }

    private fun validateEmail(email: String): Boolean {
        return if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Введите корректный email"
            binding.btnContinue.isEnabled = false
            false
        } else {
            binding.tilEmail.error = null
            binding.btnContinue.isEnabled = true
            true
        }
    }
}