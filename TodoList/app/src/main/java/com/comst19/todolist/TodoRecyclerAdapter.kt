package com.comst19.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.comst19.todolist.databinding.ItemTodoBinding
import com.comst19.todolist.db.TodoEntity

class TodoRecyclerAdapter(private val todoList : ArrayList<TodoEntity>, private val listener: OnItemLongClickListener) : RecyclerView.Adapter<TodoRecyclerAdapter.MyViewHolder>(){

    inner class MyViewHolder(binding : ItemTodoBinding) : RecyclerView.ViewHolder(binding.root){
        val tv_importance = binding.tvImportance
        val tv_title = binding.tvTitle
        val root = binding.root
    }

    // 뷰홀더 객체를 만듦
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding : ItemTodoBinding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    // 뷰홀더와 아이템 뷰들을 묶어줌
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val todoData = todoList[position]

        when (todoData.importance) {
            1 -> {
                holder.tv_importance.setBackgroundResource(R.color.red)
            }
            2 -> {
                holder.tv_importance.setBackgroundResource(R.color.yellow)
            }
            3 -> {
                holder.tv_importance.setBackgroundResource(R.color.green)
            }

        }
        holder.tv_importance.text = todoData.importance.toString()
        holder.tv_title.text = todoData.title

        holder.root.setOnLongClickListener {
            listener.onLongClick(position)
            false
            // false라고 하면, 다른 클릭 이벤트 onClcik들도 실행, True라고 하면 오직 onLongClick만 실행
        }
    }

    // 아이템 뷰들의 갯수
    override fun getItemCount(): Int {
        return todoList.size
    }


}