package com.alferdize.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.alferdize.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Anubhav ")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName
//        findViewById<Button>(R.id.button).setOnClickListener {
//            addNickname(it)
//        }
        binding.button.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(it: View) {
        binding.apply {
            myName?.nickname = editTextTextPersonName.text.toString()
            binding.textView3.text = binding.editTextTextPersonName.text
            binding.editTextTextPersonName.visibility = View.GONE
            button.visibility = View.GONE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it.windowToken, 0)
    }
}