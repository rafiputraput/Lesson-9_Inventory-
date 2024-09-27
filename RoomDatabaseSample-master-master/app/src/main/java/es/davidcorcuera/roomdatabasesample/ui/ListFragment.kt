package es.davidcorcuera.roomdatabasesample.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import es.davidcorcuera.roomdatabasesample.R
import es.davidcorcuera.roomdatabasesample.adapter.MyListener
import es.davidcorcuera.roomdatabasesample.adapter.UserAdapter
import es.davidcorcuera.roomdatabasesample.databinding.FragmentListBinding
import es.davidcorcuera.roomdatabasesample.viewmodel.UserViewModel

class ListFragment : Fragment() {

    // get or instantiate viewmodel (shared between activity and fragments)
    private val userViewModel: UserViewModel by activityViewModels()

    private lateinit var binding: FragmentListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

       setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater)

        val adapter = UserAdapter(MyListener { user -> userViewModel.deleteUser(user) })
        binding.recyclerview.adapter = adapter

        userViewModel.mAllUsers.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_delete -> {
                Toast.makeText(activity,"Clearing data...", Toast.LENGTH_LONG).show()
                userViewModel.deleteAllUsers()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}