package com.din.activitystart.singletop

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.din.activitystart.R

class TopActivity : AppCompatActivity() {

    private val Tag = "TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        Log.d(Tag, localClassName + ": onCreate  " + this.toString())

        val tip = findViewById(R.id.tip) as TextView
        tip.setText(localClassName + " : " + this.toString())
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.startActivity -> {
                startActivity(Intent(this@TopActivity, TopActivity::class.java))
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(Tag, localClassName + ": onRestart " + this.toString())
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(Tag, localClassName + ": onNewIntent " + this.toString())
    }

    override fun onStart() {
        super.onStart()
        Log.d(Tag, localClassName + ": onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(Tag, localClassName + ": onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(Tag, localClassName + ": onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(Tag, localClassName + ": onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Tag, localClassName + ": onDestroy")
    }
}