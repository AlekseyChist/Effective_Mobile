package com.aleksei.chistiakov.effective_mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aleksei.chistiakov.effective_mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_search -> {
                    // Переход к экрану поиска
                    true
                }
                R.id.navigation_favorites -> {
                    // Переход к экрану избранного
                    true
                }
                R.id.navigation_responses -> {
                    // Переход к экрану откликов
                    true
                }
                R.id.navigation_messages -> {
                    // Переход к экрану сообщений
                    true
                }
                R.id.navigation_profile -> {
                    // Переход к экрану профиля
                    true
                }
                else -> false
            }
        }

        // Установка начального экрана
        binding.bottomNavigation.selectedItemId = R.id.navigation_search
    }
}
