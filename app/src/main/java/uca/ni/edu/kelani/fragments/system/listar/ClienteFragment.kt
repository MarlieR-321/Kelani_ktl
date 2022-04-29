package uca.ni.edu.kelani.fragments.system.listar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uca.ni.edu.kelani.R
import uca.ni.edu.kelani.adapter.ClienteAdapter
import uca.ni.edu.kelani.adapter.FacturaEncAdapter
import uca.ni.edu.kelani.bd.entidades.Cliente
import uca.ni.edu.kelani.bd.entidades.views.vw_FacturaEnc
import uca.ni.edu.kelani.databinding.FragmentClienteBinding


class ClienteFragment : Fragment() {
    private  lateinit var  binding: FragmentClienteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentClienteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lista = listOf<Cliente>(
            Cliente(1,"Gerald","Diaz","2882-9332","001-060573-2224D",true,"En la esquina san Miguel"),
            Cliente(2,"Lucas","Ortero","5550-1425","001-220265-0068H",true,"En la esquina santo Tomas"),
            Cliente(3,"Jose","Pablo","8216-4545","451-020299-1008T",true,"En la esquina san Agustin"),
            Cliente(4,"Paula","Betrol","8888-0049","284-16096-0000A",true,"En la esquina san Carlos"),
            Cliente(5,"William","Rodriguez","7955-6698","562-251282-0001M",true,"En la esquina san Petesburgo"),
            Cliente(6,"Pedro","Olivares","7788-2200","001-08077-0024M",true,"En la esquina san Dionicio")
        )

        val adapter = ClienteAdapter(lista)
        val recyclerView = binding.rvClientes

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addCliente)
        }
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
    
}