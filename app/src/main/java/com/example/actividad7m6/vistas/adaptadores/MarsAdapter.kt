package com.example.actividad7m6.vistas.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.actividad7m6.databinding.ModeloMarsBinding
import com.example.actividad7m6.modelos.local.MarsEntity

class MarsAdapter : RecyclerView.Adapter<MarsAdapter.MarsViewHolder>() {

    private var listItem = listOf<MarsEntity>()
    private val SelectedItem = MutableLiveData<MarsEntity>()



    fun update(list:List<MarsEntity>){
        listItem= list
        notifyDataSetChanged()
    }


    // FUNCION PARA SELECCIONAR

    fun selectedItem():
            LiveData<MarsEntity> = SelectedItem


    inner class  MarsViewHolder(private val mBinding:  ModeloMarsBinding):
        RecyclerView.ViewHolder(mBinding.root), View.OnClickListener{

        fun bind(item: MarsEntity){
            Glide.with(itemView)
                .load(item.imgSrc)
                .into(mBinding.imageViewModelo)
            itemView.setOnClickListener(this)

        }
        override  fun onClick(v: View){

            SelectedItem.value= listItem[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        return MarsViewHolder(ModeloMarsBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        val shoes = listItem[position]
        holder.bind(shoes)
    }


    override fun getItemCount()=
        listItem.size
}