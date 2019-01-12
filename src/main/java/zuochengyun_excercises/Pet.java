package zuochengyun_excercises;


public class Pet {
    
    protected String name;
    
    private String type;
    
    public Pet(String type) {
        this.type = type;
    }
    
    public String getType() {
        
        return this.type;
    }
    
    public String getName() {
        return this.name;
    }

}
