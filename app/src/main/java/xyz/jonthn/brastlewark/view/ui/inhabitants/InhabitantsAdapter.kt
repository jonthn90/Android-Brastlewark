package xyz.jonthn.brastlewark.view.ui.inhabitants

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import xyz.jonthn.brastlewark.R
import xyz.jonthn.brastlewark.common.basicDiffUtil
import xyz.jonthn.brastlewark.common.bindingInflate
import xyz.jonthn.brastlewark.databinding.InhabitantsItemBinding
import xyz.jonthn.domain.Inhabitant

class InhabitantsAdapter(
    private val listener: (Inhabitant) -> Unit
) : RecyclerView.Adapter<InhabitantsAdapter.ViewHolder>() {

    var inhabitants: List<Inhabitant> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.bindingInflate(R.layout.inhabitants_item, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val inhabitant = inhabitants[position]
        holder.dataBinding.inhabitant = inhabitant
        holder.itemView.setOnClickListener { listener(inhabitant) }
    }

    override fun getItemCount(): Int = inhabitants.size


    class ViewHolder(val dataBinding: InhabitantsItemBinding) :
        RecyclerView.ViewHolder(dataBinding.root)
}