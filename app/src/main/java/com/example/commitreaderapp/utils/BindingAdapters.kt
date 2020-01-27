package com.example.commitreaderapp.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.commitreaderapp.R


@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity = view.getParentActivity()
    if (parentActivity != null && visibility != null) {
        visibility.observe(parentActivity,
            Observer { value -> view.visibility = value ?: View.VISIBLE })
    }
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, imageUrl: String?) {
    Glide.with(imageView)
        .load(imageUrl)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .placeholder(R.mipmap.github_default_icon)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(12)))
        .into(imageView)

}



