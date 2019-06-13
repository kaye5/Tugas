public class ComissionedEmployee extends Employee implements Tax{
    protected double comission;
    
    public ComissionedEmployee(String name,double salary,double comission){
        this.name = name; 
        this.salary = name;
        this.comission =  comission;
    }

    boolean isNilaiValid(double nilai){
        if(nilai>=0){
            return true;
        }
        return false;
    }
    
    
    public void setComission(double comission){
        if(isNilaiValid(comission)){
            this.comission = comission;
        }
        else {
            throw new RuntimeException("error data tidak valid");
        }
    }
    
    public double getComission(){
        return this.comission;
    }
    public double getTakeHomePay(){
        return getSalary() + getComission() - getTax();
    }
    public double getTax() {
        return (getSalary()+getComission())*0.1;
    }
}
