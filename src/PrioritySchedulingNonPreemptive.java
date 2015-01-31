/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANDROMEDA
 */
public class PrioritySchedulingNonPreemptive {
    public static void main(String[] args) {
        Process[] processarray = {
            new Process("P1", 10, 3),
            new Process("P2", 1, 1),
            new Process("P3", 2, 4),
            new Process("P4", 1, 5),
            new Process("P5", 5, 2)
        };
        ProrityQueueForPS prio_q = new ProrityQueueForPS();
        for(Process x: processarray)
        prio_q.enqueue(x);
        int total_time = 0;
        
        while(!prio_q.isEmpty()){
            Process x = prio_q.dequeue();
            //System.out.println(x.name);
            x.waittime = total_time;
            total_time += x.cpuBurstTime;
        }
        int count = 0,total = 0;
        for(Process x: processarray)
        {
            total += x.waittime;
            count++;
            System.out.println(x.name+" "+x.waittime);
        }
        System.out.println("Average Waiting Time "+ total*1.0/count);
    }
}
