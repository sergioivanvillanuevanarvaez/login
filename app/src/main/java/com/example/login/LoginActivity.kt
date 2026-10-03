package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsuario: EditText
    private lateinit var etTelefono: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvError: TextView
    private lateinit var btnLogin: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsuario = findViewById(R.id.etUsuario)
        etTelefono = findViewById(R.id.etTelefono)
        etPassword = findViewById(R.id.etPassword)
        tvError = findViewById(R.id.tvError)
        btnLogin = findViewById(R.id.btnLogin)
        progressBar = findViewById(R.id.progressBar)

        btnLogin.setOnClickListener {
            validarLogin()
        }
    }

    private fun validarLogin() {
        val usuario = etUsuario.text.toString().trim()
        val telefono = etTelefono.text.toString().trim()
        val password = etPassword.text.toString().trim()

        tvError.text = ""

        if (usuario.isEmpty() || telefono.isEmpty() || password.isEmpty()) {
            tvError.text = "Por favor llena todos los campos"
            return
        }

        progressBar.visibility = ProgressBar.VISIBLE
        btnLogin.isEnabled = false

        btnLogin.postDelayed({
            progressBar.visibility = ProgressBar.GONE
            btnLogin.isEnabled = true

            if (usuario == "admin" && password == "1234") {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                tvError.text = "Usuario o contraseña incorrectos"
            }
        }, 1000)
    }
}