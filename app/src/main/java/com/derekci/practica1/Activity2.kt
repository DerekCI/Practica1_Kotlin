package com.derekci.practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.derekci.practica1.databinding.Activity2Binding
import com.derekci.practica1.databinding.ActivityMainBinding

lateinit var binding2: Activity2Binding
class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = Activity2Binding.inflate(layoutInflater)
        setContentView(binding2.root)

        val res1 = intent.getDoubleExtra("resultado1",0.0)
        val res2 = intent.getDoubleExtra("resultado2", 0.0)


        var tv1 = binding2.tvValor1
        var tv2 = binding2.tvValor2

        var string: String = getString(R.string.special)

        if(res1 == Double.NaN){
            tv1.text = string
            tv2.text = string
        }else{
            tv1.text = res1.toString()
            if(res2 == 0.0){
                tv2.text = "No aplica"
            }else{
                tv2.text = res2.toString()
            }
        }





    }
}