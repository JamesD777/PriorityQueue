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
class PrintJob implements Comparable

{

    private int Priority;
    private String JobName;
    private int No_Of_Pages;

    public PrintJob(int Prio, String Name, int Number ){Priority = Prio;JobName = Name;No_Of_Pages = Number;}

    public void setPriority(int Prio){Priority = Prio;}
    public void setName(String Name){JobName = Name;}
    public void setNo_Of_Pages ( int Number){No_Of_Pages = Number;}
    
    public String getName(){return JobName;}
    public int getPriority(){return Priority*No_Of_Pages;}
    public int getNumberOfPages(){return No_Of_Pages;}
    public void print(){System.out.println("Priority: "+Priority +"\tJob Name:         "+JobName+"\tNo Of Pages: "+No_Of_Pages+"\tJob                  Priority ="+No_Of_Pages*Priority);}
    @Override
    public int compareTo(Object x){
        PrintJob pj=(PrintJob)x;
        if(getPriority()==pj.getPriority())
            return 0;
        else if(getPriority()>pj.getPriority())
            return 1;
        else
            return -1;
     }
}
