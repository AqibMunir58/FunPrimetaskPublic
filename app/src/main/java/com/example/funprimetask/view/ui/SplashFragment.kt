package com.example.funprimetask.view.ui

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.funprimetask.R
import com.example.funprimetask.databinding.FragmentSplashBinding
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions


class SplashFragment : Fragment() {
    private var _binding  : FragmentSplashBinding? = null
    val binding get() = _binding!!
    private val TAG = "SplashFragment"
    lateinit var adLoader : AdLoader


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding  = FragmentSplashBinding.inflate(layoutInflater)
        adLoader = AdLoader.Builder(requireActivity(), "ca-app-pub-3940256099942544/2247696110")
            .forNativeAd { ad : NativeAd ->
                if (adLoader.isLoading) {
                    val styles =
                        NativeTemplateStyle.Builder().build()
                    val template: TemplateView = binding.myTemplate
                    template.setStyles(styles)
                    template.setNativeAd(ad)

                } else {

                }
            }
            .withAdListener(object : AdListener() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, "onAdFailedToLoad: " )
                }
            })
            .withNativeAdOptions(
                NativeAdOptions.Builder()

                .build())
            .build()
        adLoader.loadAd(AdRequest.Builder().build())



        Handler().postDelayed(object : Runnable{
            override fun run() {
                findNavController().navigate(R.id.homeFragment)
            }

        },5000)

        return binding.root
    }


}