package ac.id.del.goaspirate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var  auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        val login = findViewById<TextView>(R.id.tvLogin)
        val btnRegister =  findViewById<Button>(R.id.btnRegister)
        val password = findViewById<EditText>(R.id.editPassword)
        val CPassword = findViewById<EditText>(R.id.editCpassword)
        val email = findViewById<EditText>(R.id.editEmail)

        fun registerUser(){
            auth.createUserWithEmailAndPassword(email.text.trim().toString(), password.text.trim().toString())
                .addOnCompleteListener(this){
                        task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "register succesfull", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this, "register failed"+task.exception, Toast.LENGTH_LONG).show()
                    }
                }
        }

        btnRegister.setOnClickListener {
            if(password.text.trim().isNotEmpty() || CPassword.text.trim().isNotEmpty() || email.text.trim().isNotEmpty()){
                registerUser()
            }else{
                Toast.makeText(this, "Input req", Toast.LENGTH_LONG).show()
            }
        }

        login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        fun onStart() {
            super.onStart()
            val user = auth.currentUser

            if (user != null) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Input req", Toast.LENGTH_LONG).show()
            }
        }
    }
}