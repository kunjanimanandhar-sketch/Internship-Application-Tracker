import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Application> applications = FileManager.loadApplications();
        boolean running= true;
        while (running ) {
            System.out.println("\nINTERNSHIP APPLICATION TRACKER");
            System.out.println("1. Add Application");
            System.out.println("2. View Application");
            System.out.println("3. Search Application ");
            System.out.println("4. Update Application Status");
            System.out.println("5. Delete Application");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice; 
           if (scanner.hasNextInt()){
               choice= scanner.nextInt();
               scanner.nextLine();
               if (choice < 1 || choice > 6){
                   System.out.println("Invalid option. Please enter a number from 1-6. ");
                   continue;
               }
               
           }else {
               System.out.println("Invalid input. Please enter a number from 1-6");
               scanner.nextLine();
               continue; 
           }
            if(choice==1){
               addApplication(scanner, applications);
                
            }
            else if(choice==2){
                viewApplications(applications);
               
            }
                else if(choice==3){
                searchApplication(scanner, applications);
            }
                else if (choice == 4){
                updateApplication(scanner, applications);
            }else if (choice == 5){
                
                deleteApplication(scanner, applications);
                
            }else if(choice==6){
                running = false;
            }
        }
            scanner.close();
        
    
}
public static void viewApplications(ArrayList<Application> applications){
     if (applications.isEmpty()){
                    System.out.println("No applications found. ");
                }else {
                for (Application application : applications){
                    System.out.println(application.getCompany() + " | " + application.getPosition() + " | " + application.getStatus());
                
                }
            }
}
public static void addApplication(Scanner scanner, ArrayList<Application> applications) {
    System.out.print("Company: ");
                String company = scanner.nextLine();
                System.out.print("Position: ");
                String position = scanner.nextLine();
                System.out.print("Status: ");
                String status = scanner.nextLine(); 
                 Application application = new Application(company,position,status);
                 applications.add(application);
                 FileManager.saveApplications(applications);
                 System.out.println("Application added!");
}
public static void searchApplication(Scanner scanner, ArrayList<Application> applications) {
    System.out.println("Company to search: ");
                String company = scanner.nextLine();
                boolean found = false;
                
                
                for (Application application : applications){
                    if (application.getCompany().equalsIgnoreCase(company)){
                        System.out.println(application.getCompany() + " | " + application.getPosition() + " | " + application.getStatus());
                    found = true;
                    }
                }
                if(!found){
                    System.out.println("Application not found. ");
                }
}
public static void updateApplication(Scanner scanner, ArrayList<Application> applications){
    System.out.print("Company to update: ");
                String company = scanner.nextLine();
                boolean found = false; 
                for(Application application : applications){
                    if (application.getCompany().equalsIgnoreCase(company)){
                        System.out.println(application.getCompany() + " | " + application.getPosition() + " | " + application.getStatus());
                    found = true;
                    System.out.print("New Status: ");
                    String newStatus = scanner.nextLine();
                    application.setStatus(newStatus);
                    FileManager.saveApplications(applications);
                    System.out.println("Application updated!");
                    }
                }
                if(!found){
                    System.out.println("Application not found. ");
                }
}
public static void deleteApplication(Scanner scanner, ArrayList<Application> applications){
    System.out.print("Company to delete: ");
                String company= scanner.nextLine();
                boolean found= false;
                Iterator<Application> iterator = applications.iterator();
                while (iterator.hasNext()){
                    Application application = iterator.next();
                    if (application.getCompany().equalsIgnoreCase(company)){
                        iterator.remove();
                        
                        found=true;
                        FileManager.saveApplications(applications);
                        System.out.println("Application deleted!");
                        break;
                    }
                }
                if(!found){
                    System.out.println("Application not found. ");
                }
}
}


    

