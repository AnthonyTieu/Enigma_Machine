//THE ENIGMA MACHINE
import java.util.*; //Java.util

public class EnigmaMachine
{
  public static void main(String[] args) throws Exception
  {
    //Static Rotor
    String [] static_rotor = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    
    //Rotor I
    String [] rotor_i_input = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String [] rotor_i = {"E", "K", "M", "F", "L", "G", "D", "Q", "V", "Z", "N", "T", "O", "W", "Y", "H", "X", "U", "S", "P", "A", "I", "B", "R", "C", "J"};
    
    //Rotor II
    String [] rotor_ii_input = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String [] rotor_ii = {"A", "J", "D", "K", "S", "I", "R", "U", "X", "B", "L", "H", "W", "T", "M", "C", "Q", "G", "Z", "N", "P", "Y", "F", "V", "O", "E"};
    
    //Rotor III
    String [] rotor_iii_input = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String [] rotor_iii = {"B", "D", "F", "H", "J", "L", "C", "P", "R", "T", "X", "V", "Z", "N", "Y", "E", "I", "W", "G", "A", "K", "M", "U", "S", "Q", "O"};
    
    //Reflector B
    String [] reflector_input = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String [] reflector = {"Y", "R", "U", "H", "Q", "S", "L", "D", "P", "X", "N", "G", "O", "K", "M", "I", "E", "B", "F", "Z", "C", "W", "V", "J", "A", "T"};
    
    //Messages
    Scanner input = new Scanner(System.in);
    System.out.println("Please Enter a Message to be Encoded (no numbers and no punctuation):");
    String message = ((input.nextLine()).toUpperCase()).replace(" ", "");
    //String message = "THEENIGMAMACHINE"; //Original message
    String encrypt = ""; //Encrypted message
    
    //***********************
    //ENIGMA MACHINE SETTINGS
    //***********************
    
    
    //ROTOR I
    //Initial Position
    System.out.println("Please Enter the Grundstellung (initial position) of Rotor I:");
    String initial_rotori = ((input.next()).substring(0, 1)).toUpperCase();
    //String initial_rotori = "A";
    Collections.rotate(Arrays.asList(rotor_i_input), -1 * ((initial_rotori.charAt(0)) - 65));
    
    //Ring Setting
    System.out.println("Please Enter the ringstellung (ring setting) of Rotor I:");
    String ring_rotori = ((input.next()).substring(0, 1)).toUpperCase();
    //String ring_rotori = "A";
    int dotPos_rotori = 20;
    
    Collections.rotate(Arrays.asList(rotor_i_input), (ring_rotori.charAt(0)) - 65);
    dotPos_rotori += ring_rotori.charAt(0) - 65;
    
    
    //ROTOR II
    //Initial Position
    System.out.println("Please Enter the Grundstellung (initial position) of Rotor II:");
    String initial_rotorii = ((input.next()).substring(0, 1)).toUpperCase();
    //String initial_rotorii = "A";
    Collections.rotate(Arrays.asList(rotor_ii_input), -1 * ((initial_rotorii.charAt(0)) - 65));
    
    //Ring Setting
    System.out.println("Please Enter the ringstellung (ring setting) of Rotor II:");
    String ring_rotorii = ((input.next()).substring(0, 1)).toUpperCase();
    //String ring_rotorii = "A";
    int dotPos_rotorii = 0;
    
    Collections.rotate(Arrays.asList(rotor_ii_input), (ring_rotorii.charAt(0)) - 65);
    dotPos_rotorii += ring_rotorii.charAt(0) - 65;
    
    
    //ROTOR III
    //Initial Position
    System.out.println("Please Enter the Grundstellung (initial position) of Rotor III:");
    String initial_rotoriii = ((input.next()).substring(0, 1)).toUpperCase();
    //String initial_rotoriii = "A";
    Collections.rotate(Arrays.asList(rotor_iii_input), -1 * ((initial_rotoriii.charAt(0)) - 65));
    
    //Ring Setting
    System.out.println("Please Enter the ringstellung (ring setting) of Rotor III:");
    String ring_rotoriii = ((input.next()).substring(0, 1)).toUpperCase();
    //String ring_rotoriii = "A";
    int dotPos_rotoriii = 19;
    
    Collections.rotate(Arrays.asList(rotor_iii_input), (ring_rotoriii.charAt(0)) - 65);
    dotPos_rotoriii += ring_rotoriii.charAt(0) - 65;
    
    
    
    //********************
    //ENCODING THE MESSAGE
    //********************
    
    
    for(int count2 = 0; count2 < message.length(); count2++)
    {
      //***************************
      //STEP 1: ROTATING THE ROTORS
      //***************************
      
      //ROTOR I
      Collections.rotate(Arrays.asList(rotor_i_input), -1); 
      
      
      //ROTOR II (Condition 1)
      if(Arrays.asList(rotor_i_input).indexOf("R") == ((ring_rotori.charAt(0)) - 65))
      {
        Collections.rotate(Arrays.asList(rotor_ii_input), -1);
        System.out.println("ROTATE 2");
        
        //ROTOR III
        if(Arrays.asList(rotor_ii_input).indexOf("F") == ((ring_rotorii.charAt(0)) - 65))
        {
          Collections.rotate(Arrays.asList(rotor_iii_input), -1);
          System.out.println("ROTATE 3");
        }
      }
      
      
      //ROTOR II (Condition 2)
      if((Arrays.asList(rotor_i_input).indexOf("S") == ((ring_rotori.charAt(0)) - 65)) && (Arrays.asList(rotor_ii_input).indexOf("E") == ((ring_rotorii.charAt(0)) - 65)))
      {
        Collections.rotate(Arrays.asList(rotor_ii_input), -1);
        System.out.println("ROTATE 2");
        
        //ROTOR III
        if(Arrays.asList(rotor_ii_input).indexOf("F") == ((ring_rotorii.charAt(0)) - 65))
        {
          Collections.rotate(Arrays.asList(rotor_iii_input), -1);
          System.out.println("ROTATE 3");
        }
      }

      System.out.println("Input: " + message.charAt(count2));
      
      
      //*****************************************
      //STEP 2: PASSING CHARACTERS THROUGH ROTORS
      //*****************************************
      
      //*STATIC ROTOR*
      int outputPos_staticRotor = Arrays.asList(static_rotor).indexOf(Character.toString(message.charAt(count2)));
      
      
      
      //*ROTOR I*
      //Entering Rotor
      String enter_rotori = Arrays.asList(rotor_i_input).get(outputPos_staticRotor);
      
      //Converting in Rotor
      String convert_rotori = Arrays.asList(rotor_i).get((enter_rotori.charAt(0))-65); 

      //Output of Rotor
      String outputPos_rotori = Integer.toString(Arrays.asList(rotor_i_input).indexOf(convert_rotori));
      System.out.println("Output i: " + Arrays.asList(static_rotor).get(Integer.parseInt(outputPos_rotori)));
      
      
      
      //*ROTOR II*
      //Entering Rotor
      String enter_rotorii = Arrays.asList(rotor_ii_input).get(Integer.parseInt(outputPos_rotori));
      
      //Converting in Rotor
      String convert_rotorii = Arrays.asList(rotor_ii).get((enter_rotorii.charAt(0))-65); 

      //Output of Rotor
      String outputPos_rotorii = Integer.toString(Arrays.asList(rotor_ii_input).indexOf(convert_rotorii));
      System.out.println("Output ii: " + Arrays.asList(static_rotor).get(Integer.parseInt(outputPos_rotorii)));
      
      
      
      //*ROTOR III*
      //Entering Rotor
      String enter_rotoriii = Arrays.asList(rotor_iii_input).get(Integer.parseInt(outputPos_rotorii));
      
      //Converting in Rotor
      String convert_rotoriii = Arrays.asList(rotor_iii).get((enter_rotoriii.charAt(0))-65); 

      //Output of Rotor
      String outputPos_rotoriii = Integer.toString(Arrays.asList(rotor_iii_input).indexOf(convert_rotoriii));    
      System.out.println("Output iii: " + Arrays.asList(static_rotor).get(Integer.parseInt(outputPos_rotoriii)));
      
      
      
      //*REFLECTOR*
      //Entering Reflector
      String enter_reflector = Arrays.asList(reflector_input).get(Integer.parseInt(outputPos_rotoriii));
      
      //Converting in Reflector 
      String convert_reflector = Arrays.asList(reflector).get((enter_reflector.charAt(0))-65);
      
      //Output of Reflector
      int outputPos_reflector = (Arrays.asList(reflector_input).indexOf(convert_reflector));
      System.out.println("Output reflector: " + Arrays.asList(static_rotor).get((outputPos_reflector)));
      
      
      
      //*ROTOR III*
      //Entering Rotor
      String enter2_rotoriii = Arrays.asList(rotor_iii_input).get(outputPos_reflector);  
      
      //Converting in Rotor
      String convert2_rotoriii = Character.toString((char)((Arrays.asList(rotor_iii).indexOf(enter2_rotoriii)) + 65)); 

      //Output of Rotor
      int outputPos2_rotoriii = Arrays.asList(rotor_iii_input).indexOf(convert2_rotoriii);
      System.out.println("Output iii: " + Arrays.asList(static_rotor).get(outputPos2_rotoriii));
      
      
      
      //*ROTOR II*
      //Entering Rotor
      String enter2_rotorii = Arrays.asList(rotor_ii_input).get(outputPos2_rotoriii); 
      
      //Converting in Rotor
      String convert2_rotorii = Character.toString((char)((Arrays.asList(rotor_ii).indexOf(enter2_rotorii)) + 65)); 

      //Output of Rotor
      int outputPos2_rotorii = Arrays.asList(rotor_ii_input).indexOf(convert2_rotorii);
      System.out.println("Output ii: " + Arrays.asList(static_rotor).get(outputPos2_rotorii));
      
      
      
      //*ROTOR I*
      //Entering Rotor
      String enter2_rotori = Arrays.asList(rotor_i_input).get(outputPos2_rotorii); 
      
      //Converting in Rotor 
      String convert2_rotori = Character.toString((char)((Arrays.asList(rotor_i).indexOf(enter2_rotori)) + 65)); 

      //Output of Rotor
      int outputPos2_rotori = Arrays.asList(rotor_i_input).indexOf(convert2_rotori);
      System.out.println("Output i: " + Arrays.asList(static_rotor).get(outputPos2_rotori) + "\n");
      
      
      
      encrypt += Arrays.asList(static_rotor).get(outputPos2_rotori);
    }
    System.out.println("\nCipher Settings:");
    System.out.println("Path from Input to Output: Rotor I, Rotor II, Rotor III, Reflector UKW-B, Rotor III, Rotor II, Rotor I");
    System.out.println("\nOriginal Message: " + message);
    System.out.println("Encrypted: " + encrypt);
  }
}