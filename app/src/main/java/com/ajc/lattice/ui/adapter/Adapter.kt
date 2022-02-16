package com.ajc.lattice.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ajc.lattice.R
import androidx.recyclerview.widget.DiffUtil
import com.ajc.lattice.model.remote.Article
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*


class Adapter(private val onClickMovie: OnClick) :
    PagingDataAdapter<Article, Adapter.MovieViewHolder>(diffCallback = diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MovieViewHolder(view, onClickMovie)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val resultsDTO = getItem(position)
        holder.setData(resultsDTO!!)
    }

    class MovieViewHolder(private val view: View, private val onClickMovie: OnClick) :
        RecyclerView.ViewHolder(view) {

        fun setData(resultsDTO: Article) {
            view.apply {
                CardView1.setOnClickListener {
                    onClickMovie.setOnClick(resultsDTO)
                }

                tvDate1.text = resultsDTO.publishedAt
                tvTitle1.text = resultsDTO.title
                tvTitle3.text = resultsDTO.description

                Glide.with(crdview).load(resultsDTO.urlToImage).into(crdview)
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Article, newItem: Article) =
                oldItem == newItem
        }
    }


}