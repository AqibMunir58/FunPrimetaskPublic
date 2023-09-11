package com.example.funprimetask.view.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.funprimetask.databinding.FragmentItemBinding


class ItemFragment : Fragment() {

    private var _binding  : FragmentItemBinding? = null
    val binding get() = _binding!!
    val TAG = "ItemFragment"
    private val args : ItemFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding  = FragmentItemBinding.inflate(layoutInflater)
        binding.share.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "Share")

       startActivity(Intent.createChooser(sharingIntent, "Share using"))
       }

        val item =  args.item
        binding.title.text = item.title
        Glide.with(requireContext()).load(item.thumbnail).into(binding.thambnail)



        return binding.root
    }
}