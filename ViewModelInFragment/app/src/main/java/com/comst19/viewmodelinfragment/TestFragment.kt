package com.comst19.viewmodelinfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.comst19.viewmodelinfragment.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    private lateinit var binding : FragmentTestBinding
    private lateinit var viewModel: TestFragmentViewModel
//    var countValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)

        viewModel = ViewModelProvider(this).get(TestFragmentViewModel::class.java)
        binding.resultArea.text = viewModel.getCount().toString()

        binding.plus.setOnClickListener {
            viewModel.plus()
            binding.resultArea.text = viewModel.getCount().toString()
//            countValue++
//            binding.resultArea.text = countValue.toString()
        }

        binding.minus.setOnClickListener {
            viewModel.minus()
            binding.resultArea.text = viewModel.getCount().toString()
//            countValue--
//            binding.resultArea.text = countValue.toString()
        }
        return binding.root
    }

}