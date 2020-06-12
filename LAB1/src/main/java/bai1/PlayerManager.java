package bai1;

public class PlayerManager {
    SortedPriorityQueue queue=new SortedPriorityQueue();

    /**
     * Parsing arguments for CLI
     * @param args This is list of arguments will be parsed
     */
    public void parsingArguments(String[] args)
    {
        try {
            for(int i=0;i<args.length;i++)
            {
                switch (args[i])
                {
                    case "-r":
                        queue=CSV.readFile(args[i+1]);//read file
                        break;
                    case "-s":
                        CSV.writeFile(args[i+1],queue);//save to file
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
                        break;
                    case "-d":
                    case "-u":
                    case "-dt":
                    case "-g":
                    case "-t":
                }
            }
        }
        catch (IndexOutOfBoundsException e)
        {

        }
        

    }
}
