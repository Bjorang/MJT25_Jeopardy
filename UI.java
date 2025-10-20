
public class UI {
    public static void main(String[] args) {

        System.out.println("");

        
        String[] cat_u = {"      [A]   ","   [B]   ","   [C]  ", "    [D] ", "     [E]  ","    [F]",};
        String[] cat_0 = {"   [Animals]","[ Films ]","[ Games ]","[ Music ]","[ Anime ]","[   TV  ]",};

        String[] cat_1 = {"[1][  100  ]","[2][  200  ]","[3][  400  ]","[4][  600  ]","[5][  800  ]","[6][ 1000  ]",};
        String[] cat_2 = {"[  100  ]","[  200  ]","[  400  ]","[  600  ]","[  800  ]","[ 1000  ]",};
        String[] cat_3 = {"[  100  ]","[  200  ]","[  400  ]","[  600  ]","[  800  ]","[ 1000  ]",};
        String[] cat_4 = {"[  100  ]","[  200  ]","[  400  ]","[  600  ]","[  800  ]","[ 1000  ]",};
        String[] cat_5 = {"[  100  ]","[  200  ]","[  400  ]","[  600  ]","[  800  ]","[ 1000  ]",};
        String[] cat_6 = {"[  100  ]","[  200  ]","[  400  ]","[  600  ]","[  800  ]","[ 1000  ]",};

        String[][] catt = {cat_u, cat_0,};
        String[][] cats = {cat_1, cat_2, cat_3, cat_4, cat_5, cat_6};
        
        for (int x = 0 ; x < catt.length; x++) {

            for (int y = 0; y < catt[x].length; y++) {
                System.out.print(catt[x][y]);
            }
            System.out.println("");
        }
        
        for (int x = 0 ; x < cats.length; x++) {

            for (int y = 0; y < cats[x].length; y++) {
                System.out.print(cats[y][x]);
            }
            System.out.println("");
        }
        
        System.out.println("");
        
    }

}
