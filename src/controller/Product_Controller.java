/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;
import model.*;
import static solidario_gamma_v2.MockupData.product;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

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
        
        Product produto = new Product(0, null, null,false, barcode,null, 0);                
        existe=product.contains(produto.getBarcode()==barcode);
        
        if(existe==false || barcode ==0){       
                         
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
                produto.setCat_subcat(cat, subcat);
            }else{
                cat=(String) temp.get(op-1);
                System.out.println("Seleccione a sub-categoria de produto:"); 
                temp.clear();
                for(int i=0; i<product.size(); i++){                            
                    if((product.get(i).getCat()).equals(cat)){
                        if(temp.contains(product.get(i).getCat_subcat())==false) temp.add(product.get(i).getCat_subcat());}}                 
                    for(int i=0; i<temp.capacity(); i++){
                        System.out.println((i+1) + " - " + temp.get(i));}                        
                System.out.println("0 - Criar nova sub-categoria de produto");
                op=scan.nextInt();
                if (op!=0) {
                    subcat=(String) temp.get(op-1);
                }else{
                    System.out.println("Indique o nome da nova sub-categoria de produto");
                    subcat=new Scanner(System.in).nextLine();}                        
                produto.setCat_subcat(cat, subcat);} 
            
            if(barcode==0){
                 try {
                    criar_barcode(produto.getNome(),produto.getCat() );
                } catch (IOException ex) {
                    Logger.getLogger(Product_Controller.class.getName()).log(Level.SEVERE, null, ex);} 
                criar_qrcode(produto.getNome(),produto.getCat() );}
            
            System.out.println("Indique o Stock minimo do produto:");
            produto.setStock_minimo(scan.nextFloat());
                
            product.add(produto);            
        }else{   
        System.out.println("Impossivel criar nova entrada\nProduto já existe na BD");}
    }//Fecha metodo

 public void search_produto(ArrayList<Product> p){
       
        //TODO - Fazer return int 
        
        //-------------------------
        
       String name_temp;
       System.out.println("Introduza o nome o produto que quer pesquisar");
       name_temp=new Scanner(System.in).nextLine();
       
       for(int i=0;i<p.size();i++){
           
           if(name_temp.equals(p.get(i).getNome())){
               
               System.out.println("//-------------------------------//");
               System.out.println("ID           - "+p.get(i).getId_produto());
               System.out.println("NOME         - "+p.get(i).getNome());
               System.out.println("Categoria    - "+p.get(i).getCat());
               System.out.println("Stock        - "+p.get(i).getStock_minimo());
               //TODO - Em caso ambiente grafico mostrar a imagem do qr do proprio produto
               return ;
           }
       }
       
      System.out.println("Não foi encontrado o produto desejado");}
       




        
    public void criar_barcode(String nome_produto, String cat_produto) throws FileNotFoundException, IOException{        	
       
        Code39Bean bean = new Code39Bean();
        final int dpi = 150; 
        //-----------Caminho Geral-----------
        String path="files/cod_barra/"+cat_produto+"/";
        
        bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); 
        bean.setWideFactor(3);
        bean.doQuietZone(false);
    
        File outputFile = new File(path+nome_produto+".png");
        
        outputFile.getParentFile().mkdirs(); //----Cria as pastas
        OutputStream codigo_barras = new FileOutputStream(outputFile);
        
    try {
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(codigo_barras, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

        bean.generateBarcode(canvas, nome_produto);

        canvas.finish();
        
    } finally {
        codigo_barras.close();}
    }//Fecha metodo
    
    
     public void criar_qrcode(String nome_produto, String cat_produto){
         
         	String myCodeText = nome_produto; //acrecentar todos os detalhes que queremos ter de item de imobilizado
		String path = cat_produto+"/";
		int size = 250;
                String fileType = "png";
		File myFile = new File(path+nome_produto+".png");
                myFile.getParentFile().mkdirs();
                
		try {
			
			Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");			
			
			hintMap.put(EncodeHintType.MARGIN, 1); /* default = 4 */
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
 
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix byteMatrix = qrCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, size,
					size, hintMap);
			int width = byteMatrix.getWidth();
			BufferedImage image = new BufferedImage(width, width,
					BufferedImage.TYPE_INT_RGB);
			image.createGraphics();
 
			Graphics2D graphics = (Graphics2D) image.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, width, width);
			graphics.setColor(Color.BLACK);
 
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < width; j++) {
					if (byteMatrix.get(i, j)) {
						graphics.fillRect(i, j, 1, 1);}}}
			ImageIO.write(image, fileType, myFile);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n\nAVISO: O QR Code gerado deve ser impresso e colado ao novo item de imobilizado");
	}
        
    
}//Fecha Classe


