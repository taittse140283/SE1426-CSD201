/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Admin
 */
public class CLI {
    public void parsingArguments(String[] args){
        PriorityQueue queue = new PriorityQueue();
        try {
            if(args[0].equals("-r"))
            {
                queue=FileIO.getFile(args[1]);
                if(args[2].equals("-s"))
                {
                    if(args.length>4) {
                        if (args[4].equals("-a")) { //add new entry
                            try {
                                Node<Entry> player = new Node<>();//create entry
                                Entry newPlayer = new Entry();
                                newPlayer.setEmail(args[5]);
                                newPlayer.setPoint(Integer.parseInt(args[6]));
                                player.setElement(newPlayer);
                                queue.add(player);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (args[4].equals("-d")) {
                            queue.deletePlayer(args[5]);
                        } else if (args[4].equals("-u")) {
                            queue.updateNewPoint(args[5], Integer.parseInt(args[6]));
                        } else if (args[4].equals("-dt")) {
                            System.out.println("Remove the entry with max point:" + queue.removePlayerMax());
                        } else {
                            System.out.println("Error: Arguments not supported.");
                        }
                    }
                    FileIO.writeFile(args[3],queue);
                    System.out.println("check file!!!");
                }
                else if(args[2].equals("-g"))
                {
                    if(queue.getNode(args[3])!=null) {
                        System.out.println("Point of " + args[3] + " la : " + queue.getNode(args[3]).getElement().getPoint());
                    }else
                        System.out.println("Not Found Entry");
                }
                else if(args[2].equals("-t"))
                {
                    System.out.println("The Entry With Max Point: "+queue.getPlayerMax().getPoint());
                }
                else
                {
                    System.out.println("Error: Arguments not supported. ");
                }
            }
            else {
                System.out.println("Error: Arguments not supported.");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
