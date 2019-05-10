package meditation.superbeings.com.meditationapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import meditation.superbeings.com.meditationapp.R
import meditation.superbeings.com.meditationapp.ui.InstructionModule.InstructionFragment
import meditation.superbeings.com.meditationapp.ui.MeditationsModule.MeditationsFragment
import meditation.superbeings.com.meditationapp.ui.SettingsModule.SettingsFragment
import meditation.superbeings.com.meditationapp.ui.homeModule.HomeFragment

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViews()
    }

    private fun setUpViews()
    {
        val bottomNavigationBar : BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationBar.setOnNavigationItemSelectedListener (mOnBottomNavigationItemSelectedListener)
        bottomNavigationBar.selectedItemId = R.id.home

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        val navigationView : NavigationView = findViewById(R.id.nav_view)
        val drawerLayout : DrawerLayout = findViewById(R.id.drawer_layout)


        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private val mOnNavigationItemSelectedListener = NavigationView.OnNavigationItemSelectedListener { menuItem ->

        when(menuItem.itemId)
        {
            R.id.nav_settings ->
            {
                val settingsFragment = SettingsFragment.newInstance()
                openFragment(settingsFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private val mOnBottomNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId)
        {
            R.id.home ->
            {
                val homeFragment = HomeFragment.newInstance()
                openFragment(homeFragment)

                return@OnNavigationItemSelectedListener true
            }

            R.id.instructions ->
            {
                val instructionFragment = InstructionFragment.newInstance()
                openFragment(instructionFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.meditations ->
            {
                val meditationsFragment = MeditationsFragment.newInstance()
                openFragment(meditationsFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.settings ->
            {
                val settingsFragment = SettingsFragment.newInstance()
                openFragment(settingsFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    private fun openFragment(fragment : Fragment)
    {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
