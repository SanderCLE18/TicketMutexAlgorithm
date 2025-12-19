package org.ticketmutexalgorithm;
import java.util.concurrent.ThreadLocalRandom;

public class Worker extends Thread {

  int id;
  int queueNum;
  Monitor monitor;
  int beenInCs = 0;

  public Worker(int id, Monitor monitor) {
    this.id = id;
    this.monitor = monitor;
  }

  @Override
  public void run() {
    System.out.println(id + " is running");
    int randNumber;

    while(beenInCs <= 10) {
      randNumber = ThreadLocalRandom.current().nextInt(0, 101);
      if(randNumber % 17 == 0){
        try{
          queueNum = monitor.addThread();

          do{
            randNumber = ThreadLocalRandom.current().nextInt(0, 101);
          } while (randNumber % 5 != 0);

          System.out.println("Printing from CS: " + id );
          beenInCs++;
        }catch(InterruptedException e){
          Thread.currentThread().interrupt();
          System.err.println(id + " is interrupted");
        } finally {
          monitor.callNext();
        }
      }
    }
  }


}
