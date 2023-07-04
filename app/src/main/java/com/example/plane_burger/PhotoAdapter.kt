import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.plane_burger.Photo
import com.example.plane_burger.R
import com.example.plane_burger.databinding.PictureWithTextBinding

class PhotoAdapter(
    private var itemClickListener: OnItemClickListener
):
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    var photos: MutableList<Photo> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.picture_with_text, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position])

        holder.setOnClickListener(
            itemClickListener,
            photos[holder.adapterPosition]
        )
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var binding: PictureWithTextBinding = PictureWithTextBinding.bind(itemView)

        fun bind(photo: Photo) {
            binding.title.text = photo.title
            binding.year.text = photo.year
            binding.image.setImageResource(photo.imageRes)
        }

        fun setOnClickListener(listener: OnItemClickListener, element: Photo) {
            this.itemView.setOnClickListener {
                val adapterPosition = adapterPosition
                if (adapterPosition != RecyclerView.NO_POSITION)
                    listener.onItemClick(binding, element)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(itemBinding: PictureWithTextBinding, element: Photo)
    }
}
