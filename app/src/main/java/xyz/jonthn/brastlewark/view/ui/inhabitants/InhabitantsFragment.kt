package xyz.jonthn.brastlewark.view.ui.inhabitants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import xyz.jonthn.brastlewark.common.EventObserver
import xyz.jonthn.brastlewark.databinding.FragmentInhabitantsBinding

class InhabitantsFragment : Fragment() {

    private lateinit var binding: FragmentInhabitantsBinding

    private val inhabitantsViewModel: InhabitantsViewModel by lifecycleScope.viewModel(this)

    private lateinit var adapter: InhabitantsAdapter

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInhabitantsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        binding.apply {
            viewmodel = inhabitantsViewModel
            lifecycleOwner = this@InhabitantsFragment
        }

        adapter = InhabitantsAdapter(inhabitantsViewModel::onInhabitantClicked)
        binding.recyclerViewInhabitants.adapter = adapter

        inhabitantsViewModel.navigateToInhabitant.observe(viewLifecycleOwner, EventObserver { id ->
            val action = InhabitantsFragmentDirections.actionInhabitantsFragmentToInhabitantDetailFragment(id)
            navController.navigate(action)
        })
    }
}