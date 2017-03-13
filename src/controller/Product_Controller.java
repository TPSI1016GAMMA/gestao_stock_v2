/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.Scanner;
import model.*;
import static solidario_gamma_v2.MockupData.product;

/**
 *
 * @author Missy M, Migthy Arroz e Arkham
 */
public class Product_Controller {
    
    Scanner scan=new Scanner(System.in);

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
                    System.out.println("Categoria de produto:");
                    //Categoria_produto.listar(); //TODO_1 algoritmo pesquisa um de cada e lista
                    System.out.println("0 - Criar nova categoria de produto");
                    op=scan.nextInt();
                    if(op==0){
                        System.out.println("Indique o nome da nova categoria de produto");
                        cat=scan.nextLine();
                        System.out.println("Indique o nome da nova sub-categoria de produto");
                        subcat=scan.nextLine();
                        produto.setCat_subcat(cat, subcat);
                        System.out.println("Nova categoria "+ produto.getCat() + ", sub-categoria "+ produto.getCat_subcat()+ " criadas." );
                        System.out.flush();
                    }else{
                    //TODO metodo de seleção com base no algorirmo todo_1
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



