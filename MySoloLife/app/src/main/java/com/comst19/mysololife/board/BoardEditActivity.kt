package com.comst19.mysololife.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.comst19.mysololife.R
import com.comst19.mysololife.databinding.ActivityBoardEditBinding
import com.comst19.mysololife.utils.FBAuth

import com.comst19.mysololife.utils.FBRef
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class BoardEditActivity : AppCompatActivity() {

    private lateinit var  key : String

    private lateinit var binding : ActivityBoardEditBinding

    private val TAG = BoardEditActivity::class.java.simpleName

    private lateinit var writerUid : String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        key = intent.getStringExtra("key").toString()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_edit)

        getBoardData(key)
        getImageData(key)

        binding.editBtn.setOnClickListener{
            editBoardData(key)

        }
    }

    private fun editBoardData(key : String){
        FBRef.boardRef
            .child(key)
            .setValue(BoardModel(binding.titleArea.text.toString(),
                binding.contentArea.text.toString(),
                writerUid,
                FBAuth.getTime()))
        Toast.makeText(this, "수정완료",Toast.LENGTH_LONG).show()
        finish()
    }

    private fun getImageData(key : String){
        // Reference to an image file in Cloud Storage
        val storageReference = Firebase.storage.reference.child(key+".png")

        // ImageView in your Activity
        val imageViewFromFB = binding.imageArea

        storageReference.downloadUrl.addOnCompleteListener(OnCompleteListener { task ->
            if(task.isSuccessful){
                Glide.with(this)
                    .load(task.result)
                    .into(imageViewFromFB)
            }
        })

    }

    private fun getBoardData(key : String){

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val dataModel = dataSnapshot.getValue(BoardModel::class.java)
                binding.titleArea.setText(dataModel?.title)
                binding.contentArea.setText(dataModel?.content)
                writerUid = dataModel!!.uid.toString()

            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())

            }
        }
        FBRef.boardRef.child(key).addValueEventListener(postListener)

    }

}