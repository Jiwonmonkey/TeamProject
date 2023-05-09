package com.example.teamproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teamproject.databinding.ActivityMainBinding
import com.example.teamproject.fragment.HomeFragment
import com.example.teamproject.fragment.MapFragment
import com.example.teamproject.fragment.MyPageForUserFragment

class MainActivity : AppCompatActivity(){

    private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setFrag(0)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home_menu -> {
                    setFrag(0)
                    true
                }
                R.id.map_menu -> {
                    setFrag(1)
                    true
                }
                R.id.my_memu -> {
                    setFrag(2)
                    true
                }
                else -> false
            }
        }
    }

    private fun setFrag(fragNum: Int) {
        val ft = supportFragmentManager.beginTransaction()
        when(fragNum){
            0 -> {
                ft.replace(R.id.main_frame, HomeFragment()).commit()
            }
            1 -> {
                ft.replace(R.id.main_frame, MapFragment()).commit()
            }
            2 -> {
                ft.replace(R.id.main_frame, MyPageForUserFragment()).commit()
            }
        }
    }
}
