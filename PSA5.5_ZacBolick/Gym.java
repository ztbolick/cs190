public class Gym {
  private int members;
  private int[] hours;
  private double memberFee;
  private double monthlyMembershipFee;
  private String locationName;
  private int locationNumber;
  private boolean takingMembers;
  
  public Gym () {
    members = 0;
    memberFee = 39.99;
    hours = new int[] {3, 0, 3, 0, 3, 0, 3, 0, 5, 0, 6, 11, 6, 0};
    monthlyMembershipFee = 49.99;
    locationName = "No Name";
    locationNumber = 999;
    takingMembers = true;
  }
  
  public Gym (int members, double monthlyMembershipFee, String locationName, int locationNumber) {
    this.members = members;
    this.memberFee = 39.99;
    this.hours = new int[] {3, 0, 3, 0, 3, 0, 3, 0, 5, 0, 6, 11, 6, 0};
    this.monthlyMembershipFee = monthlyMembershipFee;
    this.locationName = locationName;
    this.locationNumber = locationNumber;
    this.takingMembers = true;
  }
  
  public Gym (int members, double memberFee, int hours[], double monthlyMembershipFee, 
              String locationName, int locationNumber, boolean takingMembers) {
    this.members = members;
    this.memberFee = memberFee;
    this.hours = hours;
    this.monthlyMembershipFee = monthlyMembershipFee;
    this.locationName = locationName;
    this.locationNumber = locationNumber;
    this.takingMembers = takingMembers;
  }
  
  public int getMebers() {
    return members;
  }
  public double getMemberFee() {
    return memberFee;
  }
  public int[] getHours() {
    return hours;
  }
  public double getMonthlyMembershipFee() {
    return monthlyMembershipFee;
  }
  public String getLocationName () {
    return locationName;
  }
  public int getLocationNumber() {
    return locationNumber;
  }
  public boolean getTakingMembers() {
    return takingMembers;
  }
  
  public void setMebers(int members) {
    if (members >= 0) {
      this.members = members;
    } else {
      System.out.println("members must be positive or zero");
    }
  }
  public void setMemberFee(double memberFee) {
    if (memberFee >= 0) {
      this.memberFee = memberFee;
    } else {
      System.out.println("members must be positive or zero");
    }
  }
  public void setHours(int[] hours) {
    if (hours.length == 14) {
      this.memberFee = memberFee;
    } else {
      System.out.println("members must be positive or zero");
    }
  }
  public void setMonthlyMembershipFee(double monthlyMembershipFee) {
    if (monthlyMembershipFee >= 0) {
      this.monthlyMembershipFee = monthlyMembershipFee;
    } else {
      System.out.println("members must be positive or zero");
    }
  }
  public void setLocationName (String locationName) {
    this.locationName = locationName;
  }
  public void setLocationNumber(int locationNumber) {
    this.locationNumber = locationNumber;
  }
  public void setTakingMembers(boolean takingMembers) {
    this.takingMembers = takingMembers;
  }
}