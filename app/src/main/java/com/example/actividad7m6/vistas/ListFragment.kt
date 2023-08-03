package com.example.actividad7m6.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.actividad7m6.R
import com.example.actividad7m6.databinding.FragmentListBinding
import com.example.actividad7m6.vistas.adaptadores.MarsAdapter
import com.example.actividad7m6.vistas.viewsModels.ViewModelMars


class ListFragment : Fragment() {
    lateinit var lBinding: FragmentListBinding
    private val lViewModel : ViewModelMars by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       lBinding= FragmentListBinding.inflate(inflater,container,false)
        return lBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val adapter = MarsAdapter()
        lBinding.Recycler1.adapter=adapter
        lBinding.Recycler1.layoutManager= GridLayoutManager(context,2)
        lViewModel.getMarsList().observe(viewLifecycleOwner, Observer {

            it?.let {
                adapter.update(it)
            }

        })


        adapter.selectedItem().observe(viewLifecycleOwner, Observer {


            it?.let {


            }
            val bundle = Bundle().apply {
                putString("id", it.id)
                putString("type",it.type)
                putString("img",it.imgSrc)
                putInt("price",it.price)
            }
            findNavController().navigate(R.id.action_listFragment_to_itemFragment, bundle)

        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        //mBinding = null
    }
}