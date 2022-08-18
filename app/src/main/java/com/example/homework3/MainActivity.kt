package com.example.homework3

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<EditText>(R.id.reference).setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    loadImage()
                    true
                }
                else -> false
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    private fun loadImage() {
        val imageView = findViewById<ImageView>(R.id.image)
        val imageURL = findViewById<EditText>(R.id.reference).text.toString()

        try {
            Picasso.get().load(imageURL).into(imageView)
        } catch (e: Exception) {
            Toast.makeText(this, "Wrong reference", Toast.LENGTH_SHORT).show()
        } finally {
            // optional finally block
        }
    }
}