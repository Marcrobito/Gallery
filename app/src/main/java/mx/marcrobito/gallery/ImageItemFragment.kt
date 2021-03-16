package mx.marcrobito.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import mx.marcrobito.gallery.databinding.FragmentItemListBinding


class ImageItemFragment : Fragment(), ItemListener {


    private lateinit var binding: FragmentItemListBinding

    private lateinit var viewModel: HitsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentItemListBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[HitsViewModel::class.java]

        with(binding){
            list.layoutManager = LinearLayoutManager(context)

            viewModel.hits.observe(requireActivity()){
                list.adapter = ImageItemRecyclerViewAdapter(it, this@ImageItemFragment)
            }

            searchButton.setOnClickListener {
                viewModel.getHits(searchTerm.text.toString())
            }


            return root
        }

    }

    override fun onItemClicked(hit: Hit) {
        val bundle = Bundle()
        val detailParcelable = DetailParcelable(hit.id, hit.largeImageURL, hit.user)
        bundle.putParcelable("detail",detailParcelable)
        binding.root.findNavController().navigate(R.id.action_imageItemFragment_to_detailFragment,bundle)
    }


}