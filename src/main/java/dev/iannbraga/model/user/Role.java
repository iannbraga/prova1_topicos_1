package dev.iannbraga.model.user;

public enum Role {
    ADMIN(1, "ADMIN"),
    CLIENT(2,"CLIENT");
    

    private int id;
    private String label;

    Role(int id, String label){
        this.id = id;
        this.label = label;
    }

    public int getId(){
        return this.id;
    }

    public String getLabel(){
        return this.label;
    }

    public static Role valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for(Role role : Role.values()) {
            if (id.equals(role.getId()))
                return role;
        } 
        throw new IllegalArgumentException("Id inválido:" + id);
    }
}
