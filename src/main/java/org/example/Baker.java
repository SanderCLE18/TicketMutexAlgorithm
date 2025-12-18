package org.example;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Baker {
  private ArrayList<Thread> threads;
  private Thread[] criticalSection = new  Thread[1];
  private final Lock lock = new ReentrantLock();
  private int counter = 0;
  private boolean hasThread = false;

  public Baker(){
    threads = new ArrayList<>();
  }


  public void addThread(Thread t){
    threads.add(t);
    try{
      synchronized (lock){
        t.wait();
      }
    }catch(InterruptedException e){
      System.err.println("Object could not wait: " + e);
    }

  }

  public void callNext(){
    if (hasThread || threads.isEmpty()) {
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
