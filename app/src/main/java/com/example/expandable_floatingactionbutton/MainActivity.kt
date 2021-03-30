package com.example.expandable_floatingactionbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var add: FloatingActionButton
    private lateinit var edit: FloatingActionButton
    private lateinit var image: FloatingActionButton
    private var clicked = false



    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim) }
    private val froBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        add = findViewById(R.id.fab_add)
        edit = findViewById(R.id.fab_edit)
        image = findViewById(R.id.fab_image)


        add.setOnClickListener {
            onAddButtonClicked()
        }

        edit.setOnClickListener {
            Snackbar.make(it, "Edit Button Clicked", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }

        image.setOnClickListener {
            Toast.makeText(this, "Image button is clicked", Toast.LENGTH_SHORT).show()

        }



    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setOnclicks(clicked)
        clicked = !clicked
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked){
            edit.startAnimation(froBottom)
            image.startAnimation(froBottom)
            add.startAnimation(rotateOpen)
        }else{
            edit.startAnimation(toBottom)
            image.startAnimation(toBottom)
            add.startAnimation(rotateClose)
        }
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked){
            edit.visibility = View.VISIBLE
            image.visibility = View.VISIBLE
        }else{
            edit.visibility = View.INVISIBLE
            image.visibility = View.INVISIBLE
        }
    }

    private fun setOnclicks(clicked: Boolean){
        if(!clicked){
            edit.isClickable = true
            image.isClickable = true
        }else{
            edit.isClickable = false
            image.isClickable = false
        }
    }
}