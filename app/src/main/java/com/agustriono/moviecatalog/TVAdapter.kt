package com.agustriono.moviecatalog

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agustriono.moviecatalog.models.TV
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.tv_item.view.*

class TVAdapter(
    private val tvs : List<TV>
) : RecyclerView.Adapter<TVAdapter.TVViewHolder>() {

    class TVViewHolder (view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindTV(tv: TV){
            itemView.tv_title.text = tv.title
            itemView.tv_overview.text = tv.overview
            Glide.with(itemView).load(IMAGE_BASE + tv.poster).into(itemView.tv_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVAdapter.TVViewHolder {
        return TVAdapter.TVViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.tv_item, parent, false)
        )
    }

    override fun getItemCount(): Int = tvs.size

    override fun onBindViewHolder(holder: TVAdapter.TVViewHolder, position: Int) {
        val tv = tvs[position]
        holder.bindTV(tvs.get(position))

        holder.itemView.setOnClickListener {
            moveToTvSDetail(tv, it)
        }
    }

    private fun moveToTvSDetail(tv: TV, it: View) {
        val detailTvsIntent = Intent(it.context, DetailTVActivity::class.java)
        detailTvsIntent.putExtra(DetailTVActivity.EXTRA_TvS, tv)
        it.context.startActivity(detailTvsIntent)

    }
}