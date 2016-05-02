/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.pos.util;

import java.io.File;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

/**
 *
 * @author Sanjeewa;
 */
public class BarcodeGenerator {
    
    public boolean outputtingBarcodeAsPNG(String code, String imageName) throws BarcodeException {
        // get a Barcode from the BarcodeFactory
		Barcode barcode = BarcodeFactory.createCode128B(code);

        try {
            File Dir = new File("Barcode");

            // if the directory does not exist, create it
            if (!Dir.exists()) {
                try{
                    Dir.mkdir();
                } catch(SecurityException se){
                }
            }
            
            File f = new File("Barcode/"+imageName+".png");

            // Let the barcode image handler do the hard work
            BarcodeImageHandler.savePNG(barcode, f);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
