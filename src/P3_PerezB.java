//Xavier Perez Benitez 25-11-2022

import java.util.Scanner;

public class P3_PerezB {
    
  private static Scanner scan;
  
  public static final int MAX_CLIENTS = 10;

  public static void main(String[] args) {

    scan = new Scanner(System.in);
    
    int []idArr = new int[MAX_CLIENTS];
    int []edatArr = new int[MAX_CLIENTS];
    int []tipusArr = new int[MAX_CLIENTS];
    int []compraArr = new int[MAX_CLIENTS];
    int []telefonArr = new int[MAX_CLIENTS];
    
    boolean introduirmes = true;
    int clients = 0;
    int count = 0;
    int ID = 0;
    int edat = 0;
    int tipus = 0;
    int compra = 0;
    int telefon = 0;
    String tipusVenta = "";
    boolean allok = true;
    int fcanvi;
    int icanvi;

    do {
      do {
        System.out.print("Numero de ID: ");
        allok = scan.hasNextInt();
        
        if(allok){
        
        
        ID = scan.nextInt();

        if (ID >= 111 && ID <= 999) {
          count = 0;
          allok = true;
          idArr[clients] = ID;
          
          do {
            System.out.print("Edat: ");
            edat = scan.nextInt();

            if (edat >= 14 && edat <= 120) {
              count = 0;
              allok = true;
              edatArr[clients] = edat;

              do {
                System.out.println("Tipus de venta:");
                System.out.println("Venta Lliure (1)");
                System.out.println("Pensionista (2)");
                System.out.println("Carnet Jove (3)");
                System.out.println("Soci (4)");
                System.out.print("Escull el tipus de venta: ");
                tipus = scan.nextInt();

                if (tipus >= 1 && tipus <= 4) {
                  count = 0;
                  allok = true;
                  tipusArr[clients] = tipus;

                  switch (tipus) {
                  case 1:
                    tipusVenta = "Venta Lliure";
                    break;

                  case 2:
                    tipusVenta = "Pensionistes";
                    break;

                  case 3:
                    tipusVenta = "Carnet Jove";
                    break;

                  case 4:
                    tipusVenta = "Soci";
                    break;
                  }

                  do {
                    System.out.print("Import de la compra: ");
                    compra = scan.nextInt();

                    if (compra >= 0 && compra <= 1000) {
                      count = 0;
                      allok = true;
                      compraArr[clients] = compra;

                      do {
                        System.out.print("Telefon de contacte: ");
                        telefon = scan.nextInt();

                        if (telefon >= 111111111 && telefon <= 999999999) {
                          count = 3;
                          allok = true;
                          telefonArr[clients] = telefon;

                        } else {
                          System.out.println("Error a l'introdur el numero de telefon.");
                          count++;
                          allok = false;
                        }
                      } while (count < 3);
                      
                    } else {
                      System.out.println("Error a l'introduir el valor de la compra.");
                      count++;
                      allok = false;
                    }
                  } while (count < 3);
                  
                } else {
                  System.out.println("Error a l'introduir el tipus.");
                  count++;
                  allok = false;
                }
              } while (count < 3);
              
            } else {
              System.out.println("Error a l'introduir l'edat.");
              count++;
              allok = false;
            }
          } while (count < 3);
          
        } else {
            System.out.println("Error a l'introduir el ID.");
            count++;
            allok = false;
          }
        }
      } while (count < 3);
      
      System.out.println("Vols introduir un altre usuari? (S/N)");
      String resposta = scan.next();
      
      if (resposta.equals("n")) {
        introduirmes = false;
      }
      
      count = 0;
      
      if (allok){
        clients++;
      }
      
    } while (introduirmes);
    
    System.out.println("S'han registrat " + clients + " clients.");
    
    System.out.println("Id    edat    tipus   import      telèfon");
    for (int i = 0; i < idArr.length; i++){
        if(idArr[i]!= 0){
            
            System.out.println(idArr[i] + "   " + edatArr[i] + "      " + tipusArr[i] + "       " + compraArr[i] + "          " + telefonArr[i]);
        }
    }
    System.out.println("Vols consultar per tipus de client? (s/n)");
    String resposta = scan.next();
      
      if (resposta.equals("n")) {
        
      } else {
          System.out.println("Quin tipus");
          int resposta2 = scan.nextInt();
          
          for (int k = 0; k < clients - 1; k++) {
            for(int j = k + 1; j < clients; j++) {
                if (edatArr[k] > edatArr[j]) {
                    //Edat
                    fcanvi = edatArr[k];
                    edatArr[k] = edatArr[j];
                    edatArr[j] = fcanvi;
                    //ID
                    icanvi = idArr[k];
                    idArr[k] = idArr[j];
                    idArr[j] = icanvi;
                    //tipus
                    icanvi = tipusArr[k];
                    tipusArr[k] = tipusArr[j];
                    tipusArr[j] = icanvi;
                    //telefon
                    icanvi = telefonArr[k];
                    telefonArr[k] = telefonArr[j];
                    telefonArr[j] = icanvi;
                    //compra
                    icanvi = compraArr[k];
                    compraArr[k] = compraArr[j];
                    compraArr[j] = icanvi;
                }
            }
          }

          System.out.println("Id    edat    tipus   import      telèfon");
          
          switch (resposta2) {
                  case 0:                    
                    for (int i = 0; i < idArr.length; i++){
                        if(idArr[i] != 0){
                            if(tipusArr[i] == 0){
                                System.out.println(idArr[i] + "   " + edatArr[i] + "      " + tipusArr[i] + "       " + compraArr[i] + "          " + telefonArr[i]);
                            }                        
                        }
                    }
                    break;

                  case 1:
                    for (int i = 0; i < idArr.length; i++){
                        if(idArr[i] != 0){
                            if(tipusArr[i] == 1){
                                System.out.println(idArr[i] + "   " + edatArr[i] + "      " + tipusArr[i] + "       " + compraArr[i] + "          " + telefonArr[i]);
                            }                        
                        }
                    }
                    break;

                  case 2:
                    for (int i = 0; i < idArr.length; i++){
                        if(idArr[i] != 0){
                            if(tipusArr[i] == 2){
                                System.out.println(idArr[i] + "   " + edatArr[i] + "      " + tipusArr[i] + "       " + compraArr[i] + "          " + telefonArr[i]);
                            }                        
                        }
                    }
                    break;
                    
                  case 3:
                    for (int i = 0; i < idArr.length; i++){
                        if(idArr[i] != 0){
                            if(tipusArr[i] == 3){
                                System.out.println(idArr[i] + "   " + edatArr[i] + "      " + tipusArr[i] + "       " + compraArr[i] + "          " + telefonArr[i]);
                            }                        
                        }
                    }
                    break;
                  }
          }
      
        System.out.println("Vols veure un resum estadístic de les dades? (s/n)");
        String resposta3 = scan.next();

        if (resposta.equals("n")) {
          System.out.println("Sortint del programa...");
          
        } else {
            
            int totalCompra = 0;
            int test1 = 0;
            int test2 = 0;
            int test3 = 0;
            int test4 = 0;
            
            for (int i = 0; i < tipusArr.length; i++){
                if(tipusArr[i] == 1){
                    test1++; 
                } else if (tipusArr[i] == 2) {
                    test2++;
                } else if (tipusArr[i] == 3) {
                    test3++;
                } else if (tipusArr[i] == 4) {
                    test4++;
                }
            }
 
            for (int i = 0; i < clients; i++){
                totalCompra += compraArr[i]; 
            }
            
            System.out.println("Número de clients introduïts: " + clients);
            System.out.println("Número de clients per tipus:");
            if (test1 != 0){
                System.out.println("    venta lliure: " + test1);
            }
            if (test2 != 0){
                System.out.println("    pensionista:  " + test2);
            }
            if (test3 != 0){
                System.out.println("    c.jove:       " + test3);
            }
            if (test4 != 0){
                System.out.println("    soci:         " + test4);
            }
            
            System.out.println("Import total acumulat: " + totalCompra + "€");
      }
    }
  }
