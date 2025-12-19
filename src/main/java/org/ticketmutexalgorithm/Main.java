package org.ticketmutexalgorithm;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    Monitor monitor = new Monitor();
    ArrayList<Worker> threads = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      Worker thread = new Worker(i, monitor);
      threads.add(thread);
    }

    for(var t : threads){
      t.start();
    }

    for (var t : threads){
      try {
        t.join();
      } catch (InterruptedException e) {
        System.err.println("Could not join threads");
      }
    }

  }
}