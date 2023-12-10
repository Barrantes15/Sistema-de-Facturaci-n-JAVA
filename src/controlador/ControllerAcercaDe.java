/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.frmAcercaDe;

/**
 *
 * @author Willi
 */
public class ControllerAcercaDe implements ActionListener {

    frmAcercaDe vistaAcercaDe = new frmAcercaDe();

    public ControllerAcercaDe(frmAcercaDe frm) {
        this.vistaAcercaDe = frm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void iniciar() {

    }

}
