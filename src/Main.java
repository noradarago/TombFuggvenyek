import java.util.Random;

public class Main {
    public static void tombkiir(int[] tomb) {
        for (int i = 0; i < tomb.length; i++) {
            System.out.print(tomb[i]);
            if (i < tomb.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static int tombOsszeg(int[] tomb) {
        int osszeg = 0;
        for (int szam : tomb) {
            osszeg += szam;
        }
        return osszeg;

    }

    public static double tombatlag(int[] tomb) {
        return tombOsszeg(tomb) / (double) tomb.length;

    }

    public static int tombMin(int[] tomb) {
        int min = tomb[0];
        for (int szam : tomb) {
            if (min > szam) {
                min = szam;
            }
        }
        return min;

    }

    public static int tombMax(int[] tomb) {
        int max = tomb[0];
        for (int szam : tomb) {

            if (max < szam) {
                max = szam;
            }
        }
        return max;
    }

    public static boolean tartalmaz(int[] tomb, int szam) {
        boolean tart = false;

        for (int elem : tomb) {
            if (elem == szam) {
                tart = true;
                break;
            }
        }
        return tart;
    }
       /* for (int i = 0; i < tomb.length - 1; i++) {
            if (szam == tomb[i]) {
                tart = true;
                break;
            }*/

    public static int[] parosKivalogat(int[] tomb) {
        int szamlalo = 0;
        //megszámlálás

        int pIndex = 0;
        for (int szam : tomb) {
            if (szam % 2 == 0) {
                szamlalo++;
            }
        }
        int[] parosTomb = new int[szamlalo];

        for (int szam : tomb) {
            if (szam % 2 == 0) {
                parosTomb[pIndex++] = szam;
                //pIndex++;
            }
        }
        return parosTomb;
    }
     public static int[] tombMetszet(int[] tomb1, int[] tomb2) {
        //számolás
        int elemszam = 0;

        int n = 0;

        for (int szam : tomb1) {
            if (tartalmaz(tomb2, szam)) {
                elemszam ++;
            }
        }
        int[] metszetT = new int[elemszam];
        //elemek belemásolása a  metszettömbbe
        for (int szam : tomb1) {
            if (tartalmaz(tomb2, szam)) {
                metszetT[n++] = szam;
                //n ++;
            }
        }
         return metszetT;
     }
     public static int[] unio(int[] tomb1, int[] tomb2){
         int elemszam = tomb1.length;


         for (int szam : tomb2) {
             if (!tartalmaz(tomb1, szam)) {
                 elemszam++;
             }
         }
         int[] unioT = new int[elemszam];
         int n = 0;
         for (int szam:tomb1) {
             unioT[n++] = szam;
         }
         //tombkiir(unioT);


         for (int szam : tomb2) {
             if (!tartalmaz(tomb1, szam)) {
                 unioT[n++] = szam;
             }
         }


     return unioT;
     }
       /* for (int i = 0; i < tomb1.length; i++) {
            for (int szam : tomb1) {
                if (tartalmaz(tomb2, szam)) {
                    metszetT[i] = szam;
                    System.out.println(" i:" +i);
                    System.out.println(" szám: " +szam);
                }
            }
        }*/


    public static void main(String[] args) {
        int[] szamok = {17, 9, 33, 11, 7, 5};
        int[] szamok2 ={17, 22, 88, 11, 63};
        System.out.println("A tömb elemei: ");
        tombkiir(szamok);
        System.out.println("A tömb elemeinek összege: " + tombOsszeg(szamok));
        System.out.println("A tömb elemeinek átlaga: " + tombatlag(szamok));
        System.out.println("A legkisebb elem a tömbben: " + tombMin(szamok));
        System.out.println("A legnagyobb elem a tömbben: " + tombMax(szamok));
        System.out.println("A tömb tartalamzza a 12-t: " + tartalmaz(szamok, 12));
        int[] paros = parosKivalogat(szamok);
        System.out.println(" a páros elemek: ");
        tombkiir(paros);
        // 5 elemű tömbbe genereáljunk 5 db különböző számot 0-15ig
        Random ran = new Random();
        int[] veletlenTomb = new int[5];
        int veletlenSzam;
        for (int i = 0; i < veletlenTomb.length; i++) {
            do {
                veletlenSzam = ran.nextInt(15);
            }
            while (tartalmaz(veletlenTomb, veletlenSzam));
            veletlenTomb[i] = veletlenSzam;


            // for (int i = 0; i < veletlenTomb.length; i++) {
            //     veletlenTomb[i] = ran.nextInt(15);
            //}
        }
        System.out.println("5 elemű véletlen tömb: ");
        tombkiir(veletlenTomb);
        tombkiir(tombMetszet(szamok2,szamok));
        System.out.println("A két tömb uniója: ");
        tombkiir(unio(szamok2,szamok));



    }
}
