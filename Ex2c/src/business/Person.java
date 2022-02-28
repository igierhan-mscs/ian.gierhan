package business;
import java.time.LocalDateTime;

public class Person {
    private int personId;
    private String firstName;
    private String lastName;
    private String userName;
    private LocalDateTime updated = LocalDateTime.now();

    public Person() {
        this.personId = 0;
        this.firstName = "";
        this.lastName = "";
        this.userName = "";
    }
    public Person(int personId, String firstName, String lastName, String userName) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public void setPersonId(int personId)           { this.personId = personId; }
    public int getPersonId()                        { return this.personId; }

    public void setFirstName(String firstName)      { this.firstName = firstName; }
    public String getFirstName()                    { return this.firstName; }

    public void setLastName(String lastName)        { this.lastName = lastName; }
    public String getLastName()                     { return this.lastName; }

    public void setUserName(String userName)        { this.userName = userName; }
    public String getUserName()                     { return this.userName; }

    public void setUpdated()                        { this.updated = LocalDateTime.now(); }
    public LocalDateTime getUpdated()               { return updated; }

}
