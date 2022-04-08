/**
 * Version 1.2 - Permet l'interaction avec l'utilisateur
 * 
 * Version 1.0 d'une appli bancaire simplifiée offrant la possibilitée de créer des clients, des comptes bancaires associés et des opérations ou
 * transactions bancaires sur ceux-ci telles que : versement, retrait ou virement 
 * + permet d'afficher l'historique des transactions sur un compte
 * + la gestion des cas particuliers est rudimentaire ici puisque la notion d'exception n'a pas encore été abordée
 * 
 * @author El-Babili ft. Lefort - 2022
 * 
 */

package fr.fms;

import java.util.Date;
import java.util.Scanner;

import fr.fms.business.IBankBusinessImpl;
import fr.fms.entities.Current;
import fr.fms.entities.Customer;
import fr.fms.entities.Saving;
public class MyBankInteractive {

	public static void main(String[] args) {
		//représente l'activité de notre banque
		IBankBusinessImpl bankJob = new IBankBusinessImpl();

		//creation of customers & accounts
		Customer robert = new Customer(1, "dupont", "robert", "robert.dupont@xmail.com");
		Customer julie = new Customer(2, "jolie", "julie", "julie.jolie@xmail.com");	
		
		Current firstAccount = new Current(100200300, new Date(), 1500, 200, robert);
		Saving secondAccount = new Saving(200300400, new Date(), 2000, 5.5, julie);
		
		//add accounts to bank
		bankJob.addAccount(firstAccount);
		bankJob.addAccount(secondAccount);
		//System.out.println("liste des comptes : \n" + bankJob.listAccounts());
		
		//Init
		Scanner scanner = new Scanner(System.in);
		
		//Presentation
		System.out.println("Bienvenue dans votre application de banque interactive !");
		System.out.println("Saisir un numéro de compte : ");
		
		bankJob.checkInt(scanner);
		long answer = scanner.nextInt();
		
		try {			
			if(bankJob.isAccountExists(answer)) {
				String name = bankJob.consultAccount(answer).getCustomer().getFirstName();
				System.out.println("Bienvenue " + name + ", que souhaitez-vous faire ?");
			} else {
				throw new Exception("Le compte n'existe pas.");
			}
			
		} catch(Exception e) {
			System.out.println("Exception : " + e);
			
		} finally {
			if(bankJob.isAccountExists(answer)) {
				bankJob.displayMenu();
				
				bankJob.checkInt(scanner);
				int choice = scanner.nextInt();
				
				while(choice != 6) {
					
					switch(choice) {
						case 1 : //versement
							bankJob.payement(answer, scanner);
							break;
							
						case 2 : //retrait
							bankJob.withdrawal(answer, scanner);
							break;
							
						case 3 : //virement
						try {
							bankJob.customerTransfert(answer, scanner);
						} catch (Exception e) {
							System.out.println("Exception : " + e);
						}
							break;
							
						case 4 : //affichage des infos du compte
							System.out.println(bankJob.consultAccount(answer));
							break;
							
						case 5 : //Liste des opérations
							System.out.println(bankJob.listTransactions(answer));
							break;
							
						default: 
							System.out.println("Merci de renseigner une choix valide.");
								
					}
					
					bankJob.displayMenu();
					
					bankJob.checkInt(scanner);
					choice = scanner.nextInt();
				}

			}
			
			System.out.println("Au revoir !");
			scanner.close();
		}
		
	}

}
