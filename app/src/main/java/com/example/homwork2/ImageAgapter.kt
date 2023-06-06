package com.example.homwork2

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import com.example.homwork2.mod.Photo

class  ImageAdapter(
    private val list: ArrayList<Photo>,
    private val clickListener: (Photo) -> Unit,
    private val deleteItem: (Photo) -> Unit,
) : Adapter<ImageAdapter.ImageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ItemImageBinding.inflate( LayoutInflater.from(parent.context),

            parent,
            false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ImageViewHolder(private var binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Photo) {
            binding.vBlack.isVisible = image.isSelected

            Glide.with(itemView.context).load(image.photo).into(binding.ivImage)

            itemView.setOnClickListener {
                if (image.isSelected) {
                    deleteItem(image)
                    image.isSelected = false
                    notifyItemChanged(adapterPosition)
                } else {
                    clickListener(image)
                    image.isSelected = true
                    notifyItemChanged(adapterPosition)
                }
            }
        }
    }
}

