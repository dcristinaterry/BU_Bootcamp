public class Contact {

    private String name;
    private String phone;

    //constructor
    public Contact(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    @Override
    public String toString(){
        //Override toString to return something like: Ada Lovelace | +1 617 555 0101
        return String.format("%s | %s", name, phone);
    }
}
