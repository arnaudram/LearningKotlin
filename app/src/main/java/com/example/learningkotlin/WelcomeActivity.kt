package com.example.learningkotlin

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val sharepref= getSharedPreferences("user_preference", Context.MODE_PRIVATE)?: return
       with(sharepref.edit()){
           this.putString("name_pref",receive_extra_name)
           this.commit()
       }
      tv_namePreference.text=sharepref.getString("name_pref","")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater=menuInflater
        inflater.inflate(R.menu.menu_welcome_activity,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.profile_name ->{
                welcomeToast()

                true
            }
            else->{
                super.onOptionsItemSelected(item)
            }
        }


    }

    private val receive_extra_name: String
        get() {
            val receive_extra_name = intent.getStringExtra(MainActivity().NAME_MAINACTIVITY)!!
            return receive_extra_name
        }

    private fun welcomeToast() {
       //val receive_extra_name= intent.getStringExtra(MainActivity().NAME_MAINACTIVITY)!!
        Toast.makeText(baseContext,"Welcome :$receive_extra_name ",Toast.LENGTH_LONG).show()
    }
}
