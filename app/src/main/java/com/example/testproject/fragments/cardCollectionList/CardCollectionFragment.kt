package com.example.testproject.fragments.cardCollectionList

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.data.retrofit.RetrofitService
import com.example.domain.dto.CardDto
import com.example.testproject.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CardCollectionFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cardCollectionAdapter: CardCollectionAdapter
    private lateinit var cardList: MutableList<CardDto>
     private var retrofitBuilder = RetrofitService.getRetrofit()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getCard()
        recyclerView = view.findViewById(R.id.recycler_view)

    }

    private fun getCard() {

        val retrofit = retrofitBuilder.allCards()

        retrofit.enqueue(object : Callback<MutableList<CardDto>?> {
            override fun onResponse(
                call: Call<MutableList<CardDto>?>,
                response: Response<MutableList<CardDto>?>
            ) {
                cardList = response.body() as MutableList<CardDto>
                cardCollectionAdapter = CardCollectionAdapter(cardList)
                cardCollectionAdapter.notifyDataSetChanged()
                recyclerView.adapter = cardCollectionAdapter
            }


            override fun onFailure(call: Call<MutableList<CardDto>?>, t: Throwable) {
                d("Fragment", "onFailure: " + t.message)
            }
        })

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.card_collection_recycler, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}