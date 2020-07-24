package xyz.jonthn.brastlewark.view.ui.inhabitants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import xyz.jonthn.brastlewark.databinding.FragmentInhabitantsBinding

class InhabitantsFragment : Fragment() {

    private lateinit var binding: FragmentInhabitantsBinding

    private val inhabitantsViewModel: InhabitantsViewModel by lifecycleScope.viewModel(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInhabitantsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inhabitantsViewModel.fetchData()


        /*
        binding.imageView.load("https://www.publicdomainpictures.net/pictures/10000/nahled/thinking-monkey-11282237747K8xB.jpg")
        Glide.with(this).load(url).into(binding.imageView);
        Picasso.get().load(url).into(binding.imageView)
        val url = "http://www.publicdomainpictures.net/pictures/10000/nahled/thinking-monkey-11282237747K8xB.jpg"
        val uri = Uri.parse(url)
        binding.draweeView.setImageURI(uri, null)
        http://www.publicdomainpictures.net/pictures/10000/nahled/thinking-monkey-11282237747K8xB.jpg
        https://square.github.io/picasso/static/sample.png
         */

    }
}