package org.example;


import java.util.concurrent.ThreadLocalRandom;

public class Thread implements Runnable {

  int id;
  int queueNum;
  String content;
  Baker baker;
  boolean inCS = false;

  public Thread(int id, String content, Baker baker ) {
    this.id = id;
    this.content = content;
    this.baker = baker;
  }

  public void setQueueNum(int queueNum) {
    this.queueNum = queueNum;
  }

  public int getQueueNum() {
    return queueNum;
  }

  @Override
  public void run() {
    int randNumber;

    while(true) {
      randNumber = ThreadLocalRandom.current().nextInt(0, 999);
      if(randNumber % 17 == 0){
        baker.addThread(this);
      }
      if(inCS){
        while (randNumber % 5 != 0){
          randNumber = ThreadLocalRandom.current().nextInt(0, 999);
        }
        System.out.println("Change made by object: " + id + ". Content: " + content);
      }

    }
  }


}
