/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Missy M, Migthy Arroz e Arkham
 */
public class Product {
    
    private int id_produto;
    private String nome;
    private HashMap <String, String> cat_subcat; 
    private boolean estado_produto;
    private int barcode;
    private float stock_minimo;

    public Product(int id_produto, String nome, HashMap<String, String> cat_subcat, boolean estado_produto, int barcode, float stock_minimo) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.cat_subcat = new HashMap<>();
        this.estado_produto = estado_produto;
        this.barcode = barcode;
        this.stock_minimo = stock_minimo;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

     public HashMap <String, String> getCat() {
        Set keyset=cat_subcat.keySet();
        return (HashMap<String, String>) cat_subcat.keySet(); 
    }

    public HashMap <String, String> getCat_subcat() {
        return (HashMap<String, String>) cat_subcat.values(); 
    }

    public void setCat_subcat(String cat, String subcat) {
        this.cat_subcat.put(cat, subcat);
    }

    public boolean isEstado_produto() {
        return estado_produto;
    }

    public void setEstado_produto(boolean estado_produto) {
        this.estado_produto = estado_produto;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public float getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(float stock_minimo) {
        this.stock_minimo = stock_minimo;
    }



   

}