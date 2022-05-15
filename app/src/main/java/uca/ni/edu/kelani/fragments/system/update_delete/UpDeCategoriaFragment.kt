package uca.ni.edu.kelani.fragments.system.update_delete

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_up_categoria.*
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.bd.entidades.Categoria
import uca.ni.edu.kelani.bd.viewmodel.CategoriaViewModel

import uca.ni.edu.kelani.databinding.FragmentUpCategoriaBinding

class UpDeCategoriaFragment : Fragment () {

    // TODO: Rename and change types of parameters
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_up_categoria, container, false)
    }
}