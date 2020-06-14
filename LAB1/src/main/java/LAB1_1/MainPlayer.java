/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;
public class MainPlayer {
    public void parsingArguments(String[] args){
        PriorityQueue queue = new PriorityQueue();
        try {
            if(args[0].equals("-r"))
            {
                queue=FileInOut.getFile(args[1]);
                if(args[2].equals("-s"))
                {
                    if(args.length>4) {
                        if (args[4].equals("-a")) {
                            try {
                                Node<Player> player = new Node<>();
                                Player newPlayer = new Player();
                                newPlayer.setEmail(args[5]);
                                newPlayer.setPoint(Integer.parseInt(args[6]));
                                player.setInfo(newPlayer);
                                queue.add(player);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (args[4].equals("-d")) {
                            queue.deletePlayer(args[5]);
                        } else if (args[4].equals("-u")) {
                            queue.updateNewPoint(args[5], args[6]);
                        } else if (args[4].equals("-dt")) {
                            System.out.println("Delete top player:" + queue.removePlayerMax());
                        } else {
                            System.out.println("Error: Arguments not supported.");
                        }
                    }
                    FileInOut.writeFile(args[3],queue);
                    System.out.println("Kiem tra file moi!!!");
                }
                else if(args[2].equals("-g"))
                {
                    if(queue.getNode(args[3])!=null) {
                        System.out.println("Diem cua " + args[3] + "la : " + queue.getNode(args[3]).getInfo().getPoint());
                    }else
                        System.out.println("Khong tim thay nguoi choi");
                }
                else if(args[2].equals("-t"))
                {
                    System.out.println("Nguoi choi cao nhat: "+queue.getPlayerMax().getPoint());
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
