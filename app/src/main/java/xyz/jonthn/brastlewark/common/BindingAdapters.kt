package xyz.jonthn.brastlewark.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.jonthn90.gnomes.adapters.FriendsAdapter
import com.jonthn90.gnomes.adapters.ProfessionsAdapter
import timber.log.Timber
import xyz.jonthn.brastlewark.common.loadUrl
import xyz.jonthn.brastlewark.view.ui.inhabitants.InhabitantsAdapter
import xyz.jonthn.domain.Inhabitant

@BindingAdapter("items")
fun RecyclerView.setItems(inhabitants: List<Inhabitant>?) {
    (adapter as? InhabitantsAdapter)?.let {
        it.inhabitants = inhabitants ?: emptyList()
        Timber.d("$inhabitants")
    }
}

@BindingAdapter("professions")
fun RecyclerView.setProfessions(professions: List<String>?) {
    (adapter as? ProfessionsAdapter)?.let {
        it.professions = professions ?: emptyList()
        Timber.d("$professions")
    }
}

@BindingAdapter("friends")
fun RecyclerView.setFriends(friends: List<String>?) {
    (adapter as? FriendsAdapter)?.let {
        it.friends = friends ?: emptyList()
        Timber.d("$friends")
    }
}

@BindingAdapter("urlCover")
fun SimpleDraweeView.bindUrlCover(url: String?) {
    if (url != null) loadUrl(url)
}