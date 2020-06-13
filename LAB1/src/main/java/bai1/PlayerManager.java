package bai1;

import org.w3c.dom.ls.LSOutput;

public class PlayerManager {
    SortedPriorityQueue queue=new SortedPriorityQueue();

    /**
     * Parsing arguments for CLI
     * @param args This is list of arguments will be parsed
     */
    public void parsingArguments(String[] args)
    {
        String outputfileName="";
        try {
            if(args[0].equals("-r"))
            {
                queue=CSV.readFile(args[1]);
                if(args[2].equals("-s"))
                {
                    if(args[4].equals("-a"))
                    {
                        try {
                            DLLNode<Player> newest=new DLLNode<>();//create new node
                            Player newPlayer=new Player();//create new Player
                            newPlayer.setEmail(args[5]);//set email for Player
                            if(Integer.parseInt(args[6])<0)
                                throw new Exception("Error:Point must >10");//check if point <0 or not
                            //If not, then set point for new Player
                            newPlayer.setPoint(Integer.parseInt(args[6]));
                            newest.setInfo(newPlayer);//set Info for newest Node
                            queue.add(newest);//add it into Queue
                        }catch(NumberFormatException e)
                        {
                            System.out.println("Error: Not compatible variable data type!");
                        }
                        catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    }
                    else if(args[4].equals("-d"))
                    {
                        queue.deletePlayer(args[5]);//delete Player
                    }
                    else if(args[4].equals("-u"))
                    {
                        queue.updatePlayer(args[5],args[6]);//update Player
                    }
                    else if(args[4].equals("-dt"))
                    {
                        System.out.println("Delete top player:"+queue.removeMax());//remove Player has highest score
                    }
                    else
                    {
                        System.out.println("Error: Arguments not supported. Check helps to correct argument! Thanks!");
                    }
                    CSV.writeFile(args[3],queue);
                }
                else if(args[2].equals("-g"))
                {
                    if(queue.getNode(args[3])!=null) {
                        System.out.println("Point of Player " + args[3] + "is " + queue.getNode(args[3]).getInfo().getPoint());
                    }else
                        System.out.println("Error: Not found player");
                }
                else if(args[2].equals("-t"))
                {
                    System.out.println("Highest point: "+queue.getMax().getPoint());
                }
                else
                {
                    System.out.println("Error: Arguments not supported. Check helps to correct argument! Thanks!");
                }
            }
            else {
                System.out.println("Error: Arguments not supported. Check helps to correct argument! Thanks!");
            }

            /*for(int i=0;i<args.length;i++)
            {
                switch (args[i])
                {
                    case "-r":
                        queue=CSV.readFile(args[i+1]);//read file
                        break;
                    case "-s":
                        outputfileName=args[i+1];
                        CSV.writeFile(outputfileName,queue);//save to file
                        break;
                    case "-a":
                        try {
                            DLLNode<Player> newest=new DLLNode<>();//create new node
                            Player newPlayer=new Player();//create new Player
                            newPlayer.setEmail(args[i+1]);//set email for Player
                            if(Integer.parseInt(args[i+2])<0)
                                throw new Exception("Error:Point must >10");//check if point <0 or not
                            //If not, then set point for new Player
                            newPlayer.setPoint(Integer.parseInt(args[i+2]));
                            newest.setInfo(newPlayer);//set Info for newest Node
                            queue.add(newest);//add it into Queue
                        }catch(NumberFormatException e)
                        {
                            System.out.println("Error: Not compatible variable data type!");
                        }
                        catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        CSV.writeFile(outputfileName,queue);//save to file
                        break;
                    case "-d":
                        queue.deletePlayer(args[i+1]);//delete Player
                        CSV.writeFile(outputfileName,queue);//save to file
                        break;
                    case "-u":
                        queue.updatePlayer(args[i+1],args[i+2]);//update Player
                        CSV.writeFile(outputfileName,queue);//save to file
                        break;
                    case "-dt":
                        queue.removeMax();//remove Player has highest score
                        CSV.writeFile(outputfileName,queue);//save to file
                        break;
                    case "-g":
                        if(queue.getNode(args[i+1])!=null) {
                            System.out.println("Point of Player " + args[i + 1] + "is " + queue.getNode(args[i + 1]).getInfo().getPoint());
                        }else
                            System.out.println("Error: Not found player");
                        break;
                    case "-t":
                        System.out.println("Highest point: "+queue.getMax().getPoint());
                        break;
                }
            }*/
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Error: Not enough arguments");
        }
        

    }
}
