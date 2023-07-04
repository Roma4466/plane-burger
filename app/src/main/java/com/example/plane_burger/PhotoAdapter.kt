import android.annotation.SuppressLint
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.plane_burger.Photo
import com.example.plane_burger.R
import com.example.plane_burger.databinding.PictureWithTextBinding
import com.example.plane_burger.getPhotoFromPosition

class PhotoAdapter(
    private val resources: Resources,
    private var itemClickListener: OnItemClickListener
):
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    // its positions in data.xml arrays
    var photoPostions: MutableList<Int> = mutableListOf()
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
        holder.bind(photoPostions[position])

        holder.setOnClickListener(
            itemClickListener,
            photoPostions[holder.adapterPosition]
        )
    }

    override fun getItemCount(): Int {
        return photoPostions.size
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var binding: PictureWithTextBinding = PictureWithTextBinding.bind(itemView)

        fun bind(i: Int) {
            binding.title.text = getPhotoFromPosition(resources, i).title
            binding.year.text = getPhotoFromPosition(resources, i).year
            binding.image.setImageResource(getPhotoFromPosition(resources, i).imageRes)
        }
        fun setOnClickListener(listener: OnItemClickListener, i: Int) {
            this.itemView.setOnClickListener {
                val adapterPosition = adapterPosition
                if (adapterPosition != RecyclerView.NO_POSITION)
                    listener.onItemClick(binding, i)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(itemBinding: PictureWithTextBinding, element: Int)
    }
}
