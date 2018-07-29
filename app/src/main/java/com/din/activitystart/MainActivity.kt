package com.din.activitystart

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.din.activitystart.lifecycle.LifeCycle
import com.din.activitystart.singleinstance.InstanceActivity
import com.din.activitystart.singletask.TaskActivity
import com.din.activitystart.singletop.TopActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val show = findViewById(R.id.show) as TextView
        show.setText(localClassName)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.startActivity -> {
                startActivity(Intent(this@MainActivity, LifeCycle::class.java))
            }
            R.id.singleTop -> {
                startActivity(Intent(this@MainActivity, TopActivity::class.java))
            }
            R.id.singleTask -> {
                startActivity(Intent(this@MainActivity, TaskActivity::class.java))
            }
            R.id.singleInstance -> {
                startActivity(Intent(this@MainActivity, InstanceActivity::class.java))
            }

        }
    }
}