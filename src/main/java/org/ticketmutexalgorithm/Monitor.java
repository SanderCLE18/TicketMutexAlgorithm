package org.ticketmutexalgorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {
  private final Lock lock = new ReentrantLock();
  private final Condition condition = lock.newCondition();

  private int counter = 0;
  private int currentNum = 0;

  public Monitor(){
  }

  public int addThread() throws InterruptedException{
    lock.lock();
    try{
      int ticket = counter;
      counter++;
      while(ticket != currentNum){
        condition.await();
      }
      return ticket;
    }finally {
      lock.unlock();
    }
  }

  public void callNext(){
    lock.lock();
    try{
      currentNum++;
      condition.signalAll();
    }finally {
      lock.unlock();
    }
  }

}
