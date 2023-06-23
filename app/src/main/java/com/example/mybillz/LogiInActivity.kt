package com.example.mybillz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mybillz.databinding.ActivityLogiInBinding
import com.example.mybillz.databinding.ActivityMainBinding

class LogiInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogiInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLogiInBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_logi_in)
        validatLog()
        clear()

    }

    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
    }
    fun validatLog(){
        val name1=binding.etUserName.text.toString()
        val name2=binding.etPassword.text.toString()

        var error = true

        if(name1.isBlank()){
            binding.tilUserName.error="User name is required"
            error=false
        }
        if(name2.isBlank()){
            binding.tilPassword.error="Password required"
        }
        if(!error){
            Toast.makeText(this, "You're logged in", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
    fun clear(){
        binding.tilUserName.error=null
        binding.tilPassword.error=null
    }

}