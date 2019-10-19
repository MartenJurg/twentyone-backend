package ee.taltech.twentyonebackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "userdata", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        })
})
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NotBlank
    private int cash;

    @NotBlank
    private int house;

    @NotBlank
    private int fame;

    @NotBlank
    private int strength;

    @NotBlank
    private int defence;

    @NotBlank
    private int cooking;

    @NotBlank
    private int thieving;

    @NotBlank
    private int crafting;

    @NotBlank
    private int beverage;

    public UserData(@NotBlank @Size(min = 3, max = 50) String username) {
        this.username = username;
        this.beverage = 0;
        this.cash = 50;
        this.cooking = 0;
        this.crafting = 0;
        this.defence = 0;
        this.fame = 0;
        this.house = 0;
        this.thieving = 0;
        this.strength = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getCash() {
        return cash;
    }

    public int getHouse() {
        return house;
    }

    public int getFame() {
        return fame;
    }

    public int getStrenght() {
        return strength;
    }

    public int getDefence() {
        return defence;
    }

    public int getCooking() {
        return cooking;
    }

    public int getThieving() {
        return thieving;
    }

    public int getCrafting() {
        return crafting;
    }

    public int getBeverage() {
        return beverage;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public void setFame(int fame) {
        this.fame = fame;
    }

    public void setStrenght(int strenght) {
        this.strength = strenght;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setCooking(int cooking) {
        this.cooking = cooking;
    }

    public void setThieving(int thieving) {
        this.thieving = thieving;
    }

    public void setCrafting(int crafting) {
        this.crafting = crafting;
    }

    public void setBeverage(int beverage) {
        this.beverage = beverage;
    }
}
