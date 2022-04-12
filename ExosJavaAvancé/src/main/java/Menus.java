import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Menus {
    public static void main(String[] args) {        
        try {
        	Scanner scanner = new Scanner(System.in);
        	
        	//Init of text object 
//        	File fileOrder = new File("FileOrder.txt");
//        	FileOutputStream file = new FileOutputStream(fileOrder);
//        	DataOutputStream order = new DataOutputStream(file); //à utiliser quand je gère des flux et que je veux que ça aille vite
        	
            //ObjectOutputStream order = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("order.txt"))));

        	FileWriter writer = new FileWriter("writer.txt");
        	
	        //Initialization
	        String[] entree = {"entrée", "SALADE", "SOUPE", "QUICHE", "AUCUNE"};
	        String[] plats = {"plat", "POULET", "BOEUF", "POISSON", "VEGETARIEN", "VEGAN", "AUCUN"};
	        String[] accompagnements = {"accompagnement", "RIZ", "PATES", "FRITES", "LEGUMES", "AUCUNE"};
	        String[] boissons = {"boisson", "EAU PLATE", "EAU GAZEUSE", "SODA", "VIN", "AUCUNE"};
	        String[] desserts = {"dessert", "TARTE MAISON", "MOUSSE AU CHOCOLAT", "TIRAMISU", "AUCUNE"};
	
	        String[][] menu = {entree, plats, accompagnements, boissons, desserts};
	        //END Initialization
	        
	        //if entry is not an int
	        //while(scanner.hasNextInt() == false) {scanner.next();};
	        System.out.println("Bonjour, combien de menus souhaitez-vous ?");
	        int nbMenus = scanner.nextInt();
	
	        //save choices of each command
	        HashMap<Integer, String> choixMenu = new HashMap<Integer, String>();
	
	        
	        //repeat command * nbMenus
	        for (int i = 1; i <= nbMenus; i++) {
	            System.out.println("Commande numéro " + i);
	
	            for (int j = 0; j < menu.length; j++) {
	                //choice of part of menu (entree, plats, ...)
	                System.out.println("Choix " + menu[j][0] + " :");
	
	                //display plates (of each part of menu)
	                for (int k = 1; k < menu[j].length; k++) {
	                    System.out.print("[" + k + " - " + menu[j][k] + " ]");
	                }
	
	                System.out.println();
	                System.out.println("Que souhaitez-vous comme " + menu[j][0] + " ?");
	
	                //put answers in a tab
	                choixMenu.put(j, menu[j][scanner.nextInt()].toLowerCase());
	            }
	
	            //Resume - display answers for each commend
	            System.out.println("Résumé de la commande numéro " + i);
	            System.out.println(choixMenu.values());
	            System.out.println();
	            
	            try { //try catch inutile
	            	//writeUTF : pour les String ou write Chars pour chaque caractères mais ils sont séparés par des espaces
	            	//order.writeChars("***********Résumé de la commande numéro " + i + " ***********\n");
	            	
	            	writer.write("***********Résumé de la commande numéro " + i + " ***********\n");
	            	
	            	for (HashMap.Entry<Integer, String> entry : choixMenu.entrySet()) {
						String val = entry.getValue();
						//order.writeChars(val + "\n");
						writer.write(val + "\n");
					}
	            	//order.writeChars("\n");	 
	            	writer.write("\n");
	  
	            } catch(Exception e) {
	            	System.out.println("Exception : " + e);
	            }
	        }
	        
	        //order.writeChars("Bon appétit !");
	        //order.close();
	        writer.close();
	        scanner.close();
        
        } catch (Exception e) {
        	System.out.println("Exception : " + e);
        }
    }
}

