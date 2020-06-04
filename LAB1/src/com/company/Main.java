/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tieuminh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++) {
            if(args[i].equals("-r")) {
                System.out.println("Read file " + args[i+1] );
                i++;
            } else if(args[i].equals("-s")) {
                System.out.println("Save file " + args[i+1] );
                i++;
            }
        }
        // TODO code application logic here

    }
    
}
