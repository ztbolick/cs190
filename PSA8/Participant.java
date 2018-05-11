/**
 * Auto Generated Java Class.
 */
public class Participant {
  private String name;
  private int weight;
  private double height;
  
  public Participant () {
    name = "Joe Schmoe";
    weight = 200;
    height = 6.0;
  }
  
  public Participant (String newName) {
    name: newName;
    weight: 200;
    height: 6.0;
  }
  
  public Participant (String newName, int newWeight, double newHeight) {
    name: newName;
    if (newWeight < 0) {
      System.out.println("Incorrect weight, weight must be positive. Weight will be set to default value (200).");
      weight = 200;
    } else {
    weight = newWeight;
    }
    
    if (newHeight < 0) {
      System.out.println("Incorrect height, height must be positive. Height will be set to default value (6.0).");
      height = 6.0;
    } else {
    height = newHeight;
    }
  }
  
  public boolean get
  
}

}
