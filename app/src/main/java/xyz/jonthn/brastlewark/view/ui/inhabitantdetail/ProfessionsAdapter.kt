package com.jonthn90.gnomes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import xyz.jonthn.brastlewark.R
import xyz.jonthn.brastlewark.common.basicDiffUtil
import xyz.jonthn.brastlewark.common.bindingInflate
import xyz.jonthn.brastlewark.databinding.InhabitantsItemBinding
import xyz.jonthn.brastlewark.databinding.ProfessionsItemBinding
import xyz.jonthn.brastlewark.view.ui.inhabitants.InhabitantsAdapter
import xyz.jonthn.domain.Inhabitant

class ProfessionsAdapter() : RecyclerView.Adapter<ProfessionsAdapter.ViewHolder>() {

    var professions: List<String> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old == new }
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.bindingInflate(R.layout.professions_item, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBinding.textView.text = professions[position]
    }

    class ViewHolder(val dataBinding: ProfessionsItemBinding) :
        RecyclerView.ViewHolder(dataBinding.root)


    override fun getItemCount(): Int = professions.size

}