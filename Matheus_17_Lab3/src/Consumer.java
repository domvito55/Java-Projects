/*
Student ID: 301236904
Name: Matheus Teixeira
Assignment: 3
*/
public class Consumer {
    //fields
    private String id;
    private String name;

    //Constructor
    Consumer(String id, String name){
        this.id = id;
        this.name = name;
    }

    //setters
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    //getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "id: " + this.id + " - name: " + this.name;
    }
}
