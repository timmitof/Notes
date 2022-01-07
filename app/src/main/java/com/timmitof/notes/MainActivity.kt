package com.timmitof.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.timmitof.notes.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, MainFragment())
            .commit()
    }
}