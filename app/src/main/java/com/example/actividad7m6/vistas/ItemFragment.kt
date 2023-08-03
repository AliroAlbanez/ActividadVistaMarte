package com.example.actividad7m6.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.actividad7m6.R
import com.example.actividad7m6.databinding.FragmentItemBinding

class ItemFragment : Fragment() {
    lateinit var iBinding:FragmentItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        iBinding= FragmentItemBinding.inflate(inflater,container,false)

        arguments?.let{bundle ->
            iBinding.textId.text=bundle.getString("id")
            iBinding.textType.text=bundle.getString("type")
            iBinding.textPrice.text=bundle.getInt("price").toString()

            Glide.with(iBinding.imageView)
                .load(bundle.getString("img"))
                .into(iBinding.imageView)

        }

        return iBinding.root
    }
}