package bai1;

import java.io.*;

/**
 * CSV class read and write file CSV
 */
public class CSV {
    /**
     * Read data from file csv then put it in SortedPriorityQueue
     * @param csvFilename This is path of file want to read data
     * @return a SortedPriorityQueue that contains sorted list of Player
     */
    public static SortedPriorityQueue readFile(String csvFilename)
    {
        SortedPriorityQueue queue = new SortedPriorityQueue();
        FileReader fr=null;
        BufferedReader br=null;
        try {
            fr=new FileReader(csvFilename);
            br=new BufferedReader(fr);
            String s=br.readLine();//First line is Email, Point-->pass this line
            while(br.ready())//check EOF
            {
                s=br.readLine();
                String[] arr=s.split(", ");
                if(arr.length==2){
                    Player player=new Player();//create new player
                    player.setEmail(arr[0]);
                    player.setPoint(Integer.parseInt(arr[1]));
                    DDLNode<Player> newNode=new DDLNode();//create node to add into list
                    newNode.setInfo(player);
                    queue.add(newNode);
                }
                else throw new Exception("Not compatible");
            }

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error: File not found");

        }
        catch (IOException e)
        {
            System.out.println("Error: Something's wrong in file processing");
        }
        catch (Exception e) {
            System.out.println("Error: Something's wrong");
        }
        finally
        {
            try {
                if(br!=null) br.close();
                if(fr!=null) fr.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return queue;
    }
    /**
     * Write a SortedPriorityQueue that contains sorted list of Player into csv file
     * @param csvFileName This is path of file want to save data in
     * @param queue This is SortedPriorityQueue that contains sorted list of Player
     * @return nothing
     */
    public static void writeFile(String csvFileName, SortedPriorityQueue queue) {
        if (queue.getList().getSize() == 0) {
            System.out.println("Error: Queue is empty");
        } else {
            File f = new File(csvFileName);//create new file
            PrintWriter pw = null;
            try {
                pw = new PrintWriter(f);
                pw.println("Email, Point");
                DDLNode<Player> temp = queue.getList().getHeader();//get the header of the list
                while (temp != null)//traverse the list
                {
                    pw.println(temp.getInfo().toString());//write into file
                    temp = temp.getNext();//go to next node
                }

            }
            catch (IOException e)
            {
                System.out.println("Error:Something's wrong in file processing");
            }
            catch (Exception e) {
                System.out.println("Error:Something's error");
            } finally {
                try {
                    if (pw != null) pw.close();
                } catch (Exception e) {
                    System.out.println("Error:Something's wrong");
                }
            }

        }
    }
}
