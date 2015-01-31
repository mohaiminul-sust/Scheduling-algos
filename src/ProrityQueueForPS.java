
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANDROMEDA
 */
public class ProrityQueueForPS {
    List<LinkedList<Process>> prioque;
    public ProrityQueueForPS(){
        prioque = new ArrayList<LinkedList<Process>>();
        for(int i = 0; i < 50;i++)
        {
           prioque.add(new LinkedList<Process>());
        }
     }
    public void enqueue(Process e){
        prioque.get(e.arival_time).add(e);
    }
    public Process dequeue(){
        int i;
        for(i = 0; i < 50;i++)
        {
            if(prioque.get(i).size() > 0){
                break;
            }
        }
        Process e = prioque.get(i).getFirst();
        prioque.get(i).removeFirst();
        return e;
    }
    public boolean isEmpty(){
        int i;
        for(i = 0; i < 50;i++){
            if(prioque.get(i).size() > 0) return false;
        }
        return true;
    }
}
