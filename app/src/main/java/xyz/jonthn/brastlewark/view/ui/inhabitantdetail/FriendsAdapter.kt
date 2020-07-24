package com.jonthn90.gnomes.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import xyz.jonthn.brastlewark.R
import xyz.jonthn.brastlewark.common.basicDiffUtil
import xyz.jonthn.brastlewark.common.bindingInflate
import xyz.jonthn.brastlewark.databinding.FriendsItemBinding

class FriendsAdapter() : RecyclerView.Adapter<FriendsAdapter.ViewHolder>() {

    var friends: List<String> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old == new }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.bindingInflate(R.layout.friends_item, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBinding.textView.text = friends[position]
    }

    class ViewHolder(val dataBinding: FriendsItemBinding) :
        RecyclerView.ViewHolder(dataBinding.root)

    override fun getItemCount(): Int = friends.size
}