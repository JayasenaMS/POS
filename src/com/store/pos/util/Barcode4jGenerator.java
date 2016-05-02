/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.pos.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

/**
 *
 * @author Sanjeewa;
 */
public class Barcode4jGenerator {

    
    public boolean generateJPEG(String barcode, String imageName) {
       try {
            //Create the barcode bean
            Code39Bean bean = new Code39Bean();
            
            final int dpi = 150;
            
            //Configure the barcode generator
            bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); //makes the narrow bar 
                                                             //width exactly one pixel
            bean.setWideFactor(3);
            bean.doQuietZone(false);
            
            File Dir = new File("Barcode");

            // if the directory does not exist, create it
            if (!Dir.exists()) {
                
                try{
                    Dir.mkdir();
                } catch(SecurityException se){
                }
            }
            
            //Open output file
            File outputFile = new File("Barcode/"+imageName+".jpg");
            OutputStream out = new FileOutputStream(outputFile);
            try {
                //Set up the canvas provider for monochrome JPEG output 
                BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                        out, "image/jpeg", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);
            
                //Generate the barcode
                bean.generateBarcode(canvas, barcode);
            
                //Signal end of generation
                canvas.finish();
            } finally {
                out.close();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
