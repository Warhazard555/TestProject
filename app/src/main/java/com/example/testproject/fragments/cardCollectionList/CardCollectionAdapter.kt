package com.example.testproject.fragments.cardCollectionList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.dto.CardDto
import com.example.testproject.R

class CardCollectionAdapter (private val list: List<CardDto>): RecyclerView.Adapter<CardCollectionAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name: AppCompatTextView = itemView.findViewById(R.id.card_name)
    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_collection_fragment,parent,false)
    return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name
    }

    override fun getItemCount(): Int {
        return list.size
    }

}