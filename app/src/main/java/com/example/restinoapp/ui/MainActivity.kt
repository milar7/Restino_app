package com.example.restinoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.restinoapp.R
import com.example.restinoapp.ui.home.HomeFragmentDirections
import com.example.restinoapp.util.isValidPassword
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val TAG ="MainActivityTag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        val actionBar= supportActionBar
        actionBar?.title=""


        btn_sign_in_home.setOnClickListener {

            Navigation.findNavController(this,R.id.nav_host_fragment).navigate(
                HomeFragmentDirections.actionHomeFragmentToLoginFragment()
            )

        }
    }





    override fun networkAvailable() {
        super.networkAvailable()
        tv.post {
            with(tv){
                text="connected"
            }
        }
    }

    override fun networkUnavailable() {
        super.networkUnavailable()
        tv.post {
            with(tv){
                text="connecting..."
            }
        }
    }
}
