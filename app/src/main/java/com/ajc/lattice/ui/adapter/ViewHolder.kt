package com.ajc.lattice.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ajc.lattice.model.remote.Article
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class ViewHolder(itemView: View, private val onClick: OnClick) : RecyclerView.ViewHolder(itemView) {

    fun setData(result: Article) {

        itemView.apply {
            CardView1.setOnClickListener {
                onClick.setOnClick(result)
            }

            tvDate1.text = result.publishedAt
            tvTitle1.text = result.title
            tvTitle3.text = result.description

            Glide.with(crdview).load(result.url).into(crdview)
        }
    }
}