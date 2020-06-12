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
            for(int i=0;i<args.length;i++)
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
                    default:
                        System.out.println("Error: Not valid arguments");
                        break;
                }
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Error: Not enough arguments");
        }
        

    }
}
