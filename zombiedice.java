
 /*
	 - Started off by having 3 methods which are Main, users() and result().
	 - Started the frist part by coding the main which is the introduction of the game and re-calling the method of users().
	 - Started the secound part by coding the result() method which is the tracking of the Brains, Footprints and Shutguns of each player turn.
	 - Started the third part of by coding the users() methid which the Menu, taking input of users and displaying the score on screen.
	 - Then would make the last edit to make it tidy by joining the codes together making the Zombie game.
	 
*/
 
 
 import java.util.*;

  public class ZombieDice { 
	
	public static void main( String[]args ) {
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("  <       Weclome To Zombie Dice By Steve Jackson Games.      >");
		System.out.println("  <             Please Enter Number Of Players.               >");
		System.out.println("------------------------------------------------------------------");
		System.out.println("");
		
		Scanner in = new Scanner(System.in);   
		 
		 // re-calling game method
			users();
		
	} // close Main() method
		 
	// taking in multiple users for the game  
  public static void users()	{
	
		int x;
		boolean play = true;
		
	  Scanner in = new Scanner(System.in);
		
		System.out.println("----------------------------------------");
		System.out.println(" <  Enter number of players:   >"); 
		System.out.println("");
		x = in.nextInt();
		
		System.out.println("----------------------------------------");
		in.nextLine();
	
	// keeps in a loop until user enters 2 or more users for the game
		while ( x <= 1){
			
				System.out.println(""); 
				System.out.println("--------------------------------------------------------");
				System.out.println(" <   Error, must be 2 or more players to play.      >");
				System.out.println(" <      Please re-enter number of players.          >");
				System.out.println("--------------------------------------------------------");
				System.out.println("");
				System.out.println("----------------------------------------");
				System.out.println(" <  Enter number of players:   >"); 
				System.out.println("");
				
				x = in.nextInt();
				System.out.println("----------------------------------------");
				in.nextLine();

			}
			
		//x array takes in number of players
		String names[] = new String[x];
		
		System.out.println("");
		System.out.println("-----------------------------------");  
		System.out.println(" <   Enter " + x +" names below    >");
		System.out.println("-----------------------------------");
	
		//The array when player finishes their turn and stores brain score for next turn
		int totalBrain[] = new int[names.length]; 
		
			
			for ( int i = 0; i < names.length; i++ )
		{
			  names[i] = in.nextLine();
				totalBrain[i] = 0;
		}
				
				System.out.println("");
		        System.out.println("----------------------------------------");
				System.out.println(" <    The players playing are    >");
				System.out.println("----------------------------------------");
			
			  // For loop to keep on printing out the current user name
		    for ( int i = 0 ; i < names.length ; i++ )
			
			{ 
					
					System.out.println("---------------------------");
					System.out.println(" <       " + names[i] + "       >");
					System.out.println("---------------------------");
					
				}
				
				System.out.println("");
				System.out.println("--------------------------------------------------");
				System.out.println(" <    Lets play ZOMBIE DICE, Grrrr!!!    >");
				System.out.println("--------------------------------------------------");
	
				
					System.out.println("");
				    System.out.println("------------------------------------------------------------------");
				    System.out.println(" <         Please enter a choice in the menu              >");
					System.out.println(" <            To Roll the dice press 1                    >");
					System.out.println(" <      To see current score and end turn press 2         >");
					System.out.println(" <            To end this game press 3                    >");
					System.out.println("------------------------------------------------------------------");
					
			// An array created to keep track of the brains 
		int brainscore[][] = new int [names.length][2];	
					
			
			
	while ( play = true ) {
	
		// total score for brains
		int totalscore[][] = new int[2][1];
		
		totalscore[0][0] = 0; 
		totalscore[1][0] = 0;
		
		
		
	  for	( int i = 0; i < names.length; i++ ){
		
		// shortgun score more than 3 end user turn
		int shotgunscore = 0; 
		
		 int bscore = 0; 
			
			System.out.println("");
			System.out.println("-------------------------------");
			System.out.println(" <   It's " + names[i]+" turn  >");
			System.out.println("-------------------------------");
		
			for(int h = 0; h < 100; h++){ // The h will be total number of turns
				
				
				int options = in.nextInt(); // takes in 1 ,2 or 3 from the Menu
				
					// To roll the dices 
				 if	( options == 1 ) {
					 
					totalscore = result();	
					bscore = 0;
					bscore += totalscore[0][0];
					shotgunscore += totalscore[1][0];
					
					bscore += totalBrain[i];
					totalBrain[i] += bscore;
					
					System.out.println("");
					System.out.println("----------------------------");
					System.out.println(" <  Total brains: " +totalBrain[i] +"  >");
					System.out.println("");
					System.out.println(" <  Total Shotguns: " +shotgunscore +"  >");
					System.out.println("----------------------------");
					
					
					System.out.println("");
				    System.out.println("------------------------------------------------------------------");
				    System.out.println(" <         Please enter a choice in the menu              >");
					System.out.println(" <            To Roll the dice press 1                    >");
					System.out.println(" <      To see current score and end turn press 2         >");
					System.out.println(" <            To end this game press 3                    >");
					System.out.println("------------------------------------------------------------------");
					
					
				}
				
				 // To see current score and end turn of current user
				if	( options == 2 )
				
				{
					System.out.println("");
					System.out.println("--------------------------------------------");
					System.out.println(" < " +names[i] +" : " + totalBrain[i] + " Brains >");
					System.out.println("");
					System.out.println(" < " +names[i] +" : " + shotgunscore + " Shotguns >");
					System.out.println("--------------------------------------------");
					
					break;
				
				}
				
				// Current user turn is over if total shortgun score is 3 or more
				if	( shotgunscore >= 3 )
				
				{ 		
						System.out.println("");
						System.out.println("-----------------------------------");
						System.out.println(" < Third shotgun!!! " +names[i] +" turn is over  >");
						System.out.println("-----------------------------------");
						
						totalBrain[i] = 0;
						
						break; 
				}
				
				 // If users decide to end the game and exit
				else if	( options == 3 )
				
				{
					System.out.println("");
					System.out.println("--------------------------------------------");
					System.out.println(" < " +names[i] +" : " + totalBrain[i] + " Brains >");
					System.out.println("");
					System.out.println(" < " +names[i] +" : " + shotgunscore + " Shotguns >");
					System.out.println("--------------------------------------------");
					System.out.println("");
					System.out.println("---------------------------------------");
					System.out.println(" < Goodbye, Thanks for playing! >");
					System.out.println("---------------------------------------");
					
					System.exit(0);
			    }
				
				 // If the current user gets 13 or more brains is the winner
				if	( totalBrain[i] >= 13)
				
				{ 
			
					System.out.println("");
					System.out.println("---------------------------------------");
					System.out.println(" < "+names[i] +" wins for eating 13 Brains >");
					System.out.println("---------------------------------------");
				}		
			}	
			
		} // closes for loop
		
	} // closes while loop
	
} // closes users() method

	
	// method to play the dice with returning value 
  public static int[][] result() {
		 
		 // shortgun score tracker for the game
		int shotgunscore = 0; 
		 
			// Green dice array
			String Green[] = { " Shotgun"," Footprint"," Footprint"," Brain"," Brain"," Brain" };   
			
			// Yellow dice array
			String Yellow[] = { " Shotgun"," Shotgun"," Footprint"," Footprint"," Brain"," Brain" };

			// Red dice array
			String Red[] = { " Shotgun"," Shotgun"," Shotgun"," Footprint"," Footprint"," Brain" };
					
		Random r = new Random();
		
			//Red array 
		int x = r.nextInt( Red.length);
		
			//Green array
		int y = r.nextInt( Green.length);
		
			//Yellow array
		int z = r.nextInt( Yellow.length);


			System.out.println("------------------------------");
			System.out.println(" <	Green Dice 1: " +Green[y] +" >");
			System.out.println(" <	Yellow Dice 2: " +Yellow[z] +" >");
			System.out.println(" <	Red Dice 3: " +Red[x] +" >");
			System.out.println("------------------------------");
		
			// brains score tracker
		int brainscore = 0;
		
		//Counting the brains section below
	
	if	((( Red[x] == " Brain" && Red[x]!= Green[y] && Red[x]!= Yellow[z] )) || (( Green[y] == " Brain" && Green[y]!= Yellow[z] && Green[y]!= Red[x] )) ||(( Yellow[z] == " Brain" && Yellow[z]!= Red[x] && Yellow[z]!= Green[y] ))) 

	{
		brainscore+=1;
	}

	if	(( Red[x] == " Brain" && Green[y] == " Brain" ) && (( Red[x]!= Yellow[z] )) || (( Red[x] == " Brain" && Yellow[z] == " Brain" ) && (Red[x]!= Green[y] )) || (( Green[y] == " Brain" && Yellow[z] == " Brain" ) && ( Green[y]!= Red[x] )))

	{
		brainscore+=2;
	}

	if	( Red[x] == " Brain" && Green[y] == " Brain" && Yellow[z] == " Brain" )

	{
		brainscore+=3;
	}
	
	//Counting the footprints section below

		int footprint = 0;
	
	if	((( Red[x] == " Footprint" && Red[x] != Green[y] && Red[x] != Yellow[z] )) || (( Green[y] == " Footprint" && Green[y] != Yellow[z] && Green[y] != Red[x] )) || ((Yellow[z] == " Footprint" && Yellow[z] != Red[x] && Yellow[z] != Green[y] )))
	
	{
		footprint+=1;
	}

	if	(( Red[x] == " Footprint" && Green[y] == " Footprint" ) && (( Red[x] != Yellow[z] )) || (( Red[x] == " Footprint" && Yellow[z] == " Footprint" ) && ( Red[x] != Green[y] )) || (( Green[y] == " Footprint" && Yellow[z] == " Footprint" ) && ( Green[y] != Red[x] )))
	
	{
		footprint+=2;
	}
	
	if	( Red[x] == " Footprint" && Green[y] == " Footprint" && Yellow[z] == " Footprint" )
	
	{ 
		footprint+=3;
		
		 System.out.println("");
		 System.out.println("-----------------------------------");
		 System.out.println(" < You Escaped, Happy Days! >");
		 System.out.println("-----------------------------------");
		 
	}
			
			System.out.println("");
			System.out.println("------------------------");
			System.out.println(" < Brain: " +brainscore +" >");
			System.out.println(" < Footprint: " +footprint +" >");
			System.out.println(" < Shotgun: " +shotgunscore +" >");
			System.out.println("------------------------");
			 
		// Option to roll dice again or end the user current turn
	if ( footprint >= 0 ){
		System.out.println("");
		System.out.println("-----------------------------------------");
		System.out.println(" < Do you want to roll dice or finish your turn? >");
		System.out.println("-----------------------------------------");
		
	}
	
		//Counting the shutguns section below

	
	if	((( Red[x] == " Shotgun" && Red[x]!= Green[y] && Red[x] != Yellow[z] )) || (( Green[y] == " Shotgun" && Green[y]!= Yellow[z] && Green[y] != Red[x] )) || (( Yellow[z] == " Shotgun" && Yellow[z]!= Red[x] && Yellow[z]!= Green[y] )))

	{
		shotgunscore+=1;
	}

	if	(( Red[x] == " Shotgun" && Green[y] == " Shotgun" ) && (( Red[x] != Yellow[z] )) || (( Red[x] == " Shotgun" && Yellow[z] == " Shotgun" ) && ( Red[x] != Green[y] )) || (( Green[y] == " Shotgun" && Yellow[z] == " Shotgun" ) && ( Green[y] != Red[x] )))
	
	{
		shotgunscore+=2;
	}
	
	if	( Red[x] == " Shotgun" && Green[y] == " Shotgun" && Yellow[z] == " Shotgun" )
	
	{
		shotgunscore+=3;
		
		 System.out.println("");
	     System.out.println("-----------------------------------");
		 System.out.println(" < Third shotgun!!!, Game over >");
		 System.out.println("-----------------------------------");
	}
	
	if	( shotgunscore >= 3 )
	
	{
		 System.out.println("");
	     System.out.println("-----------------------------------");
		 System.out.println(" < Third shotgun!!!, Game over >");
		 System.out.println("-----------------------------------");
	}

	
		// array for re-turning brains score & shotguns score total in the game
		int scorekeeper[][] = new int[2][1]; 

		// Keeping track of both brains and shotguns score in the game
		scorekeeper[0][0] = brainscore; 
		scorekeeper [1][0] = shotgunscore; 

	    return scorekeeper;

	}	// Closes result() method

} // Closes class

