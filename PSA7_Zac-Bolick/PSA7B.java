/**
 * Auto Generated Java Class.
 */
public class PSA7B {
  
  
  public static void main(String[] args) { 
    // Create new sound objects
    Sound s1 = new Sound("./resources/sec3silence.wav");
    Sound s2 = new Sound("./resources/sun.wav");
    Sound s3 = new Sound("./resources/test.wav");
    
    // call concatenation method
    s1.concatenation(s2, s3, s2.getLength()-10000);
    // show result
    s1.explore();
  }
}
