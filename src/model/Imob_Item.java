/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author Missy M, Migthy Arroz e Arkham
 */
public class Imob_Item extends Product {
    
    private int qr_code;
    private String local;
    private String sala;

    public Imob_Item(int qr_code, String local, String sala, int id_produto, String nome, HashMap<String, String> cat_subcat, boolean estado_produto, int barcode, String manualBarcode, float stock_minimo) {
        super(id_produto, nome, cat_subcat, estado_produto, barcode, manualBarcode, stock_minimo);
        this.qr_code = qr_code;
        this.local = local;
        this.sala = sala;
    }

    public int getQr_code() {
        return qr_code;
    }

    public void setQr_code(int qr_code) {
        this.qr_code = qr_code;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
    

}