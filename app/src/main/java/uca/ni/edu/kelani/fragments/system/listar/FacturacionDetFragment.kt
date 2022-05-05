package uca.ni.edu.kelani.fragments.system.listar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.adapter.FacturaDetAdapter
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaDet
import uca.ni.edu.kelani.databinding.FragmentFactutacionDetBinding

// TODO: Rename parameter arguments, choose names that match

class FacturacionDetFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var binding: FragmentFactutacionDetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFactutacionDetBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lista = listOf<vw_FacturaDet>(
            vw_FacturaDet(1,2,2,"Pastel de Zanahoria",12.43,1,222.2),
            vw_FacturaDet(2,2,2,"Pastel de Zanahoria",12.423,2,45.34),
            vw_FacturaDet(3,1,2,"Pastel de Chocolate",13.3,3,94.94),
            vw_FacturaDet(4,1,2,"Pastel de Chocolate",13.2,5,5.0),
            vw_FacturaDet(5,4,2,"Pastel de Chocolate",12.0,2,6.5),
            vw_FacturaDet(6,3,2,"Pastel de Chocolate",151.2,2,20.6)
        )

        val adapter = FacturaDetAdapter(lista)
        val recyclerView = binding.rvFacturas

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addFacturaDetFragment)
        }
    }
}