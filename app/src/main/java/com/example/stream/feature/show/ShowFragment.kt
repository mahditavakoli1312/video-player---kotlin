package com.example.stream.feature.show

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.stream.databinding.FragmentShowBinding
import com.example.stream.feature.show.di.DaggerShowComponent
import com.example.stream.feature.show.ui.ShowViewModel
import javax.inject.Inject


class ShowFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel by viewModels<ShowViewModel> { factory }

    private lateinit var binding: FragmentShowBinding
    private var playbackPos = 0
    private val url =
        "https://hajifirouz9.cdn.asset.aparat.com/aparat-video/49713c73d4684f173db27d1ffc5d700449416021-360p.mp4?wmsAuthSign=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6IjQ5OWVmMWZiMzczNzI0NTI2YmFhZmI0OWEzNmQ0YzIwIiwiZXhwIjoxNjcxOTgxNDE1LCJpc3MiOiJTYWJhIElkZWEgR1NJRyJ9.1r6-Fy5WmvS8pzX1pGsiQVSGXJGlCSRraN10yfepWQM"
    private lateinit var mediaCon: MediaController

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerShowComponent.factory().create(
        ).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        lifecycleScope.launchWhenStarted {
            viewModel.videoDetails.collect {
                binding.videoDetails = it
            }
        }

        mediaCon = MediaController(requireContext())

        binding.vvVideoShow.setOnPreparedListener {
            mediaCon.setAnchorView(binding.videoContainer)
            binding.vvVideoShow.setMediaController(mediaCon)
            binding.vvVideoShow.seekTo(playbackPos)
            binding.vvVideoShow.start()
        }
        binding.vvVideoShow.setOnInfoListener { _, what, _ ->
            if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                binding.progressBar2.visibility = View.INVISIBLE
            true
        }
    }

    override fun onStart() {
        super.onStart()
        val uri = Uri.parse(this.url)
        binding.vvVideoShow.setVideoURI(uri)
        binding.progressBar2.visibility = View.VISIBLE

    }

    override fun onPause() {
        super.onPause()
        binding.vvVideoShow.pause()
        playbackPos = binding.vvVideoShow.currentPosition
    }

    override fun onStop() {
        binding.vvVideoShow.stopPlayback()
        super.onStop()
    }
}