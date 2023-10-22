import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class Algorithms{
  static void fromStringtoLong (String input){
    long result = input.indexOf('0');
   long count =16;
    for(int i=0;i<input.length();i++){
      result+=count*Long.parseLong(String.valueOf(input.charAt(i))); 
      count*=16;
      




    }
    System.out.println(result);



  }







    static void  fromLongTo2dArray (HashMap<Long,Long> parent) {
      
      int[][] xx =new int[3][3];

        for (Map.Entry<Long,Long> entry : parent.entrySet()) {
            long key = entry.getKey();
            int i=0;
        int k=0;
        for(int j=4;j<40;j=j+4){
            xx[k][i]=(int)(((1 << 4) - 1) & (key >> (j )));
            if(i==2){
                i=0;
                k++;
            }
            else{
                i++;
            }


        }
            
           
        }





        
        



    }

    static long swapBits(long x, int p1, int p2)
    {
        // Move all bits of first set
        // to rightmost side
        long set1 = (x >> p1) & (15);
 
        // Move all bits of second set
        // to rightmost side
        long set2 = (x >> p2) & (15);
 
        // XOR the two sets
        long xor = (set1 ^ set2);
 
        // Put the xor bits back to
        // their original positions
        xor = (xor << p1) | (xor << p2);
 
        // XOR the 'xor' with the original number
        // so that the  two sets are swapped
        long result = x ^ xor;
 
        return result;
    }

    static HashMap<Long,Long> BFS (long s){
      
     

        Queue<Long> frontier = new LinkedList<>(); // Data structure for states to be explored
        HashSet<Long> explored = new HashSet<>(); // Data structure for explored states
        HashMap<Long,Long> parent = new HashMap<>(); // data structures for relations between states in search tree
        parent.put(s,s); //adding the intial state to frontier and parent map
        frontier.add(s);
        //loop begining
        while(!frontier.isEmpty()){
          
            long cur =frontier.poll(); // current state to be checked
            explored.add(cur);
            // checking current state
            if(cur==581519483136l){
              System.out.println("Found");
            
            


                return parent;
            }
            int p1=(int)((cur & 8)+(cur & 4) + 
            (cur & 2) + (cur & 1));  // extracting index of 0 in the puzzle table from the long number
    // neighbors examination starts
            long neighbor =0l;
            //moving 0 up
            if(p1*4+16<39){
              neighbor =  swapBits(cur, 4+4*p1, p1*4+16)+3;
              if(!parent.containsKey(neighbor)){
                frontier.add(neighbor);
                parent.put(neighbor, cur);
               

                


              }
                

            }
            //moving 0 down
            if((p1*4-8>0))
            {
               neighbor= swapBits(cur, 4+4*p1, p1*4-8)-3;
               if(!parent.containsKey(neighbor)){
                frontier.add(neighbor);
                parent.put(neighbor, cur);
               
                
                
              }

            }
            //moving 0 right
            if((p1+1)%3!=0){
               neighbor= swapBits(cur, 4+4*p1, p1*4+8)+1;
               if(!parent.containsKey(neighbor)){
                frontier.add(neighbor);
                parent.put(neighbor, cur);
                
                
                
              }


            }
            //moving 0 left
            if((p1)%3!=0){
               neighbor= swapBits(cur, 4+4*p1, p1*4)-1;
               if(!parent.containsKey(neighbor)){
                frontier.add(neighbor);
                parent.put(neighbor, cur);
               
               
                
              }

            }
            // neighbors examination ends
           
            
            
            

            



        }// end of loop
        System.out.println("Not Found");














        return parent;
            
        
        


    
    






    }



    static HashMap<Long,Long> DFS (long s){
      
     

        Stack<Long> frontier = new Stack<>(); // Data structure for states to be explored
        HashSet<Long> explored = new HashSet<>(); // Data structure for explored states
        HashMap<Long,Long> parent = new HashMap<>(); // data structures for relations between states in search tree
        parent.put(s,s); //adding the intial state to frontier and parent map
        frontier.add(s);
        //loop begining
        while(!frontier.isEmpty()){
          
            long cur =frontier.pop(); // current state to be checked
            explored.add(cur);
            // checking current state
            if(cur==581519483136l){
              System.out.println("Found");
            
            


                return parent;
            }
            int p1=(int)((cur & 8)+(cur & 4) + 
            (cur & 2) + (cur & 1));  // extracting index of 0 in the puzzle table from the long number
    // neighbors examination starts
            long neighbor =0l;
            //moving 0 up
            if(p1*4+16<39){
              neighbor =  swapBits(cur, 4+4*p1, p1*4+16)+3;
              if(!parent.containsKey(neighbor)){
                frontier.push(neighbor);
                parent.put(neighbor, cur);
               

                


              }
                

            }
            //moving 0 down
            if((p1*4-8>0))
            {
               neighbor= swapBits(cur, 4+4*p1, p1*4-8)-3;
               if(!parent.containsKey(neighbor)){
                frontier.push(neighbor);
                parent.put(neighbor, cur);
               
                
                
              }

            }
            //moving 0 right
            if((p1+1)%3!=0){
               neighbor= swapBits(cur, 4+4*p1, p1*4+8)+1;
               if(!parent.containsKey(neighbor)){
                frontier.push(neighbor);
                parent.put(neighbor, cur);
                
                
                
              }


            }
            //moving 0 left
            if((p1)%3!=0){
               neighbor= swapBits(cur, 4+4*p1, p1*4)-1;
               if(!parent.containsKey(neighbor)){
                frontier.push(neighbor);
                parent.put(neighbor, cur);
               
               
                
              }

            }
            // neighbors examination ends
           
            
            
            

            



        }// end of loop
        System.out.println("Not Found");














        return parent;
            
        
        


    
    






    }

  















}
