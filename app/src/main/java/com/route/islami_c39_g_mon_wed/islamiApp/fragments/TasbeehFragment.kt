package com.route.islami_c39_g_mon_wed.islamiApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami_c39_g_mon_wed.R
import com.route.islami_c39_g_mon_wed.databinding.FragmentQuranBinding
import com.route.islami_c39_g_mon_wed.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {
    lateinit var binding: FragmentTasbeehBinding
    var counter = 0
    var currentDhikrIndex = 0
    lateinit var azkarList: MutableList<String>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbeehBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        binding.dhikrTv.text = azkarList[currentDhikrIndex]
        binding.counterTv.text = counter.toString()

        onSebhaClick()
    }

    private fun onSebhaClick() {

        binding.bodyOfSebha.setOnClickListener{

            binding.bodyOfSebha.rotation += (360/33).toFloat()

            if (counter<33){
                counter++
            }else{
                counter = 0                  // 3              // 3
                currentDhikrIndex = if (currentDhikrIndex < azkarList.size -1) ++currentDhikrIndex else 0
                binding.dhikrTv.text = azkarList[currentDhikrIndex]
            }
            binding.counterTv.text = counter.toString()

        }
    }

}
