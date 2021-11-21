package com.example.aulalodjinha.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aulalodjinha.databinding.FragmentItemDetailBinding
import com.example.aulalodjinha.ui.NavigationDelegate
import coil.load
import com.example.aulalodjinha.R
import com.example.aulalodjinha.utils.DialogUtils


class ItemDetailFragment : Fragment() {

    private var _binding: FragmentItemDetailBinding? = null
    private val binding: FragmentItemDetailBinding get() = _binding!!

    private val args: ItemDetailFragmentArgs by lazy {
        ItemDetailFragmentArgs.fromBundle(requireArguments())
    }

    private var listener: NavigationDelegate? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationDelegate) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        _binding = FragmentItemDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener?.setToolbarTitle(args.title)

        _binding?.productCategory?.text = args.tvProductCategory
        _binding?.productName?.text = args.tvProdcutName
        _binding?.porPriceProduct?.text = "Por ${args.tvProductPrice2}"
        _binding?.dePriceProduct?.text = "De ${args.tvProductPriceFrom2}"
        _binding?.descricaProduto?.text = args.tvProductDescription

        _binding?.imageProduct?.apply {
            load(args.urlImagem) {
                crossfade(true)
                placeholder(R.drawable.ic_info)
                error(R.drawable.ic_info)

                listener(onError = {request, throwable ->
                    DialogUtils.showDialog(context, getString(R.string.erro_loading_image)) {}
                })
            }
        }

        _binding?.reserv?.setOnClickListener {
            DialogUtils.showDialog(context, getString(R.string.reseverd_product)) {}
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}