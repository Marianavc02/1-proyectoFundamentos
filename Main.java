import java.util.Scanner;

public class Main {
    public static void imprimirMatriz(char mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void buscar(char[][] matriz, String palabras,int[]cont) {
       boolean find=false;
              find= buscarhorizontal(matriz,palabras,cont);
              if(find==false){
                find=horizontalInv(matriz,palabras,cont);
                if (find==false){
                  find=buscarvertical(matriz,palabras,cont);
                  if(find==false){
                  find=verticalInv(matriz,palabras,cont);
                    if(find==false){
                      find=buscarDiagonalp(matriz,palabras,cont);
                      if(find==false){
                      find=diagonalPInv(matriz,palabras,cont);
                        if(find==false){
                          find=diagonalsec(matriz,palabras,cont);
                            if(find==false){
                        find=diagonalsecInv(matriz,palabras,cont);
                              if(find==false){
                              System.out.println("no se encontro");
                              }
                          }
                        }
                      }
                    }
                  }
                }
              } 


    }
      public static boolean buscarhorizontal(char[][] mat, String palabra,int[] cont) {
        boolean find=true;
        for(int fila=0; fila<mat.length;fila++){
          for(int columna=0;columna<=(mat[0].length - palabra.length()) ;columna++){//columna
           find=true;
            for(int i=0;i < palabra.length();i++) {
              cont[0]++;
              if (mat[fila][columna+i]!=palabra.charAt(i)) {
                    find=false;
                    break;
                }
            }
            if(find==true){
              int inicio=columna;
              int fin=columna+palabra.length()-1;
              System.out.println(palabra+" "+"se encontro iniciando en "+inicio+","+fila+"y finalizando en: "+fin+","+fila+" horizontal directa");
                    return find;
                }
            }
        }
        return find;
      }
      public static boolean horizontalInv(char[][] mat, String palabra, int[]cont) {
        boolean find = true;
        for(int fila=0; fila<mat.length;fila++){
          for(int columna=0;columna<=(mat[0].length - palabra.length()) ;columna++){//columna

            int a = palabra.length() - 1;
            find=true;
            for (int i=0; i< palabra.length();i++) {
              cont[0]++;
                if (mat[fila][columna+i]!= palabra.charAt(a)) {
                    find=false;
                    break;
                }
                a--;
            }
                if(find==true){
                  int inicio=columna;
                  int fin=columna+palabra.length()-1;
                  System.out.println(palabra+" "+"se encontro iniciando en "+fin+","+fila+" "+"y finalizando en: "+inicio+","+fila+" horizontal inversa");
                    return find;
                }
            }
        }
        return find;
      }

      public static boolean buscarvertical(char[][] mat, String palabra, int[]cont){
      boolean find=true;

        for(int fila=0; fila<=(mat.length - palabra.length());fila++){
          for(int columna=0;columna<mat[0].length;columna++){
            find=true;
            for(int i=0;i< palabra.length();i++) {
              cont[0]++;
              if (mat[fila+i][columna]!=palabra.charAt(i)) {
                    find= false;
                    break;
                }
            }
            if(find==true){
              int inicio=fila;
              int fin=fila+palabra.length()-1;
              System.out.println(palabra+" "+"se encontro iniciando en "+columna+","+inicio+"y finalizando en: "+columna+","+fin+" vertical directa");
                    return find;
            }
          }

        }
        return find;
      }

    public static boolean verticalInv(char[][] mat, String palabra,int[]cont){
    boolean find=true;
      for(int fila=0; fila<=(mat.length - palabra.length());fila++){
        //columna
        for(int columna=0;columna<mat[0].length;columna++){
          int a = palabra.length() - 1;
          find=true;
          for(int i=0;i< palabra.length();i++) {
            cont[0]++;
            if (mat[fila+i][columna]!=palabra.charAt(a)) {
                  find= false;
                  break;
              }
            a--;
          }
          if(find==true){
            int inicio=fila;
            int fin=fila+palabra.length()-1;
            System.out.println(palabra+" "+"se encontro iniciando en "+columna+","+fin+"y finalizando en: "+columna+","+inicio+" vertical inversa");
                  return find;
          }
        }

      }
      return find;
    }


    public static boolean buscarDiagonalp(char[][] mat, String palabra, int[]cont){

        boolean find=true;
      for(int fila=0; fila<=(mat.length - palabra.length());fila++){
        for(int columna=0;columna<=(mat[0].length - palabra.length()) ;columna++){
          find=true;
          for(int i=0;i< palabra.length();i++) {
            cont[0]++;
            if (mat[fila+i][columna+i]!=palabra.charAt(i)) {
                  find=false;
                  break;
            }
          }
          if (find==true) {
            int inicioFila = fila;
            int inicioColumna = columna;
            int finFila = fila + palabra.length() - 1;
            int finColumna = columna + palabra.length() - 1;
            System.out.println(palabra + " se encontró iniciando en " + inicioColumna + "," + inicioFila + " y finalizando en: " + finColumna + "," + finFila+" diagonal principal directa");
            return find;
            }
          }  
        }
        return find;
      }
        public static boolean diagonalPInv(char[][] mat, String palabra, int[]cont){

          boolean find=true;
        for(int fila=0; fila<=(mat.length - palabra.length());fila++){
          for(int columna=0;columna<=(mat[0].length - palabra.length()) ;columna++){
            find=true;
            int a =palabra.length() - 1;
            for(int i=0;i< palabra.length();i++) {
              cont[0]++;
              if (mat[fila+i][columna+i]!=palabra.charAt(a)) {
                    find=false;
                    break;
              }
              a--;
            }
            if (find==true) {
              int inicioFila = fila;
              int inicioColumna = columna;
              int finFila = fila + palabra.length() - 1;
              int finColumna = columna + palabra.length() - 1;
              System.out.println(palabra + " se encontró iniciando en " + finColumna + "," + finFila + " y finalizando en: " + inicioColumna + "," + inicioFila+" diagonal principal inversa");
              return find;
              }
            }  
          }
          return find;
        } 
        public static boolean diagonalsec(char[][]mat, String palabra, int[]cont){
             boolean find=true;
            for(int fila=0; fila<=(mat.length - palabra.length());fila++){
              for (int columna=0; columna<=(mat[0].length - palabra.length());columna++){
                find=true;
                for(int i=0;i< palabra.length();i++) {
                  cont[0]++;
                  if (mat[fila+i][columna + palabra.length() - 1 - i]!=palabra.charAt(i)) {
                    find=false;
                    break;
                  }
              }
              if (find==true){
                int inicioFila=fila;
                int inicioColumna= columna+palabra.length()-1;
                int finFila=fila+palabra.length()-1;
                int finColumna=columna;
                System.out.println(palabra+" "+"se encontro con inicio en "+inicioColumna +","+inicioFila+"y con fin en: "+finColumna+","+finFila+ " De forma diagonal secundaria");
                        return find;
              }
            }
          }
            return find;
        }
  public static boolean diagonalsecInv(char[][]mat, String palabra, int[]cont){
       boolean find=true;
      for(int fila=0; fila<=(mat.length - palabra.length());fila++){
        for (int columna=0; columna<=(mat[0].length - palabra.length());columna++){
          find=true;
          int a =palabra.length() - 1;
          for(int i=0;i< palabra.length();i++) {
            cont[0]++;
            if (mat[fila+i][columna + palabra.length() - 1 - i]!=palabra.charAt(a)) {
              find=false;
              break;
            }
            a--;
        }
        if (find==true){
          int inicioFila=fila+palabra.length()-1;
          int inicioColumna= columna;
          int finFila=fila;
          int finColumna=columna+palabra.length()-1;
          System.out.println(palabra+" "+"se encontro con inicio en "+inicioColumna +","+inicioFila+"y con fin en: "+finColumna+","+finFila+ " De forma diagonal secundaria inversa");
                  return find;
        }
      }
    }
      return find;
  }


      





    public static void main(String[] args) {
       Scanner teclado= new Scanner(System.in);
        System.out.println("Hola usuario");
        int[] cont = {0};
        char [][] sopa= 
    {{'a',	'x',	'z',	'y',	'h',	'o',	'l',	'a',	'x',	'y'},
      {'l',	'f',	'z',	'v',	'y',	'o',	'l',	'a',	'a',	'y'},
      {'a',	'x',	'o',	'y',	'c',	'o',	'c',	'a',	'x',	'y'},
      {'a',	'x',	'z',	's',	'o',	'o',	'l',	'l',	'k',	'y'},
      {'a',	'x',	'z',	's',	'i',	'u',	'l',	'l',	'l',	'e'},
      {'b',	'e',	'b',	'e',	'i',	'l',	'p',	'p',	'e',	'p'}};
//n fila , m columna
        imprimirMatriz(sopa);
        System.out.println("INGRESE LA PALABRA A BUSCAR");
        String frase= teclado.nextLine();
        String[] separador = frase.split(" ");
          for(int i=0;i<separador.length;i++){
            buscar(sopa,separador[i],cont);
          }    

        System.out.println("se ejecuto: "+cont[0]+" veces");
    }
}
