package com.din.activitystart.lifecycle

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.din.activitystart.R

class LifeCycle : AppCompatActivity() {

    private val Tag = "TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        Log.d(Tag, localClassName + ": onCreate")

        val show = findViewById(R.id.show) as TextView
        show.setText(localClassName)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.startNormal -> {
                startActivity(Intent(this@LifeCycle, NormalActivity::class.java))
            }
            R.id.startDialog -> {
                startActivity(Intent(this@LifeCycle, DialogActivity::class.java))
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(Tag, localClassName + ": onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d(Tag, localClassName + ": onStart")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        val data = "这是在 onSaveInstanceState 中的数据"
        outState!!.putString(Tag, data)
        Log.d(Tag, localClassName + ": onSaveInstanceState " + data)
    }
    
    override fun onResume() {
        super.onResume()
        Log.d(Tag, localClassName + ": onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(Tag, localClassName + ": onPause")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        val data = savedInstanceState!!.getString(Tag)
        Log.d(Tag, localClassName + ": onRestoreInstanceState " + data)
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