package com.din.activitystart.lifecycle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.din.activitystart.R

class DialogActivity : Activity() {

    private val Tag = "TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_children)
        Log.d(Tag, localClassName + ": onCreate")

        val tip = findViewById(R.id.tip) as TextView
        tip.setText("这是一个DialogActivity")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(Tag, localClassName + ": onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d(Tag, localClassName + ": onStart")
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(Tag, localClassName + ": onNewIntent")
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