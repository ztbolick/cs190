
/**
 * Class that represents a sound.  This class is used by the students
 * to extend the capabilities of SimpleSound. 
 * 
 * Copyright Georgia Institute of Technology 2004
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Sound extends SimpleSound
{
  
  /////////////// consructors ////////////////////////////////////
  
  /**
   * Constructor that takes a file name
   * @param fileName the name of the file to read the sound from
   */
  public Sound(String fileName)
  {
    // let the parent class handle setting the file name
    super(fileName);
  }
  
  /**
   * Constructor that takes the number of samples in
   * the sound
   * @param numSamples the number of samples desired
   */
  public Sound (int numSamples)
  {
    // let the parent class handle this
    super(numSamples);
  }
  
  /**
   * Constructor that takes the number of samples that this
   * sound will have and the sample rate
   * @param numSamples the number of samples desired
   * @param sampleRate the number of samples per second
   */
  public Sound (int numSamples, int sampleRate)
  {
    // let the parent class handle this
    super(numSamples,sampleRate);
  }
  
  /**
   * Constructor that takes a sound to copy
   */
  public Sound (Sound copySound)
  {
    // let the parent class handle this
    super(copySound);
  }
  
  ////////////////// methods ////////////////////////////////////
  
  /**
   * Method to return the string representation of this sound
   * @return a string with information about this sound
   */
  public String toString()
  {
    String output = "Sound";
    String fileName = getFileName();
    
    // if there is a file name then add that to the output
    if (fileName != null)
      output = output + " file: " + fileName;
    
    // add the length in frames
    output = output + " number of samples: " + getLengthInFrames();
    
    return output;
  }
  
  public void concatenation (Sound s1, Sound s2, int switchPoint) {
    
    // Creat sample arrays from the sounds
    SoundSample[] sampleArray1 = s1.getSamples();
    SoundSample[] sampleArray2 = s2.getSamples();
    SoundSample[] sampleArray3 = this.getSamples();
    
//    System.out.println(sampleArray1.length);
//    System.out.println(sampleArray2.length);
//    System.out.println(sampleArray3.length);
    
    // Make sample objects for copying
    SoundSample sampleSource = null;
    SoundSample sampleTarget = null;
    
    // Check switch point is withing bound
    if (switchPoint > sampleArray1.length) {
      switchPoint = sampleArray1.length;
    }
    
    // Loop through the sample array upto switchPoint
    for (int i = 0; i < switchPoint; i++) {
      
      // Check if sampleTarget index is within the lenght of sampleTarget
      if (i < sampleArray3.length) {
        sampleSource = sampleArray1[i];
        sampleTarget = sampleArray3[i];
        sampleTarget.setValue(sampleSource.getValue());
      }
    }
    
    // Loop through the sample array upto switchPoint
    for (int i = 0, j = switchPoint; i < sampleArray2.length; i++, j++) {
      
      // Check if sampleTarget index is within the lenght of sampleTarget
      if (j < sampleArray3.length && i < sampleArray2.length) {
        sampleSource = sampleArray2[i];
        sampleTarget = sampleArray3[j];
        sampleTarget.setValue(sampleSource.getValue());
      }
    }
  }
  
  public Sound soundPalindrome()
  {
    Sound original = new Sound(this);
    Sound reverseSound = this.reverse();
    Sound emptySound = new Sound(this.getLength()*2);
    
    emptySound.concatenation(original, reverseSound, this.getLength());
    return emptySound;
  }
  
  
  public Sound reverse () {
    // Create a copy of the calling object and a new object to copy the reverse to
    Sound original = new Sound(this);
    int length = this.getLength();
    Sound reverse = new Sound(length);
    
    // use a decrementing loop to copy from right to left the calling object and an
    
    for (int targetIndex = 0, sourceIndex = length - 1; targetIndex < length && sourceIndex > 0; targetIndex++, sourceIndex--) {
      reverse.setSampleValueAt (targetIndex, original.getSampleValueAt(sourceIndex));
    }
    // return the reversed sound
    return reverse;
  }
  
  public static void main(String[] args)
  {
    Sound sound1 = new Sound(FileChooser.pickAFile());
    sound1.explore();
  }
  
} // this } is the end of class Sound, put all new methods before this