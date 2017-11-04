/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue;

/**
 *
 * @author jcd4912
 */
public class OutsidePrintJob extends PrintJob{

    double cost;
    public OutsidePrintJob(int p, String j, int n){super(p, j, n);cost = n*10;}
    public double getCost(){return cost;}
}
