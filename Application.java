
/**
 * Write a description of class application here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Application
{
    private String company;
    private String position;
    private String status;
    public Application (String company, String position, String status){
        this.company= company;
        this.position= position;
        this.status= status;
    }
    public String getCompany(){
        return this.company;
    }
    public String getPosition(){
    return this.position;    
    }
    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setPosition(String position){
        this.position= position;
    }
    public void setCompany(String company){
        this.company= company;
    }
}

