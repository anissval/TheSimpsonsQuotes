package com.valdiviezo.anahi.thesimpsonsquotes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.valdiviezo.anahi.thesimpsonsquotes.model.TheSimpsonsQuote
import kotlinx.android.synthetic.main.thesimpsonsquote_item.view.*

/**
 * @author Anahi Valdiviezo
 */
class TheSimpsonsQuoteAdapter (val quoteList : List<TheSimpsonsQuote>?) : RecyclerView.Adapter<TheSimpsonsQuoteAdapter.TheSimpsonsQuoteViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheSimpsonsQuoteViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        var view = inflater.inflate(R.layout.thesimpsonsquote_item, parent,false)
        return TheSimpsonsQuoteViewHolder(view)    }

    override fun onBindViewHolder(holder: TheSimpsonsQuoteViewHolder, position: Int) {
        (holder as TheSimpsonsQuoteViewHolder).bind(quoteList!![position])
    }

    override fun getItemCount(): Int = quoteList?.size!!

    class TheSimpsonsQuoteViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bind(quote : TheSimpsonsQuote) {
            itemView.tv_character.text = quote.character
            itemView.tv_quote.text = quote.quote
            Picasso.get().load(quote.image).resize(120, 120).into(itemView.iv_character);
        }

    }
}