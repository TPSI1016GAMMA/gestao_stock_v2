/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;
import model.*;
import static solidario_gamma_v2.MockupData.product;

/**
 *
 * @author Missy M, Migthy Arroz e Arkham
 */
public class Product_Controller {

    Scanner scan=new Scanner(System.in);
    
    public Product_Controller(){
    }

    public void criar_novo(int barcode) {
        
        String cat, subcat;
        int op=0;
        boolean existe; 
        
        Product produto = new Product(0, null, null,false, 0, 0); 
               
        existe=product.contains(produto.getBarcode()==barcode);
        if(existe==false){              
        
        switch(barcode){
            
            case 0: //TODO caso produto não tenha codigo de barras (criação manual de código de barras)
                    //criar função e passar como argumento?
                break;
            
            default:
                    produto.setBarcode(barcode);       
                    System.out.println("Indique os dados relativos ao novo produto.");
                    System.out.println("Designação do produto:");
                    produto.setNome(scan.nextLine()); 
                    produto.setId_produto(product.size());  
                    System.out.println("Seleccione a categoria de produto:");                    
                    Vector temp=new Vector(product.size(), 1);
                    for(int i=0; i<product.size(); i++){                     
                        if(temp.contains(product.get(i).getCat())==false) temp.add(product.get(i).getCat());}
                    for(int i=0; i<temp.capacity(); i++){
                        System.out.println((i+1) + " - " +temp.get(i));}
                    System.out.println("0 - Criar nova categoria de produto");
                    op=scan.nextInt();
                    if(op==0){
                        System.out.println("Indique o nome da nova categoria de produto");
                        cat=new Scanner(System.in).nextLine();
                        System.out.println("Indique o nome da nova sub-categoria de produto");
                        subcat=new Scanner(System.in).nextLine();
                        produto.setCat_subcat(cat, subcat);
                        System.out.println("Nova categoria "+ produto.getCat() + ", sub-categoria "+ produto.getCat_subcat()+ " criadas." );
                        System.out.flush();
                    }else{
                        cat=(String) temp.get(op-1);
                        System.out.println("Seleccione a sub-categoria de produto:"); 
                        Vector subtemp=new Vector(1, 1);                        
                         for(int i=0; i<product.size(); i++){                            
                            if((product.get(i).getCat()).equals(temp.get((op-1)))){
                            if(subtemp.contains(product.get(i).getCat_subcat())==false) subtemp.add(product.get(i).getCat_subcat());}}                 
                         for(int i=0; i<subtemp.capacity(); i++){
                            System.out.println((i+1) + " - " + subtemp.get(i));}                        
                        System.out.println("0 - Criar nova sub-categoria de produto");
                        op=scan.nextInt();
                        if (op!=0) {
                            subcat=(String) subtemp.get(op-1);
                        }else{
                            System.out.println("Indique o nome da nova sub-categoria de produto");
                            subcat=new Scanner(System.in).nextLine();}
                        
                        produto.setCat_subcat(cat, subcat);                   
                    }                                  
                    System.out.println("Indique o Stock minimo do produto:");
                    produto.setStock_minimo(scan.nextFloat()); 
                    product.add(produto);
            }
        }else{   
        System.out.println("Impossivel criar nova entrada\nProduto já existe na BD"); //TODO melhorar isto
        }
    }//Fecha metodo
}//Fecha Classe



