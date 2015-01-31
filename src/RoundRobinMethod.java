
import java.util.ArrayList;
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
public class RoundRobinMethod {
    public static void main(String[] args) {
        Process[] processarray = {new Process("P1", 24),new Process("P2", 3), new Process("P3", 3)};
        List<Process> list_of_process = new ArrayList<Process>();
        for(Process x : processarray){
            list_of_process.add(x);
        }
        int time_quantum = 4;
        int total_time = 0, count = 0, i = 0;
        Process x;
       while(true){
           for(i = 0 ;i < list_of_process.size(); i++)
           {
               x = list_of_process.get(i);
               if(x.cpuBurstTime <= time_quantum)
               {
                   x.waittime += total_time;
                   total_time += x.cpuBurstTime;
                   x.cpuBurstTime = 0;
                   list_of_process.remove(x);
                   i--;
               }
               else
               {
                   x.cpuBurstTime -= time_quantum;
                   x.waittime -= time_quantum; 
                   total_time += time_quantum;
               }
           }
           if(list_of_process.size() == 0)
           {
               break;
           }
           else if(list_of_process.size() == 1)
           {
               x = list_of_process.get(0);
               x.waittime += total_time;
               break;
           }
       }
       total_time = 0;
       count = 0;
       for(Process ex : processarray){
           System.out.println(ex.name+" "+ex.waittime);
           total_time += ex.waittime;
           count++;
       }
       System.out.println("Average Waiting Time "+(total_time*1.0/count));
    }
}
