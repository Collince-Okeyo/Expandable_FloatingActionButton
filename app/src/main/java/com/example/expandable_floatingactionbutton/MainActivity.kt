package com.example.expandable_floatingactionbutton

import android.os.Build.VERSION_CODES.O
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var add: Button
    lateinit var edit: Button
    lateinit var image: Button
    private  var clicked = false



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


        add.setOnClickListener { View.OnClickListener {
            onAddButtonClicked()

        } }

        edit.setOnClickListener { View.OnClickListener {
            Toast.makeText(this, "Edit button is clicked", Toast.LENGTH_SHORT).show()

        } }

        image.setOnClickListener { View.OnClickListener {
            Toast.makeText(this, "Image button is clicked", Toast.LENGTH_SHORT).show()
        } }



    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
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
}