
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANDROMEDA
 */
public class SJFPreemptive{// implements Comparator<SJFPreemptive>{
    
    public static void main(String[] args) {
        Process[] processarray = {new Process("P1", 4, 0), new Process("P2", 5, 1),new Process("P3", 7, 2),new Process("P4", 3, 3)};
        //Arrays.sort(processarray);
        Prioqueue prio_q = new Prioqueue();
        Process p = processarray[0],q = new Process("NO", 0,0);
        prio_q.enqueue(p);
        int total_time = 0;
        int prev_time = p.arival_time, nxt_time,time;
        for(int i = 1; i < processarray.length;i++)
        {
            p = processarray[i];
            q = prio_q.dequeue();
            prio_q.enqueue(p);
            if(p.cpuBurstTime < q.cpuBurstTime)
            {
                nxt_time = p.arival_time;
                time = nxt_time-prev_time;
                q.waittime -= time;
                prev_time = nxt_time;
                q.cpuBurstTime = q.cpuBurstTime-time;
                if(q.cpuBurstTime > 0) prio_q.enqueue(q);
                else{
                    q.waittime += total_time - q.arival_time;
                }
                total_time += time;
            }
            else
            {
                prio_q.enqueue(q);
            }
        }
        while(!prio_q.isEmpty()){
            Process e = prio_q.dequeue();
            //e.cpuBurstTime = 0;
            e.waittime += total_time-e.arival_time;
            total_time += e.cpuBurstTime;
            e.cpuBurstTime = 0;
           // System.out.println(e.name+" "+e.cpuBurstTime+" "+e.waittime);
        }
        total_time = 0;
        int count = 0;
        for(Process x : processarray)
        {
            total_time += x.waittime;
            count++;
            System.out.println(x.name+" "+x.waittime);
        }
        System.out.println("Average Waiting time "+total_time*1.0/count);
    }
}
