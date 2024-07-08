import java.util.*;
import java.util.Scanner ;

public class play extends GAME {

    Scanner input = new Scanner(System.in) ;
    GAME game = new GAME() ;
    public int m = game.yourdice ;
    public int[] dicearray = game.ourdice(game.PlayerNumber) ;

    public String yourroom = game.yourroom ;
    public String yourplace = game.yourplace ;
    public String yourname = game.yourname ;

    public String finalname = game.finalname ;
    public String finalplace = game.finalplace ;
    public String finalroom = game.finalroom ;

    public void room() {
        System.out.println( "choose a room based on the number of your dice. ");
        List< String > allroom = new ArrayList<>() ;
        allroom.add( 0 , "pazirayi" );
        allroom.add( 1 , "otagh piano" );
        allroom.add( 2 , "golkhane" );
        allroom.add( 3 , "otagh motale" );
        allroom.add( 4 , "otagh billard" );
        allroom.add( 5 , "otagh khab" );
        allroom.add( 6 , "ghaza khori" );
        allroom.add( 7 , "ketabkhone" );
        allroom.add( 8 , "ashpaz khone" );

        for ( int i = 1 ; i <= 9 ; i++ ) {
            System.out.println( "chose " + i + " for " + allroom.get(i-1) + "!");
        }
        System.out.println( );
        int urroom = input.nextInt();
        this.yourroom = allroom.get( urroom );
    }

    //choosing room for others for the first time.
    public List<String> othersRoom1( List<String> last , int m , int[] a ) {   // m = the number of Players.
        int[] Helproom = new int[] { 8 , 9 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 2  } ;
        List<String> ROOM = new ArrayList<>() ; //list for all players room.
        ROOM.addFirst( yourroom );
        dicearray = a ;

        List<String> evenrooms = new ArrayList<>() ;
        evenrooms.add( 0 , "otagh piano" );    //2nd room
        evenrooms.add( 1 , "otagh motale" );   //4th room
        evenrooms.add( 2 , "otagh khab" );     //6th room
        evenrooms.add( 3 , "ketabkhone" );     //8th room

        List<String> oddrooms = new ArrayList<>() ;
        oddrooms.add( 0 , "pazirayi" );        //1st room
        oddrooms.add( 1 , "golkhane" );        //3rd room
        oddrooms.add( 2 , "otagh billard" );   //5th room
        oddrooms.add( 3 , "ghaza khori" );     //7th room
        oddrooms.add( 4 , "ashpaz khone" );    //9th room

        for ( int i = 1 ; i <= m ; i++ ) {   //index of player.
            if (last.get(i) == "null") {
                if (dicearray[i] % 2 == 0) {
                    int u = random.nextInt(0, 4);
                    ROOM.add(i, evenrooms.get(u));
                } else {
                    int u = random.nextInt(0, 5);
                    ROOM.add(i, oddrooms.get(u));
                }
            } else if (last.get(i).equals("pazirayi")) {
                if (dicearray[i] % 2 == 0) {
                    int u = random.nextInt(0, 4);
                    ROOM.add(i, evenrooms.get(u));
                } else {
                    int u = random.nextInt(1, 5); //it cant be 0 bc they cant stay in the same room.
                    ROOM.add(i, oddrooms.get(u));
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    if (last.get(i).equals(evenrooms.get(j))) {
                        if (dicearray[i] % 2 == 0) {
                            List<String> temp = new ArrayList<>(evenrooms);
                            temp.remove(j);
                            int u = random.nextInt(0, 3);
                            ROOM.add(i, temp.get(u));
                        } else {
                            List<String> temp = new ArrayList<>(oddrooms);
                            int[] helppppp = new int[]{4, 1, 2, 3, 4};
                            temp.remove(helppppp[j]);
                            temp.remove(helppppp[j + 1]);
                            int u = random.nextInt(0, 3);
                            ROOM.add(i , temp.get(u));
                        }
                    } else {
                        continue;
                    }
                }
                for (int j = 1; j < 5; j++) {
                    if (last.get(i).equals(oddrooms.get(j))) {
                        if (dicearray[i] % 2 == 0) {
                            List<String> temp = new ArrayList<>(evenrooms);
                            int[] helpp = new int[]{ 0 , 1 , 2 , 3 , 0 } ;
                            temp.remove( helpp[j-1] ) ;
                            temp.remove( helpp[j] ) ;
                            temp.addLast("pazirayi");
                            int u = random.nextInt(0 , 3 ) ;
                            ROOM.add( i , temp.get( u ));

                        } else {
                            List<String> temp = new ArrayList<>(oddrooms);
                            temp.remove(j);
                            int u = random.nextInt(0, 4);
                            ROOM.add(i, temp.get(u));
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return ROOM ;
    }

    List<String> guess = new ArrayList<>() ;
    public void printguesspartname(){
        System.out.println("choose a name : " ) ;
        System.out.println("All names = [Liam, Emma, Jack, Sophia, Emily, Ella]");
        this.yourname = input.next() ;
    }
    public void printgeusspartplace(){
        System.out.println("choose a place: ") ;
        System.out.println("All places = [zir goldan, kesho makhfi, posht aks, dakhel jabe, zir miz, balaye komod]");
        this.yourplace = input.next() ;
    }

    List<String> FINALguess = new ArrayList<>() ;
    public void FINALguess( String n , String r , String p ){
        this.finalname = n ;
        this.finalroom = r ;
        this.finalplace = p ;
    }
}



















