/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Missy M, Migthy Arroz e Arkham
 */
public class Warehouse extends Entity {
    
    private int id_armazem;
    private String categoria;
    private String nome_armazem;
    private String local;
    private Dummy_funcionario responsavel_de_armazem;
    private String estado;

    public Warehouse(int id_armazem, String categoria, String nome_armazem, String local, Dummy_funcionario responsavel_de_armazem, String estado, int id, String name) {
        super(id, name);
        this.id_armazem = id_armazem;
        this.categoria = categoria;
        this.nome_armazem = nome_armazem;
        this.local = local;
        this.responsavel_de_armazem = responsavel_de_armazem;
        this.estado = estado;
    }

    public int getId_armazem() {
        return id_armazem;
    }

    public void setId_armazem(int id_armazem) {
        this.id_armazem = id_armazem;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome_armazem() {
        return nome_armazem;
    }

    public void setNome_armazem(String nome_armazem) {
        this.nome_armazem = nome_armazem;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Dummy_funcionario getResponsavel_de_armazem() {
        return responsavel_de_armazem;
    }

    public void setResponsavel_de_armazem(Dummy_funcionario responsavel_de_armazem) {
        this.responsavel_de_armazem = responsavel_de_armazem;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  
    
    
}
