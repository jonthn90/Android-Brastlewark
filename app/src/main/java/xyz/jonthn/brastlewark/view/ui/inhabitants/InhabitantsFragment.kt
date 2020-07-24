package xyz.jonthn.brastlewark.view.ui.inhabitants

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import xyz.jonthn.brastlewark.R
import xyz.jonthn.brastlewark.common.EventObserver
import xyz.jonthn.brastlewark.databinding.FragmentInhabitantsBinding

class InhabitantsFragment : Fragment() {

    lateinit var mLoadingDialog: AlertDialog

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
            val action =
                InhabitantsFragmentDirections.actionInhabitantsFragmentToInhabitantDetailFragment(id)
            navController.navigate(action)
        })

        setupLoadingDialog()

        inhabitantsViewModel.loading.observe(viewLifecycleOwner, Observer {
            if (it) {
                mLoadingDialog.show()
            } else {
                if (mLoadingDialog.isShowing) mLoadingDialog.dismiss()
            }
        })

        binding.buttonSearch.setOnClickListener{
            inhabitantsViewModel.searchByName(binding.editText.text.toString())
            hideKeyboard()
        }

        binding.buttonClear.setOnClickListener{
            binding.editText.text.clear()
            inhabitantsViewModel.fetchData()
            hideKeyboard()
        }
    }

    private fun setupLoadingDialog() {
        val dialogBuilder = AlertDialog.Builder(requireActivity())
        val dialogView = layoutInflater.inflate(R.layout.animation_loading, null)
        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(false)
        mLoadingDialog = dialogBuilder.create()
        mLoadingDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
    }

    fun hideKeyboard() {
        val inputManager: InputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        try {
            inputManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, InputMethodManager.SHOW_FORCED)
        } catch (e : Exception){
            e.printStackTrace()
        }
    }
}