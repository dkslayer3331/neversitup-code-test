package com.dazai.neversitupcodetest.presentation.adapters

import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dazai.neversitupcodetest.databinding.ItemHistoryBinding
import com.dazai.neversitupcodetest.domain.models.History

class HistoryAdapter : ListAdapter<History, HistoryAdapter.HistoryViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        Log.d("createVH", "get called")
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        with(holder) {
            with(binding) {
                with(getItem(position)) {
                    tvDate.text = updatedISO
                    tvEURLabel.text = eur.code
                    tvEURRate.text =
                        HtmlCompat.fromHtml(eur.rate, HtmlCompat.FROM_HTML_MODE_COMPACT)
                    tvUSDLabel.text = usd.code
                    tvUSDrate.text =
                        HtmlCompat.fromHtml(usd.rate, HtmlCompat.FROM_HTML_MODE_COMPACT)
                    tvGBPlabel.text = gbp.code
                    tvGBPRate.text =
                        HtmlCompat.fromHtml(gbp.rate, HtmlCompat.FROM_HTML_MODE_COMPACT)
                }
            }
        }
    }

    class HistoryViewHolder(val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            Log.d("viewHolder", "init")
        }
    }

}

val diffUtil = object : DiffUtil.ItemCallback<History>() {
    override fun areItemsTheSame(oldItem: History, newItem: History): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: History, newItem: History): Boolean {
        return oldItem.id == newItem.id
    }
}