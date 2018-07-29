package com.din.activitystart.singleinstance

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.din.activitystart.R

class FourActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instance)
        Log.d("DZY", "\n" + localClassName + ": " + this.toString() + "\nTash id -> " + taskId)
        val tip = findViewById(R.id.tip) as TextView
        tip.append(localClassName + ": " + this.toString() + "\n\nTask id : " + taskId)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.startActivity -> {
                startActivity(Intent(this, InstanceActivity::class.java))
            }
            else -> return
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("DZY", "\n" + localClassName + ": " + this.toString() + "\nTash id -> " + taskId)
    }
}
