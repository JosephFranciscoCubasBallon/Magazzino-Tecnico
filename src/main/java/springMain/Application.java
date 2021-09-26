package springMain;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.joseph.entities.Ricambio;
import com.joseph.entities.Tecnico;
import com.joseph.model.IService;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IService service = appContext.getBean("serviceImpl", IService.class);
		
		//Console App
		Scanner keyboard = new Scanner(System.in);
		do {
		
		System.out.println("Benvenuto, Cosa vorresti fare?\nGET\nSET\nUPDATE\nDELETE");
		String command=keyboard.nextLine();
		
			switch(command.toUpperCase()) {
				case "GET":
					System.out.println("Vuoi fare una ricerca per codice ricambio o per entity? (Code/entity)");
					String ris=keyboard.nextLine();
					switch(ris.toUpperCase()) {
						case "CODE":
							System.out.println("digita il codice ricambio");
							System.out.println(service.getRicambio(keyboard.nextLine()).toString());
							break;
						case "ENTITY":
							System.out.println("digita l'entity da cercare (tecnico/ricambio): ");
							String entity= keyboard.nextLine();
							switch(entity.toUpperCase()) {
								case "TECNICO":
									System.out.println(service.getAllTecnici().toString());
									break;
								case "RICAMBIO":
									System.out.println(service.getAllRicambi().toString());
									break;
							}
							System.out.println("Digita l'id");
							System.out.println(service.getEntity(Integer.parseInt(keyboard.nextLine()), entity).toString());
							break;
						default:
							System.out.println("deve essere CODE o ENITITY riprova");	
						break;
					}
				break;
				case "SET":
					System.out.println("vuoi inserire un nuovo tecnico o ricambio?");
					switch(keyboard.nextLine().toUpperCase()) {
						case "TECNICO":
							System.out.println("username: ");
							String username=keyboard.nextLine();
							System.out.println("password:");
							String password=keyboard.nextLine();
							service.setEntity(new Tecnico(0,username,password));
						break;
						case "RICAMBIO":
							System.out.println("name ricambio:");
							String name= keyboard.nextLine();
							System.out.println("code ricambio:");
							String code=keyboard.nextLine();
							System.out.println("buyPrice(must be double):");
							double buyPrice= Double.parseDouble(keyboard.nextLine());
							System.out.println("sellPrice(must be double):");
							double sellPrice=Double.parseDouble(keyboard.nextLine());
							System.out.println("quantity:");
							int quantity= Integer.parseInt(keyboard.nextLine());
							System.out.println("position ricambio:");
							String position= keyboard.nextLine();
							service.setEntity(new Ricambio(0,name,code,buyPrice,sellPrice,quantity,position));
							break;
					}
				break;
				case "UPDATE":
					System.out.println("vuoi fare l'update di un tecnico o un ricambio?");
					String entity=keyboard.nextLine();
					System.out.println("digita l'id del "+ entity +" da fare l'update");
					int id=Integer.parseInt(keyboard.nextLine());
					System.out.println(service.updateEntity(id, entity));
				break;
				case "DELETE":
					System.out.println("vuoi fare delete di un tecnico o un ricambio?");
					String enti=keyboard.nextLine();
					System.out.println("scegli l'id del "+enti+ " da cancellare");
					int i=Integer.parseInt(keyboard.nextLine());
					service.deleteEntity(i, enti);
				break;
				
			}
			
		}while(true);
	}

}
