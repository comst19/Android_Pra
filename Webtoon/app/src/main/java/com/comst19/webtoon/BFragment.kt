package com.comst19.webtoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.comst19.webtoon.databinding.FragmentSeconfBinding
import com.comst19.webtoon.databinding.FragmentWebviewBinding

class BFragment : Fragment(){

    private lateinit var binding : FragmentSeconfBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSeconfBinding.inflate(inflater)
        return binding.root
    }
}