package Users;

public class Admin extends User {
    private String password ;
    //private double sueldo;
    public Admin(int idCard, String name, String password){
        super(idCard,name,"admin");
        this.password = password;
    }

    public Admin(){
        super();
    }
    public String getPassword() {
        return password;
    }
}
