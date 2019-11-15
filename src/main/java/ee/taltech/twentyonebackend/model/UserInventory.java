package ee.taltech.twentyonebackend.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "userinventory", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"})
})
public class UserInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String username;
    private int paper;
    private int watches;
    private int phones;
    private int gloves;
    private int hats;
    private int sweaters;

    public UserInventory() {
    }

    public UserInventory(@NotBlank @Size(min = 3, max = 50) String username) {
        this.username = username;
        this.paper = 0;
        this.watches = 0;
        this.phones = 0;
        this.gloves = 0;
        this.hats = 0;
        this.sweaters = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getPaper() {
        return paper;
    }

    public int getWatches() {
        return watches;
    }

    public int getPhones() {
        return phones;
    }

    public int getGloves() {
        return gloves;
    }

    public int getHats() {
        return hats;
    }

    public int getSweaters() {
        return sweaters;
    }

    public void setPaper(int paper) {
        this.paper = paper;
    }

    public void setWatches(int watches) {
        this.watches = watches;
    }

    public void setPhones(int phones) {
        this.phones = phones;
    }

    public void setGloves(int gloves) {
        this.gloves = gloves;
    }

    public void setHats(int hats) {
        this.hats = hats;
    }

    public void setSweaters(int sweaters) {
        this.sweaters = sweaters;
    }
}
