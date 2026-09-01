import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class FileManager
{
    public static ArrayList<Application> loadApplications(){
        ArrayList<Application> applications = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split("\\|");
                Application application = new Application (parts[0].trim(), parts[1].trim(), parts[2].trim());
                applications.add(application);
            }
            reader.close();
        } catch (IOException e){
            System.out.println("No saved applications found. ");
        }
        return applications; 
        }
    
    private static final String FILE_NAME = "applications.txt";
    public static void saveApplications(ArrayList<Application> applications) {
        try{
            FileWriter writer = new FileWriter(FILE_NAME);
            for (Application  application : applications) {
                writer.write(application.getCompany() + "|" + application.getPosition() + "|" + application.getStatus() );
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving applications . ");
        }
    }
}
