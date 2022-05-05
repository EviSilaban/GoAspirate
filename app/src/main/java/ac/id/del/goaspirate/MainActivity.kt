package ac.id.del.goaspirate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var  auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        val btnLogin =  findViewById<Button>(R.id.btnLogin)
        val username = findViewById<EditText>(R.id.edUsername)
        val password = findViewById<EditText>(R.id.edPassword)
        val register = findViewById<TextView>(R.id.tvRegister)

        fun signInUser(){
            auth.signInWithEmailAndPassword(username.text.trim().toString(), password.text.trim().toString())
                .addOnCompleteListener(this){
                        task ->
                    if(task.isSuccessful){
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "register failed"+task.exception, Toast.LENGTH_LONG).show()
                    }
                }
        }
        btnLogin.setOnClickListener {
            if(username.text.trim().isNotEmpty() || password.text.trim().isNotEmpty()){
                signInUser()
            }else{
                Toast.makeText(this, "Input req", Toast.LENGTH_LONG).show()
            }
        }
        register.setOnClickListener {
           val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        fun onStart() {
            super.onStart()
            val user = auth.currentUser
            if (user != null) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "please login", Toast.LENGTH_LONG).show()
            }
        }
    }
}