public class ActiveGym extends Gym {
  private boolean basketballCourt;
  private boolean sauna;
  private boolean kidsClub;
  
  public ActiveGym() {
    basketballCourt = true;
    sauna = true;
    kidsClub = true;
  }
  
  public boolean getBasketballCourt () {
    return basketballCourt;
  }
  public boolean getSauna () {
    return sauna;
  }
  public boolean getKidsClub () {
    return kidsClub;
  }
  public void setSauna (boolean sauna) {
    this.sauna = sauna;
  }
  public void setPool (boolean basketballCourt) {
    this.basketballCourt = basketballCourt;
  }
  public void setSquatRacks (boolean kidsClub) {
    this.kidsClub = kidsClub;
  }
  
}