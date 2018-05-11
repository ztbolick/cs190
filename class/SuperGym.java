public class SuperGym extends ActiveGym {
 private boolean towels;
 private boolean pool;
 private boolean squatRacks;

 public SuperGym() {
  pool = true;
  towels = true;
  squatRacks = true;
 }

 public boolean getTowels () {
  return towels;
 }
 public boolean getPool () {
  return pool;
 }
 public boolean getSquatRacks () {
  return squatRacks;
 }
 public void setTowels (boolean towels) {
  this.towels = towels;
 }
 public void setPool (boolean pool) {
  this.pool = pool;
 }
 public void setSquatRacks (boolean squatRacks) {
  this.squatRacks = squatRacks;
 }
 
}