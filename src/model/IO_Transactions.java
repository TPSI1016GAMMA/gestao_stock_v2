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
public class IO_Transactions {
    
    private int id_io;
    private String movimento;
    private Date data_mov;
    private HashMap <Product,Float> produtos_IO;
    private HashMap <Entity, Dummy_funcionario> from;
    private HashMap <Entity, Dummy_funcionario> to;

    public IO_Transactions(int id_io, String movimento, Date data_mov, HashMap<Product, Float> produtos_IO, HashMap<Entity, Dummy_funcionario> from, HashMap<Entity, Dummy_funcionario> to) {
        this.id_io = id_io;
        this.movimento = movimento;
        this.data_mov = data_mov;
        this.produtos_IO = produtos_IO;
        this.from = from;
        this.to = to;
    }

    public int getId_io() {
        return id_io;
    }

    public void setId_io(int id_io) {
        this.id_io = id_io;
    }

    public String getMovimento() {
        return movimento;
    }

    public void setMovimento(String movimento) {
        this.movimento = movimento;
    }

    public Date getData_mov() {
        return data_mov;
    }

    public void setData_mov(Date data_mov) {
        this.data_mov = data_mov;
    }

    public HashMap <Product,Float> getProdutos_IO() {
        return produtos_IO;
    }

    public void setProdutos_IO(HashMap <Product,Float> produtos_IO) {
        this.produtos_IO = produtos_IO;
    }

    public HashMap <Entity, Dummy_funcionario> getFrom() {
        return from;
    }

    public void setFrom(HashMap <Entity, Dummy_funcionario> from) {
        this.from = from;
    }

    public HashMap <Entity, Dummy_funcionario> getTo() {
        return to;
    }

    public void setTo(HashMap <Entity, Dummy_funcionario> to) {
        this.to = to;
    }
    

   
    
}

