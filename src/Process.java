/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANDROMEDA
 */
public class Process implements Comparable<Process>{
    public String name;
    public int cpuBurstTime;
    public int waittime = 0;
    public int arival_time;
    public Process(String name, int cbt){
        this.name = name;
        cpuBurstTime = cbt;
    }
     public Process(String name, int cbt, int arrivtime){
        this.name = name;
        cpuBurstTime = cbt;
        arival_time = arrivtime;
    }
    @Override
    public int compareTo(Process o)
    {
        int compareQuantity = o.cpuBurstTime;
        return this.cpuBurstTime - compareQuantity;
    }
    
}
