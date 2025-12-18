package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    Baker baker = new Baker();
    Thread thread1 = new Thread(1, "b", baker);
    Thread thread2 = new Thread(2, "e", baker);
    Thread thread3 = new Thread(3, "a", baker);
    Thread thread4 = new Thread(4, "t", baker);

    thread1.run();
    thread2.run();
    thread3.run();
    thread4.run();

    while (true){
      baker.callNext();
    }

  }
}