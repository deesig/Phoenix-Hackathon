import java.util.ArrayList;

public class SSPerson {
    
    //fields
    private String name;
    private ArrayList<String> wishlist;
    private SSPerson assignedPerson;
    
    public SSPerson(String name){
        this.name = name;
        wishlist = new ArrayList<String>();
    }

    public SSPerson(String name, ArrayList<String> wishes){
        this.name = name;
        wishlist = new ArrayList<String>();
        for(int i = 0; i < wishes.size(); i++){
            wishlist.add(wishes.get(i));
        }
    }

    public String getName(){
        return name;
    }

    public ArrayList<String> getWishlist(){
        return wishlist;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setWishlist(ArrayList<String> wishes){
        wishlist.clear();
        for(int i = 0; i < wishes.size(); i++){
            wishlist.add(wishes.get(i));
        }
    }

    public void addWish(String wish){
        wishlist.add(wish);
    }

    public String toString(){
        String wishString = "";
        if(wishlist.size() <= 0){
            return name + ": No wishes";
        } else if (assignedPerson == null){

            for(int i = 0; i < wishlist.size(); i++){
                wishString += wishlist.get(i) + ", ";
            }

            wishString = wishString.substring(0, wishString.length() - 2);

            return name + ": " + wishString;
        } else {
            for(int i = 0; i < wishlist.size(); i++){
                wishString += wishlist.get(i) + ", ";
            }

            wishString = wishString.substring(0, wishString.length() - 2);

            return name + ": " + wishString + "\n - Assigned Person -- " + assignedPerson.getName() + ": " + assignedPerson.getWishlist();
        }
    }

    public void assignPerson(SSPerson p){
        assignedPerson = p;
    }

}