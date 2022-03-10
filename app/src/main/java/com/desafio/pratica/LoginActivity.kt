package com.desafio.pratica

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.PatternsCompat
import com.desafio.pratica.databinding.ActivityLoginBinding
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Login"
        configuraBotaoEntrar()
    }

    private fun validar() {
        val resultado = arrayOf(validaEmail(), validaSenha())

        if (false in resultado) {
            return
        } else {
            vaiParaBemVindo()
        }


    }

    private fun validaEmail() : Boolean {
        val emailAValidar = binding.loginEmail.editableText.toString()
        return if (emailAValidar.isEmpty()) {
            binding.loginEmail.error = "O campo não pode estar vazio."
            false
        } else if (!PatternsCompat.EMAIL_ADDRESS.matcher(emailAValidar).matches()) {
            binding.loginEmail.error = "Por favor, digite um endereço de e-mail válido."
            false
        } else {
            binding.loginEmail.error = null
            true
        }
    }

    private fun validaSenha() : Boolean {
        val senhaAValidar = binding.loginPassword.editableText.toString()
        //arrumar regex
        val passwordRegex = Pattern.compile(
            "^(?=.*[A-Za-z])(?=.*)[A-Za-z]{8,}$",
        )
        return if(senhaAValidar.isEmpty()) {
            binding.loginPassword.error = "O campo não pode estar vazio."
            false
        } else  {
            binding.loginPassword.error = null
            true
        }
    }

    private fun configuraBotaoEntrar() {
        val botaoEntrar = binding.botaoEntrar
        botaoEntrar.setOnClickListener {
            validar()
        }
    }

    private fun vaiParaBemVindo() {
        val intent = Intent(this, BemVindo::class.java)
        startActivity(intent)
    }

}

