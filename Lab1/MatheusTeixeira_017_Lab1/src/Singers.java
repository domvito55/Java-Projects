public class Singers {
    //fields
    private int singerID = 0;
    private String singerName = "Ramiro";
    private String singerAddress = "93 Chandler Drive";
    private String singerDOB = "10/Aug/1989";
    private int albunsQt = 0;

    // Constructors
    public Singers(){}

    public Singers(int singerID){
        this.singerID = singerID;
    }
    public Singers(int singerID,
                   String singerName){
        this.singerID = singerID;
        this.singerName = singerName;
    }

    public Singers(int singerID,
                   String singerName,
                   String singerAddress){
        this.singerID = singerID;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
    }

    public Singers(int singerID,
                   String singerName,
                   String singerAddress,
                   String singerDOB){
        this.singerID = singerID;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.singerDOB = singerDOB;
    }

    public Singers(int singerID,
                   String singerName,
                   String singerAddress,
                   String singerDOB,
                   int albunsQt){
        this.singerID = singerID;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.singerDOB = singerDOB;
        this.albunsQt = albunsQt;
    }

    //setters
    public void setSingerID(int singerID){
        this.singerID = singerID;
    }

    public void setSingerName(String singerName){
        this.singerName = singerName;
    }

    public void setSingerAddress(String singerAddress){
        this.singerAddress = singerAddress;
    }

    public void setSingerDOB(String singerDOB){
        this.singerDOB = singerDOB;
    }

    public void setAlbunsQt(int albunsQt){
        this.albunsQt = albunsQt;
    }

    public void setAll(int singerID,
                       String singerName,
                       String singerAddress,
                       String singerDOB,
                       int albunsQt){
        this.singerID = singerID;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.singerDOB = singerDOB;
        this.albunsQt = albunsQt;
    }

    //getters
    public int getSingerID(){
        return this.singerID;
    }

    public String getSingerName(){
        return singerName;
    }

    public String getSingerAddress(){
        return singerAddress;
    }

    public String getSingerDOB(){
        return singerDOB;
    }

    public int getAlbunsQt(){
        return this.albunsQt;
    }

    public String toString(){
        return "Singer ID: " + this.singerID + "\n" +
                "Singer Name: " + this.singerName + "\n" +
                "Singer Address: " + this.singerAddress + "\n" +
                "Singer DOB: " + this.singerDOB + "\n" +
                "Number of albuns: " + this.singerID;
    }
}
