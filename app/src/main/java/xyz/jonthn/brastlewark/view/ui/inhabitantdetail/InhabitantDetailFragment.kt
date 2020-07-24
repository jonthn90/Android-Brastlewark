package xyz.jonthn.brastlewark.view.ui.inhabitantdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.jonthn90.gnomes.adapters.FriendsAdapter
import com.jonthn90.gnomes.adapters.ProfessionsAdapter
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.parameter.parametersOf
import xyz.jonthn.brastlewark.R
import xyz.jonthn.brastlewark.common.bindingInflate
import xyz.jonthn.brastlewark.databinding.FragmentInhabitantDetailBinding

class InhabitantDetailFragment : Fragment() {

    private var binding: FragmentInhabitantDetailBinding? = null
    private val args: InhabitantDetailFragmentArgs by navArgs()

    private val viewModel: InhabitantDetailViewModel by lifecycleScope.viewModel(this) {
        parametersOf(args.id)
    }

    private lateinit var professionsAdapter: ProfessionsAdapter

    private lateinit var friendsAdapter: FriendsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = container?.bindingInflate(R.layout.fragment_inhabitant_detail, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding?.apply {
            viewmodel = viewModel
            lifecycleOwner = this@InhabitantDetailFragment
        }

        friendsAdapter = FriendsAdapter()
        binding!!.recyclerViewFriends.adapter = friendsAdapter

        professionsAdapter = ProfessionsAdapter()
        binding!!.recyclerViewProfessions.adapter = professionsAdapter

    }
}