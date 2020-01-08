package ee.taltech.twentyonebackend.pojo;

public enum  RoleName {
    USER,
    PM,
    ADMIN;

    public String toSpringRole(){
        return "ROLE_" + this.name();
    }
}
