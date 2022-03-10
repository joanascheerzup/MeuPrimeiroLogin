package com.desafio.pratica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.desafio.pratica.databinding.ActivityBemVindoBinding

class BemVindo : AppCompatActivity() {

    private val binding by lazy {
        ActivityBemVindoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bem_vindo)
    }
}