package ac.id.del.goaspirate

import ac.id.del.goaspirate.fragments.AccountFragment
import ac.id.del.goaspirate.fragments.HomeFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val homeFragment = HomeFragment()
        val accountFragment = AccountFragment()
        val navigation = findViewById<BottomNavigationView>(R.id.buttom_navigation)


        makeCurrentFragment(homeFragment)

        navigation.setOnItemSelectedListener {
            when (it.itemId){
                R.id.itemHome -> makeCurrentFragment(homeFragment)
                R.id.itemAccount -> makeCurrentFragment(accountFragment)
            }
            true
        }
    }
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.dashboard, fragment)
            commit()
        }
}