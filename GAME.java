import java.util.Scanner ;
import java.util.Random ;
import java.util.* ;

public class GAME {

    static Random random = new Random() ;

    public String yourroom ;
    public String yourplace ;
    public String yourname ;

    public String finalname ;
    public String finalplace ;
    public String finalroom ;

    public int PlayerNumber;
    public int[] diceArray ;
    public int yourdice;
    public void sett(int n) { this.PlayerNumber = n ; }
    public int get() {
        return PlayerNumber;
    }

    //method for dice numbers.
    public int[]  ourdice( int m ) {
        System.out.println();       //just for make it prettier and cleaner
        this.diceArray = new int[ m ] ;
        for ( int k = 1 ; k < diceArray.length  ; k++ ) {
            diceArray[k] = random.nextInt(2 , 13);
            System.out.println("dice for player number " + k + " : " + diceArray[k] );
        }
        this.yourdice = random.nextInt( 2, 13 ) ;
        System.out.println("dice for you! : " + yourdice );
        return diceArray ;
    }

    // creating a method to give cards to each player ( w using random)
    public static List<String> fill( List<String> v , int m ) { // v = cards and m = cards for each player

        // finding random card.
        List<String> tempo = new ArrayList<>() ;
        for ( int i = 0 ; i < m ; i++ ) {
            int u = random.nextInt( 0 , v.size());
            tempo.add( i , v.get( u ));
            v.remove( u ) ;
        }
        return tempo ;
    }

    public String CHECK ( List<String> c , String r , String n , String p ) {
        String answer = " ";
        for ( int i = 0 ; i < c.size() ; i++ ) {
            if ( r.equals(c.get(i))) {
                answer = "YES! i have this card." ;
                System.out.println("my card is : " + c.get(i));
                break ;
            }
            else if ( n.equals(c.get(i))) {
                answer = "YES! i have this card." ;
                System.out.println("my card is : " + c.get(i));
                break ;
            }
            else if ( p.equals( c.get(i))) {
                answer = "YES! i have this card." ;
                System.out.println("my card is : " + c.get(i));
                break ;
            }
            else {
                answer = "I do not have this card." ;
                break ;
            }
        }
        return answer ;
    }

    public String FINALCHECK( List<String> ans , String n , String r , String p ) {
        String answer = " " ;
        if ( ans.get(0).equals(n)) {
            if ( ans.get(1).equals(p)) {
                if( ans.get(2).equals(r)) {
                    answer = " YOU WON! :) " ;
                }
                else{
                    answer = "GAME OVER. :( " ;
                }
            }
            else {
                answer = "GAME OVER. :( ";
            }
        }
        else {
            answer = "GAME OVER. :( " ;
        }
        return answer ;
    }

    public static void main(String[] args) {

        GAME game = new GAME();
        play play = new play();
        playing playing = new playing() ;
        Random random = new Random() ;
        Scanner input = new Scanner(System.in);
        String pretty = "--------------------------------------------------" ;

        System.out.println("Enter the number of players ( 3 - 4 - 5 - 6 ) : ");
        game.sett(input.nextInt());
        int players = game.PlayerNumber;

        //giving a number to each card to make it easier.
        List< String > cards = new ArrayList<>();
        cards.add( 0 , "Emma" );
        cards.add( 1 , "Liam" );
        cards.add( 2 , "Jack" );
        cards.add( 3 , "Sophia" );
        cards.add( 4 , "Emily" );
        cards.add( 5 , "Ella" );
        cards.add( 6 , "zir goldan" );
        cards.add( 7 , "kesho makhfi" );
        cards.add( 8 , "posht aks" );
        cards.add( 9 , "dakhel jabe" );
        cards.add( 10 , "zir miz" );
        cards.add( 11 , "balaye komod" );
        cards.add( 12 , "pazirayi" );
        cards.add( 13 , "otagh piano" );
        cards.add( 14 , "golkhane" );
        cards.add( 15 , "otagh motale" );
        cards.add( 16 , "otagh billard" );
        cards.add( 17 , "otagh khab" );
        cards.add( 18 , "ghaza khori" );
        cards.add( 19 , "ketabkhone" );
        cards.add( 20 , "ashpaz khone" );

        //choosing random cards as answer based on the number of players.
        List<String> ans = new ArrayList<>() ; //list of answer
        int a = random.nextInt(0 , 6);     //name of character.
        int b = random.nextInt(6, 12);     //place.
        int c = random.nextInt(12 , 21);   //room.
        ans.add( 0 , cards.get( a )) ;
        ans.add( 1 , cards.get( b )) ;
        ans.add( 2 , cards.get( c )) ;
        cards.remove( a ) ;
        cards.remove( b ) ;
        cards.remove( c ) ;

        List< List > tempoooo = new ArrayList<>() ;
        //giving cards to each player.
        if ( players == 3)  {
            List< String> temp = new ArrayList<>( cards ) ;

            List<String> cardfor1 = new ArrayList<>( fill( temp , 6 )) ;
            List<String> cardfor2 = new ArrayList<>( fill( temp , 6 )) ;
            List<String> cardfor3 = new ArrayList<>( temp ) ;
            // printing your cards.
            System.out.println();
            System.out.print("your cards : [ ");
            for ( int i = 0 ; i < 6 ; i++ ) {
                System.out.print( cardfor3.get(i) + " ,");
            }
            System.out.print("]");
            System.out.println();

            tempoooo.add( 0 , cardfor1) ;
            tempoooo.add( 1 , cardfor2) ;
            tempoooo.add( 2 , cardfor3) ;
        }

        if ( players == 4) {
            List< String> temp = new ArrayList<>( cards) ;

            System.out.println();
            System.out.print("extra cards: [ ");
            List<String> extra = new ArrayList<>( fill( temp , 2 )) ;
            for ( int i = 0 ; i < 2 ; i++ ) {
                System.out.print( extra.get(i) + " ,");
            }
            System.out.print("]");
            System.out.println();

            List<String> cardfor1 = new ArrayList<>( fill( temp , 4 )) ;
            List<String> cardfor2 = new ArrayList<>( fill( temp , 4 )) ;
            List<String> cardfor3 = new ArrayList<>( fill( temp , 4 )) ;
            List<String> cardfor4 = new ArrayList<>( temp ) ;
            //printing your cards.
            System.out.println();
            System.out.print("your cards : [ ");
            for ( int i = 0 ; i < 4 ; i++ ) {
                System.out.print( cardfor4.get(i) + " ,");
            }
            System.out.print("]");
            System.out.println();

            tempoooo.add( 0 , cardfor1);
            tempoooo.add( 1 , cardfor2);
            tempoooo.add( 2 , cardfor3);
            tempoooo.add( 3 , cardfor4);
        }

        if ( players == 5) {
            List< String> temp = new ArrayList<>(cards) ;

            System.out.println();
            System.out.print("extra cards: [ ");
            List< String >  extra = new ArrayList<>( fill( temp , 3 )) ;
            for ( int i = 0 ; i < 3 ; i++ ) {
                System.out.print( extra.get(i) + " ,");
            }
            System.out.print("]");
            System.out.println();

            List<String> cardfor1 = new ArrayList<>( fill( temp , 3 )) ;
            List<String> cardfor2 = new ArrayList<>( fill( temp , 3 )) ;
            List<String> cardfor3 = new ArrayList<>( fill( temp , 3 )) ;
            List<String> cardfor4 = new ArrayList<>( fill( temp , 3 )) ;
            List<String> cardfor5 = new ArrayList<>( temp );
            //printing your cards.
            System.out.println();
            System.out.print("your cards : [ ");
            for ( int i = 0 ; i < 3 ; i++ ) {
                System.out.print( cardfor5.get(i) + " ,");
            }
            System.out.print("]");
            System.out.println();

            tempoooo.add( 0 , cardfor1);
            tempoooo.add( 1 , cardfor2);
            tempoooo.add( 2 , cardfor3);
            tempoooo.add( 3 , cardfor4);
            tempoooo.add( 4 , cardfor5);
        }

        if ( players == 6) {
            List< String> temp = new ArrayList<>( cards ) ;

            List<String> cardfor1 = new ArrayList<>( fill( temp , 3 )) ;
            List<String> cardfor2 = new ArrayList<>( fill( temp , 3 )) ;
            List<String> cardfor3 = new ArrayList<>( fill( temp , 3 )) ;
            List<String> cardfor4 = new ArrayList<>( fill( temp , 3 )) ;
            List<String> cardfor5 = new ArrayList<>( fill( temp , 3 )) ;
            List<String> cardfor6 = new ArrayList<>( temp );
            //printing your cards.
            System.out.println();
            System.out.print("your cards : [ ");
            for ( int i = 0 ; i < 3 ; i++ ) {
                System.out.print( cardfor6.get(i) + " ,");
            }
            System.out.print("]");
            System.out.println();

            tempoooo.add( 0 , cardfor1);
            tempoooo.add( 1 , cardfor2);
            tempoooo.add( 2 , cardfor3);
            tempoooo.add( 3 , cardfor4);
            tempoooo.add( 4 , cardfor5);
            tempoooo.add( 5 , cardfor6);
        }

        for ( int i = 0 ; i < 20 ; i++ ) {
            if (playing.playinggg ( tempoooo ) == 0) {
                continue;
            }
            else if (playing.playinggg( tempoooo ) == 1 ) {
                System.out.println("enter your final guess(name) :");
                String n = input.next() ;
                System.out.println("enter your final guess(room) :");
                String r = input.next() ;
                System.out.println("enter your final guess(place) :");
                String p = input.next() ;

                play.FINALguess( n , r , p ) ;
                System.out.println(game.FINALCHECK( ans , play.finalname , play.finalroom , play.finalplace ));
                break ;
            }
        }
    }
}















