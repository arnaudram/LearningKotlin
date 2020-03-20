package com.example.learningkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   val NAME_MAINACTIVITY = "name_mainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_next.setOnClickListener {
            if (editText_name.text.isNotEmpty()) {
                Log.d(localClassName,"no Empty field")
                val name=editText_name.text.toString()
                Toast.makeText(baseContext,"Welcome and well done $name",Toast.LENGTH_LONG).show()
               val intentWelcomeActivity= Intent(this,WelcomeActivity::class.java)
                // updating Intent to share name value

                intentWelcomeActivity.putExtra(NAME_MAINACTIVITY,name)
                startActivity(intentWelcomeActivity)
            }
            else
                editText_name.setError("Please Provide us with your name")

        }

    }
}
