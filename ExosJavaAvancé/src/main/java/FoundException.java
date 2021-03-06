import java.util.Date;
import java.util.Scanner;

public class FoundException {

	public static void main(String[] args) {
		//1.1
		Date date = null;
		Date today = new Date();
		
		//Pour afficher chaque date, créer un tableau avec toutes les dates et faire une boucle dessus avec un try/catch à l'intérieur
		
//		try {
//			System.out.println(date.getClass().getName());
//		} catch (Exception e ){
//			System.out.println("Ah, problème : " + e);
//		}
//		
//		try {
//			System.out.println(today.getClass().getName());
//		} catch (Exception e ){
//			System.out.println("Ah, problème sur : " + e);
//		}
		
		//1.2 -- ajouter un try/catch sur un exercice précédent
		jeu();

	}
	
	public static void jeu() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Souhaitez vous jouer à notre jeu ? O/N");
		//save answer of player
		String answer = scan.next();
		
		//if player wants to continue to play
		while(answer.equals("O") || answer.equals("o")) {
			//generate random number
			int num = (int)(Math.random()*100) + 1;
			
			//count how much try players done
			int count = 1;
			
			System.out.println("Veuillez saisir un nombre compris entre 1 et 100 :");
			try {
				//save number in value
				int value = scan.nextInt();
				
				//attempt a value until value == num
				while(value != num) {
					if(value > num ) {
						System.out.println("Saisir une valeur plus petite.");
					} else if(value < num) {
						System.out.println("Saisir une valeur plus grande.");
					}
					count++;
					value = scan.nextInt();
				}
				
				System.out.println("Bien joué ! Trouvé en " + count + " coups ! Voulez vous rejouer ? O/N");

			} catch(Exception e) {
				System.out.println("Vous n'avez pas saisi un nombre : " + e);
				//e.printStackTrace();
			} finally {
				//save answer to know if loop continue or break
				answer = scan.next();
			}
			
		}
		System.out.println("Au revoir !");
		
		scan.close();
	
	}

}
