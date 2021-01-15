//THE ENIGMA MACHINE
import java.util.*; //Java.util

public class EnigmaMachineCodeBreaker
{
  public static void main(String[] args) throws Exception
  {
    //Static Rotor
    String [] static_rotor = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    
    String [][] rotor_inputs = {{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}, {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}, {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}};
    String [][] rotor_wiring = {{"E", "K", "M", "F", "L", "G", "D", "Q", "V", "Z", "N", "T", "O", "W", "Y", "H", "X", "U", "S", "P", "A", "I", "B", "R", "C", "J"}, {"A", "J", "D", "K", "S", "I", "R", "U", "X", "B", "L", "H", "W", "T", "M", "C", "Q", "G", "Z", "N", "P", "Y", "F", "V", "O", "E"}, {"B", "D", "F", "H", "J", "L", "C", "P", "R", "T", "X", "V", "Z", "N", "Y", "E", "I", "W", "G", "A", "K", "M", "U", "S", "Q", "O"}};
    
    //Reflector B
    String [] reflector_input = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String [] reflector = {"Y", "R", "U", "H", "Q", "S", "L", "D", "P", "X", "N", "G", "O", "K", "M", "I", "E", "B", "F", "Z", "C", "W", "V", "J", "A", "T"};
    
    //Messages
    String message = "JTAFRCOHTEQUIVUA"; //Original message
    String decrypt = ""; //Encrypted message
    String[] rotor_order = {"I", "II", "III"};
    
    
    
    //***********************
    //ENIGMA MACHINE SETTINGS
    //***********************
    
    
    //ROTOR I
    //Turning point
    String turning_rotori = "R";
    
    //Initial Position
    String initial_rotori = "B";
    Collections.rotate(Arrays.asList(rotor_inputs[0]), -1 * ((initial_rotori.charAt(0)) - 65));
    
    //Ring Setting
    String ring_rotori = "C";
    int dotPos_rotori = 20;
    
    Collections.rotate(Arrays.asList(rotor_inputs[0]), (ring_rotori.charAt(0)) - 65);
    dotPos_rotori += ring_rotori.charAt(0) - 65;
    
    
    //ROTOR II
    //Turning point
    String turning_rotorii = "F";
    
    //Initial Position
    String initial_rotorii = "C";
    Collections.rotate(Arrays.asList(rotor_inputs[1]), -1 * ((initial_rotorii.charAt(0)) - 65));
    
    //Ring Setting
    String ring_rotorii = "B";
    int dotPos_rotorii = 0;
    
    Collections.rotate(Arrays.asList(rotor_inputs[1]), (ring_rotorii.charAt(0)) - 65);
    dotPos_rotorii += ring_rotorii.charAt(0) - 65;
    
    
    //ROTOR III
    //Turning point
    String turning_rotoriii = "w";
    
    //Initial Position
    String initial_rotoriii = "A";
    Collections.rotate(Arrays.asList(rotor_inputs[2]), -1 * ((initial_rotoriii.charAt(0)) - 65));
    
    //Ring Setting
    String ring_rotoriii = "A";
    int dotPos_rotoriii = 19;
    
    Collections.rotate(Arrays.asList(rotor_inputs[2]), (ring_rotoriii.charAt(0)) - 65);
    dotPos_rotoriii += ring_rotoriii.charAt(0) - 65;
    
    
    String[] ringSettings = {ring_rotori, ring_rotorii, ring_rotoriii};
    String[] initialPos = {initial_rotori, initial_rotorii, initial_rotoriii};
    String[] turningPoint = {turning_rotori, turning_rotorii, turning_rotoriii};
    
    //********************
    //DECODING THE MESSAGE
    //********************
    
    for(int swapCount = 0; swapCount < 2; swapCount++)
    {
      Collections.swap(Arrays.asList(rotor_inputs), 0, 1);
      Collections.swap(Arrays.asList(rotor_wiring), 0, 1);
      Collections.swap(Arrays.asList(ringSettings), 0, 1);
      Collections.swap(Arrays.asList(initialPos), 0, 1);
      Collections.swap(Arrays.asList(turningPoint), 0, 1);
      Collections.swap(Arrays.asList(rotor_order), 0, 1);
      
      for(int rotateCount = 0; rotateCount < 3; rotateCount++)
      {
        Collections.rotate(Arrays.asList(rotor_inputs), -1);
        Collections.rotate(Arrays.asList(rotor_wiring), -1);
        Collections.rotate(Arrays.asList(ringSettings), -1);
        Collections.rotate(Arrays.asList(initialPos), -1);
        Collections.rotate(Arrays.asList(turningPoint), -1);
        Collections.rotate(Arrays.asList(rotor_order), -1);
        
        while(!(rotor_inputs[0][0]).equals(initialPos[0]))
        {
          Collections.rotate(Arrays.asList(rotor_inputs[0]), -1);
        }
        Collections.rotate(Arrays.asList(rotor_inputs[0]), (ringSettings[0].charAt(0)) - 65);
        
        while(!(rotor_inputs[1][0]).equals(initialPos[1]))
        {
          Collections.rotate(Arrays.asList(rotor_inputs[1]), -1);
        }
        Collections.rotate(Arrays.asList(rotor_inputs[1]), (ringSettings[1].charAt(0)) - 65);
        
        while(!(rotor_inputs[2][0]).equals(initialPos[2]))
        {
          Collections.rotate(Arrays.asList(rotor_inputs[2]), -1);
        }
        Collections.rotate(Arrays.asList(rotor_inputs[2]), (ringSettings[2].charAt(0)) - 65);
        
        decrypt = "";
        
        for(int count2 = 0; count2 < message.length(); count2++)
        {
          //***************************
          //STEP 1: ROTATING THE ROTORS
          //***************************
          
          //ROTOR I
          Collections.rotate(Arrays.asList(rotor_inputs[0]), -1); 
          
          
          //ROTOR II (Condition 1)
          if(Arrays.asList(rotor_inputs[0]).indexOf(turningPoint[0]) == ((ringSettings[0].charAt(0)) - 65))
          {
            Collections.rotate(Arrays.asList(rotor_inputs[1]), -1);
            //System.out.println("ROTATE 2");
            
            //ROTOR III
            if(Arrays.asList(rotor_inputs[1]).indexOf(turningPoint[1]) == ((ringSettings[1].charAt(0)) - 65))
            {
              Collections.rotate(Arrays.asList(rotor_inputs[2]), -1);
              //System.out.println("ROTATE 3");
            }
          }
          
          
          //ROTOR II (Condition 2)
          if((Arrays.asList(rotor_inputs[0]).indexOf(Character.toString((char)(((int)(turningPoint[0].charAt(0))) + 1))) == ((ringSettings[0].charAt(0)) - 65)) && (Arrays.asList(rotor_inputs[1]).indexOf("E") == ((ringSettings[1].charAt(0)) - 65)))
          {
            Collections.rotate(Arrays.asList(rotor_inputs[1]), -1);
            //System.out.println("ROTATE 2");
            
            //ROTOR III
            if(Arrays.asList(rotor_inputs[1]).indexOf(turningPoint[1]) == ((ringSettings[1].charAt(0)) - 65))
            {
              Collections.rotate(Arrays.asList(rotor_inputs[2]), -1);
              //System.out.println("ROTATE 3");
            }
          }
          
          //System.out.println("Input: " + message.charAt(count2));
          
          
          //*****************************************
          //STEP 2: PASSING CHARACTERS THROUGH ROTORS
          //*****************************************
          
          //*STATIC ROTOR*
          int outputPos_staticRotor = Arrays.asList(static_rotor).indexOf(Character.toString(message.charAt(count2)));
          
          
          
          //*ROTOR I*
          //Entering Rotor
          String enter_rotori = Arrays.asList(rotor_inputs[0]).get(outputPos_staticRotor);
          
          //Converting in Rotor
          String convert_rotori = Arrays.asList(rotor_wiring[0]).get((enter_rotori.charAt(0))-65); 
          
          //Output of Rotor
          String outputPos_rotori = Integer.toString(Arrays.asList(rotor_inputs[0]).indexOf(convert_rotori));
          //System.out.println("Output i: " + Arrays.asList(static_rotor).get(Integer.parseInt(outputPos_rotori)));
          
          
          
          //*ROTOR II*
          //Entering Rotor
          String enter_rotorii = Arrays.asList(rotor_inputs[1]).get(Integer.parseInt(outputPos_rotori));
          
          //Converting in Rotor
          String convert_rotorii = Arrays.asList(rotor_wiring[1]).get((enter_rotorii.charAt(0))-65); 
          
          //Output of Rotor
          String outputPos_rotorii = Integer.toString(Arrays.asList(rotor_inputs[1]).indexOf(convert_rotorii));
          //System.out.println("Output ii: " + Arrays.asList(static_rotor).get(Integer.parseInt(outputPos_rotorii)));
          
          
          
          //*ROTOR III*
          //Entering Rotor
          String enter_rotoriii = Arrays.asList(rotor_inputs[2]).get(Integer.parseInt(outputPos_rotorii));
          
          //Converting in Rotor
          String convert_rotoriii = Arrays.asList(rotor_wiring[2]).get((enter_rotoriii.charAt(0))-65); 
          
          //Output of Rotor
          String outputPos_rotoriii = Integer.toString(Arrays.asList(rotor_inputs[2]).indexOf(convert_rotoriii));    
          //System.out.println("Output iii: " + Arrays.asList(static_rotor).get(Integer.parseInt(outputPos_rotoriii)));
          
          
          
          //*REFLECTOR*
          //Entering Reflector
          String enter_reflector = Arrays.asList(reflector_input).get(Integer.parseInt(outputPos_rotoriii));
          
          //Converting in Reflector 
          String convert_reflector = Arrays.asList(reflector).get((enter_reflector.charAt(0))-65);
          
          //Output of Reflector
          int outputPos_reflector = (Arrays.asList(reflector_input).indexOf(convert_reflector));
          //System.out.println("Output reflector: " + Arrays.asList(static_rotor).get((outputPos_reflector)));
          
          
          
          //*ROTOR III*
          //Entering Rotor
          String enter2_rotoriii = Arrays.asList(rotor_inputs[2]).get(outputPos_reflector);  
          
          //Converting in Rotor
          String convert2_rotoriii = Character.toString((char)((Arrays.asList(rotor_wiring[2]).indexOf(enter2_rotoriii)) + 65)); 
          
          //Output of Rotor
          int outputPos2_rotoriii = Arrays.asList(rotor_inputs[2]).indexOf(convert2_rotoriii);
          //System.out.println("Output iii: " + Arrays.asList(static_rotor).get(outputPos2_rotoriii));
          
          
          
          //*ROTOR II*
          //Entering Rotor
          String enter2_rotorii = Arrays.asList(rotor_inputs[1]).get(outputPos2_rotoriii); 
          
          //Converting in Rotor
          String convert2_rotorii = Character.toString((char)((Arrays.asList(rotor_wiring[1]).indexOf(enter2_rotorii)) + 65)); 
          
          //Output of Rotor
          int outputPos2_rotorii = Arrays.asList(rotor_inputs[1]).indexOf(convert2_rotorii);
          //System.out.println("Output ii: " + Arrays.asList(static_rotor).get(outputPos2_rotorii));
          
          
          
          //*ROTOR I*
          //Entering Rotor
          String enter2_rotori = Arrays.asList(rotor_inputs[0]).get(outputPos2_rotorii); 
          
          //Converting in Rotor 
          String convert2_rotori = Character.toString((char)((Arrays.asList(rotor_wiring[0]).indexOf(enter2_rotori)) + 65)); 
          
          //Output of Rotor
          int outputPos2_rotori = Arrays.asList(rotor_inputs[0]).indexOf(convert2_rotori);
          //System.out.println("Output i: " + Arrays.asList(static_rotor).get(outputPos2_rotori) + "\n");
          
          
          
          decrypt += Arrays.asList(static_rotor).get(outputPos2_rotori);
        }

        if(decrypt.equals("THEENIGMAMACHINE"))
        {
          System.out.println("Encrypted: " + message + "\nDecrypted: " + decrypt + "\nRotor Order: " + Arrays.asList(rotor_order));
        }
      }
    }
  }
}
