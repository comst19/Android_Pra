package com.comst19.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.comst19.rockpaperscissors.Result
import com.comst19.rockpaperscissors.databinding.ActivityMainBinding
import java.lang.Math.random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeViews()

    }

    private fun initializeViews(){
        binding.rockBtn.setOnClickListener{handleHand(Hand.ROCK)}
        binding.paperBtn.setOnClickListener{handleHand(Hand.PAPER)}
        binding.scissorBtn.setOnClickListener{handleHand(Hand.SCISSOR)}
    }

    private fun handleHand(hand:Hand){
        val result = createResult()
        binding.resultText.text = result.statment
        when(result){
            Result.WIN -> when(hand){
                Hand.ROCK -> binding.oppentHand.text = Hand.SCISSOR.name
                Hand.PAPER -> binding.oppentHand.text = Hand.ROCK.name
                Hand.SCISSOR -> binding.oppentHand.text = Hand.PAPER.name
            }
            Result.DRAW -> when(hand){
                Hand.ROCK -> binding.oppentHand.text = Hand.ROCK.name
                Hand.PAPER -> binding.oppentHand.text = Hand.PAPER.name
                Hand.SCISSOR -> binding.oppentHand.text = Hand.SCISSOR.name
            }
            Result.LOSE -> when(hand){
                Hand.ROCK -> binding.oppentHand.text = Hand.PAPER.name
                Hand.PAPER -> binding.oppentHand.text = Hand.SCISSOR.name
                Hand.SCISSOR -> binding.oppentHand.text = Hand.ROCK.name
            }
        }
    }
    private fun createResult() : Result{
        return Result.values()[(random() * 3).toInt()]
    }
}