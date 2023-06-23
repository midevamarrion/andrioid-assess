package com.example.mybillz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mybillz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        validateregistration()

    }

    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.btnSignUp.setOnClickListener {
            clearErrors()
        }
        binding.tvSignIn.setOnClickListener {
            val intent=Intent(this, LogiInActivity::class.java)
            startActivity(intent)
        }
    }

    fun validateregistration() {
        val name = binding.etUserName.text.toString()
        val name1 = binding.etEmail.text.toString()
        val name2 = binding.etPhoneNumber.text.toString()
        val name3 = binding.etPassword.text.toString()

        var error = false

        if (name.isBlank()){
            binding.tilUserName.error="Username required"
            error=true
        }
        if(name1.isBlank()){
            binding.tilEmail.error="Email required"
            error=true
        }
        if(name2.isBlank()){
            binding.tilPhoneNumber.error="PhoneNumber required"
            error=true
        }
        if(name3.isBlank()){
            binding.tilPassword.error="Password is required"
            error=true
        }
        if(!error){
            val intent=Intent(this, LogiInActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Registration is completed",Toast.LENGTH_SHORT).show()
            finish()

        }


    }
    fun clearErrors(){
        binding.tilUserName.error=null
        binding.tilEmail.error=null
        binding.tilPhoneNumber.error=null
        binding.tilPassword.error=null
    }


}