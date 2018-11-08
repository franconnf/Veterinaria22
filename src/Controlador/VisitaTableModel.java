/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import clasesprincipales.VisitaDeAtencion;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MrLyoto
 */
public class VisitaTableModel extends AbstractTableModel {

    ArrayList<VisitaDeAtencion> listaDeVisitas;

    public VisitaTableModel(ArrayList<VisitaDeAtencion> listaDeVisitas) {
        this.listaDeVisitas = listaDeVisitas;
    }

    public VisitaTableModel(VisitaDeAtencion visita) {
        this.listaDeVisitas = new ArrayList<>();
        listaDeVisitas.add(visita);
    }

    @Override
    public int getRowCount() {
        return listaDeVisitas.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VisitaDeAtencion row = listaDeVisitas.get(rowIndex);
        if(columnIndex == 0){
            return row.getIdVisita();
        }
        if(columnIndex == 1){
            return row.getIdMascota();
        }
        if(columnIndex == 2){
            return row.getIdMascota();
        }
        if(columnIndex == 3){
            return row.getFecha();
        }
        if(columnIndex == 4){
            return row.getPrecio();
        }
        return null;
    }

}
