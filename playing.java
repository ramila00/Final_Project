import java.util.*;
import java.util.Scanner;

public class playing extends GAME {
    //GAME IS STARTING.
    GAME game = new GAME() ;
    play play = new play() ;
    Scanner input = new Scanner(System.in) ;
    public int playinggg( List< List > tempoooo) {

        int a = 0 ;

        List<String> last = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            last.add(i, "null");
        }
        for ( int i = 0 ; i < 20 ; i++ ) {
            game.ourdice(game.PlayerNumber ) ;
            System.out.println();

            play.room();    //choosing room.
            List<String> helplast = new ArrayList<>( play.othersRoom1( last , game.PlayerNumber , game.ourdice(game.PlayerNumber))) ;
            last = helplast ;
            System.out.println();

            play.printguesspartname();   //choosing name
            play.printgeusspartplace();  //choosing place


            for (int k = 0 ; k < game.PlayerNumber; k++) {
                if (game.CHECK( tempoooo.get(k), play.yourroom, play.yourname, play.yourplace).equals("YES! i have this card.")) {
                    System.out.println( "do u want to use your final guess or not ( yes = 1 and no = 0 )");
                    int letssee = input.nextInt() ;
                    break;
                }
                else {
                    continue;
                }
            }
        }
        return a;
    }
}

