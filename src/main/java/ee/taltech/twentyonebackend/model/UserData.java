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
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    private int cash;

    private int house;

    private int fame;

    private int strength;

    private int defence;

    private int cooking;

    private int thieving;

    private int crafting;

    private int beverage;

    private int cookingxp;

    private int thievingxp;

    private int craftingxp;

    private int beveragexp;

    private int defencexp;

    private int strenghtxp;

    public UserData() {
    }

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
        this.cookingxp = 0;
        this.thievingxp = 0;
        this.craftingxp = 0;
        this.beveragexp = 0;
        this.defencexp = 0;
        this.strenghtxp = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getCookingxp() {
        return cookingxp;
    }

    public int getThievingxp() {
        return thievingxp;
    }

    public int getCraftingxp() {
        return craftingxp;
    }

    public int getBeveragexp() {
        return beveragexp;
    }

    public int getDefencexp() {
        return defencexp;
    }

    public int getStrenghtxp() {
        return strenghtxp;
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

    public int getStrength() {
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setCookingxp(int cookingxp) {
        this.cookingxp = cookingxp;
    }

    public void setThievingxp(int thievingxp) {
        this.thievingxp = thievingxp;
    }

    public void setCraftingxp(int craftingxp) {
        this.craftingxp = craftingxp;
    }

    public void setBeveragexp(int beveragexp) {
        this.beveragexp = beveragexp;
    }

    public void setDefencexp(int defencexp) {
        this.defencexp = defencexp;
    }

    public void setStrenghtxp(int strenghtxp) {
        this.strenghtxp = strenghtxp;
    }
}
