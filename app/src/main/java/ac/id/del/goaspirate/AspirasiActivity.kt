package ac.id.del.goaspirate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AspirasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aspirasi)

        val btneditApirasi = findViewById<Button>(R.id.editAspirasi)

        btneditApirasi.setOnClickListener {
            val intent = Intent(this, EditAspirasiActivity::class.java)
            startActivity(intent)
        }
    }
}