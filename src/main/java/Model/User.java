/*
 * package Model;
 * 
 * public class User { private int id; private String username; private String
 * password; private String email; private String role; //
 * 
 * public User() {}
 * 
 * public User(String username, String password, String email, String role) {
 * this.username = username; this.password = password; this.email = email;
 * this.role = role; }
 * 
 * public int getId() { return id; }
 * 
 * public void setId(int id) { this.id = id; }
 * 
 * public String getUsername() { return username; }
 * 
 * public void setUsername(String username) { this.username = username; }
 * 
 * public String getPassword() { return password; }
 * 
 * public void setPassword(String password) { this.password = password; }
 * 
 * public String getEmail() { return email; }
 * 
 * public void setEmail(String email) { this.email = email; }
 * 
 * public String getRole() { return role; }
 * 
 * public void setRole(String role) { this.role = role; } }
 */

package Model;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;
    private String address;
    private String gender;

    public User() {}

    public User(String firstname, String lastname, String username, String password, String email, String phone, String role, String address, String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.address = address;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
