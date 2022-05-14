package ac.id.del.goaspirate

import ac.id.del.goaspirate.fragments.AccountFragment
import ac.id.del.goaspirate.fragments.AspirasiFragment
import ac.id.del.goaspirate.fragments.HomeFragment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navigation = findViewById<BottomNavigationView>(R.id.buttom_navigation)

        navigation.setOnItemSelectedListener {
            if(it.itemId==R.id.itemHome){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }else if(it.itemId==R.id.itemAspirasi){
                val intent = Intent(this, AspirasiActivity::class.java)
                startActivity(intent)
            }else if(it.itemId==R.id.itemAccount){
                val intent = Intent(this, AccountActivity::class.java)
                startActivity(intent)
            }
            true
        }
    }
}