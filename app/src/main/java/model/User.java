package model;

public class User {

     private String email,password, mobile;

     public User(String mobile,String email,String password){
         this.email =email;
         this.mobile=mobile;

         this.password=password;
     }


    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

