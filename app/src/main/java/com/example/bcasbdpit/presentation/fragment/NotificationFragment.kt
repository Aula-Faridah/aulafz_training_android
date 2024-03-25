package com.example.bcasbdpit.presentation.fragment

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.bcasbdpit.R
import com.example.bcasbdpit.base.BaseFragment
import com.example.bcasbdpit.databinding.FragmentNotificationBinding

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun setUpView() {
    }

    // For a simple view:
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return FragmentNotificationBinding.inflate(inflater,container,false)
//    }
//        ImageView imageView = (ImageView) findViewById(R.id.ivFruit);
//
//        Glide.with(this).load("https://goo.gl/gEgYUd").into(imageView);
//    }
//
//// For a simple image list:
//    override fun View View getView(int position, View recycled, ViewGroup container) {
//        final ImageView myImageView;
//        if (recycled == null) {
//            myImageView = (ImageView) inflater.inflate(R.layout.fragment_notification, container, false);
//        } else {
//            myImageView = (ImageView) recycled;
//        }
//
//        String url = myUrls.get(position);
//
//        Glide
//            .with(myFragment)
//            .load(url)
//            .centerCrop()
//            .placeholder(R.drawable.loading_spinner)
//            .into(myImageView);
//
//        return myImageView;
//    }

}