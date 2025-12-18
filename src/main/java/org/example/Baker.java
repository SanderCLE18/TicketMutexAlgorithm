package org.example;

import java.util.ArrayList;

public class Baker {
  private ArrayList<Thread> threads;
  private Thread[] criticalSection = new  Thread[1];
  private int counter = 0;
  private boolean hasThread = false;

  public Baker(){
    threads = new ArrayList<>();
  }


  public void addThread(Thread t){
    threads.add(t);
  }

  public void callNext(){
    if (hasThread) {
      return;
    }
    for (Thread t : threads){
      if (counter == t.getQueueNum()){
        t.notify();
        threads.remove(t);
        hasThread = true;
        criticalSection[0] = t;
      }
    }
    counter++;
  }

}
