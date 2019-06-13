public class ComissionedEmployee extends Employee implements Tax{
    protected double comission;
 
    
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
    public double getComissionEmployee(){
        return getSalary() + this.comission;
    }
    public double getTax() {
        return getSalary()*0.1;
    }
}
