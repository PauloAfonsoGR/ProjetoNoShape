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

class TelaCadastro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro)

        val cadastroButton: Button = findViewById(R.id.cadastrobutton)
        val emailEditText: EditText = findViewById(R.id.editTextEmailAddress)
        val passwordEditText: EditText = findViewById(R.id.editTextPassword)

        cadastroButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val email = emailEditText.text.toString().trim()
                val password = passwordEditText.text.toString().trim()

                if (isValidEmail(email) && isValidPassword(password)) {
                    val intent = Intent(this@TelaCadastro, TelaMenu::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@TelaCadastro,
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
