package mx.marcrobito.gallery

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import mx.marcrobito.gallery.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var binding:FragmentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = FragmentDetailBinding.inflate(inflater, container, false)

        arguments?.let{
            val detail =   it.getParcelable<DetailParcelable>("detail")
            Log.d("TAG", detail.toString())
            with(binding){
                author.text = detail?.user
                Glide.with(this@DetailFragment).load(detail?.largeImageURL).into(imageView)
            }
        }

        return binding.root

    }

    companion object {

        @JvmStatic
        fun newInstance() = DetailFragment()
    }
}