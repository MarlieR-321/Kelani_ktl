package uca.ni.edu.kelani.fragments.system.listar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.adapter.FacturaEncAdapter
import uca.ni.edu.kelani.bd.entidades.FacturaEnc
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaEnc
import uca.ni.edu.kelani.databinding.FragmentFacturacionBinding


class FacturacionFragment : Fragment() {
    private lateinit var binding:FragmentFacturacionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFacturacionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lista = listOf<vw_FacturaEnc>(
            vw_FacturaEnc(1,"02-02-2002",1,"Jose Pablo","2882-9332","En la esquina san miguel",2222332),
            vw_FacturaEnc(2,"02-02-2002",1,"Jose Rodrigo","3334-9332","En la esquina san miguel",4534),
            vw_FacturaEnc(3,"02-02-2002",1,"Jose Comal","2222-9332","En la esquina san miguel",9494),
            vw_FacturaEnc(4,"02-02-2002",1,"Jose Pha","2882-9332","En la esquina san miguel",5),
            vw_FacturaEnc(5,"02-02-2002",1,"Jose Pablo","2882-9332","En la esquina san miguel",65),
            vw_FacturaEnc(6,"02-02-2002",1,"Jose Pablo","2882-9332","En la esquina san miguel",20)
        )

        val adapter = FacturaEncAdapter(lista)
        val recyclerView = binding.rvFacturas

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)



        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addFacturaFragment)
        }
    }


}