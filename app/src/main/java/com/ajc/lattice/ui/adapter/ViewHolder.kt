package com.ajc.lattice.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ajc.lattice.model.local.NewsEntity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class ViewHolder(itemView: View, private val onClick: OnClick) : RecyclerView.ViewHolder(itemView) {

    fun setData(result: NewsEntity) {

        itemView.apply {
            CardView1.setOnClickListener {
                onClick.setOnClick(result)
            }

            tvDate1.text = result.date
            tvTitle1.text = result.Name
            tvTitle3.text = result.desc

            Glide.with(crdview).load(result.ImageUrl).into(crdview)
        }
    }
}