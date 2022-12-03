import java.util.*;


public class SSLogic {
    
    
    public static void main(String[] args){
        boolean goCond = true;
        Scanner sc = new Scanner(System.in);
        ArrayList<SSPerson> allPersons = new ArrayList<SSPerson>();
        int i = -1; 

        // Entering names into the list
        while(goCond){
            System.out.print("\nEnter name: ");
            allPersons.add(new SSPerson(sc.nextLine()));
            boolean secGoCond = false;
            i++;

            System.out.print("Enter items to your wishlist? (Yes or No): ");
            if(sc.nextLine().toUpperCase().equals("YES")) secGoCond = true;
            else secGoCond = false;

            System.out.println();
            while(secGoCond){
                System.out.print("Enter the item you want: ");
                allPersons.get(i).addWish(sc.nextLine());

                System.out.print("Would you like to add more wishes?: (Yes or No) ");
                if(sc.nextLine().toUpperCase().equals("NO")) secGoCond = false;

            }

            System.out.println();
            for(int j = 0; j < allPersons.size(); j++){
                System.out.println(allPersons.get(j));
            }
            System.out.print("Any more people to add? (Yes or No) ");
            if(sc.nextLine().toUpperCase().equals("NO")) goCond = false;
        }
        
        // Randomizing and assigning secret santa people
        System.out.println("\nFinal list");
        for(int j = 0; j < allPersons.size(); j++){
            System.out.println(allPersons.get(j));
        }

        // randomize section
        ArrayList<Integer> randIndex = new ArrayList<Integer>();
        for(int j = 0; j < allPersons.size(); j++){
            randIndex.add(j);
        }
        Collections.shuffle(randIndex);

        for(int j = 0; j < randIndex.size(); j++){
            while(j == randIndex.get(j)){
                Collections.shuffle(randIndex);
                j = 0;
            }
        }
        
        for(int j = 0; j < allPersons.size(); j++){
            allPersons.get(j).assignPerson(allPersons.get(randIndex.get(j)));
        }

        System.out.println();
        for(int j = 0; j < allPersons.size(); j++){
            System.out.println(allPersons.get(j));
        }







    }
}
