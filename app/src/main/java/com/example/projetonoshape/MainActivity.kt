package com.example.projetonoshape

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetonoshape.R
import com.example.projetonoshape.TelaMenu

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton: Button = findViewById(R.id.loginbutton)
        val emailEditText: EditText = findViewById(R.id.editTextTextEmailAddress)
        val passwordEditText: EditText = findViewById(R.id.editTextTextPassword)

        loginButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val email = emailEditText.text.toString().trim()
                val password = passwordEditText.text.toString().trim()

                if (isValidEmail(email) && isValidPassword(password)) {
                    val intent = Intent(this@MainActivity, TelaMenu::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Credenciais inválidas. Verifique seu email e senha.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }
}
