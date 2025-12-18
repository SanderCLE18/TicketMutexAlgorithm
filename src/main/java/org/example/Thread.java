package org.example;


public class Thread implements Runnable {

  int id;
  int queueNum;
  String content;
  Baker baker;

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

  }


}
