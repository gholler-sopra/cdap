package co.cask.cdap.master.startup;

import org.junit.Test;

public class ThreadTest {

  @Test
  public void testThread() throws Exception{

    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(60000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    thread.start();

    thread.join();
  }
}
