package com.example.restinoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restinoapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
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
