package mx.marcrobito.gallery

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import mx.marcrobito.gallery.databinding.ItemImageBinding

class ImageItemRecyclerViewAdapter(private val values: List<Hit>, private val listener: ItemListener) : RecyclerView.Adapter<ImageItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ItemImageBinding, private val listener: ItemListener) : RecyclerView.ViewHolder(binding.root) {
        private val author = binding.author
        private val image = binding.imageView
        private val root = binding.root

        fun bind(hit:Hit){
            author.text = hit.user
            Glide.with(image).load(hit.previewURL).into(image)
            root.setOnClickListener {
                listener.onItemClicked(hit)
            }
        }
    }

}

interface ItemListener{
    fun onItemClicked(hit: Hit)
}