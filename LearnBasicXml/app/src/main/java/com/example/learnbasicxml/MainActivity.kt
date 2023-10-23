package com.example.learnbasicxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var nav_leftmenu : NavigationView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // sử dụng màu cho menu
        nav_leftmenu = findViewById(R.id.nav_leftmenu);
        nav_leftmenu.itemIconTintList = null;
    }
}