package uca.ni.edu.kelani.fragments.system.update_delete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.databinding.FragmentAgregarUnidadBinding

class UpDeUnidadMedidaFragment : Fragment() {
    private lateinit var binding: FragmentAgregarUnidadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_up_unidadmedida, container, false)
    }
}