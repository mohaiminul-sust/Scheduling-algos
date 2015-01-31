
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANDROMEDA
 */
public class FCFSAlgo {
    public static void main(String[] args) {
        Process[] processarray = {new Process("P1", 24), new Process("P2", 3), new Process("P3", 3)};
       // Arrays.sort(processarray);
        int total = 0;
        for(Process x: processarray){
            x.waittime = total;
            total = total+x.cpuBurstTime;
        }
        total = 0;
        int count = 0;
         for(Process x: processarray){
            System.out.println("Process "+x.name+" waiting time "+x.waittime);
            total = total + x.waittime;
            count++;
        }
        System.out.println(total*1.0/count);
    }
}
