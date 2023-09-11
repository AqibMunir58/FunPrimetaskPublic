package com.example.funprimetask.view.ui

import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.funprimetask.adapters.HomeAdapter

import com.example.funprimetask.databinding.FragmentHomeBinding
import com.example.funprimetask.viewmodel.MainActivityViewModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    val binding get() = _binding!!
    lateinit var mainActivityViewModel: MainActivityViewModel
    val TAG = "HomeFragment"
    private var mInterstitialAd: InterstitialAd? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            requireContext(),
            "ca-app-pub-3940256099942544/1033173712",
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, adError?.toString())
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {

                    mInterstitialAd = interstitialAd
                }
            })
        setFullScreenAd()

        mainActivityViewModel.getUser()
        mainActivityViewModel.photosLiveData!!.observe(viewLifecycleOwner) {
            val linearLayoutManager = LinearLayoutManager(requireContext())
            binding.recyclerviewforphotos.layoutManager = linearLayoutManager
            binding.recyclerviewforphotos.setHasFixedSize(true)
            val adapter = HomeAdapter(it, object : HomeAdapter.RecyclerItemClick {
                override fun getItem(position: Int) {
                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(requireActivity())
                    }


                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToItemFragment(
                        it[position]
                    ))
                }

            })
            binding.recyclerviewforphotos.adapter = adapter
        }
        return binding.root
    }

    private fun setFullScreenAd() {
        mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdClicked() {

                Log.d(TAG, "Ad was clicked.")
            }

            override fun onAdDismissedFullScreenContent() {

                Log.d(TAG, "Ad dismissed fullscreen content.")
                mInterstitialAd = null
            }


            override fun onAdImpression() {

                Log.d(TAG, "Ad recorded an impression.")
            }

            override fun onAdShowedFullScreenContent() {

                Log.d(TAG, "Ad showed fullscreen content.")
            }
        }
    }

}