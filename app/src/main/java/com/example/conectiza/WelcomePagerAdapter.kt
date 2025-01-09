package com.example.conectiza

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class WelcomePagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3 // Cambia este valor según la cantidad de pantallas/fragments.

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstScreenFragment()  // Asegúrate de que estas clases existen.
            1 -> SecondScreenFragment()
            else -> ThirdScreenFragment()
        }
    }
}
