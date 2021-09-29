package com.example.testproject.fragments.navigationMenu

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.example.testproject.R

class StartFragment : Fragment() {

    private lateinit var mp: MediaPlayer
    private lateinit var button1: AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.start_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button1 = view.findViewById(R.id.appCompatButton1)
        button1.isSoundEffectsEnabled = false
        mp = MediaPlayer.create(context, R.raw.click)
        button1.setOnClickListener {
            mp.start()
        }
    }
}