package com.example.learningkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater=menuInflater
        inflater.inflate(R.menu.menu_welcome_activity,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       when(item.itemId){
            R.id.profile_name ->{
                welcomeToast()
              return  true
            }
            else->{return super.onOptionsItemSelected(item) }
        }


    }

    private fun welcomeToast() {
        val receive_extra_name= intent.getStringExtra(MainActivity().NAME_MAINACTIVITY)!!
        Toast.makeText(baseContext,"Welcome :$receive_extra_name ",Toast.LENGTH_LONG).show()
    }
}
