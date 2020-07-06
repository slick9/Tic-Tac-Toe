package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[][] game_array = new String[3][3];
        for (int i = 0;i<3;i++){
            for(int j =0;j<3;j++){
                game_array[i][j] = " ";
            }
        }
        int chance = 1;
        boolean flag = true;
        while (flag){
            layout(game_array);
            indexes(game_array,chance);
            layout(game_array);
            flag = decider(game_array);
            chance++;
        }

    }


    public static void indexes(String[][] arr1,int count){
        System.out.print("Enter the coordinates: ");
        boolean flag = true;
        while (flag) {
            try {
                String[] pieces = scanner.nextLine().split(" ");
                int n1 = Integer.parseInt(pieces[0]);
                int n2 = Integer.parseInt(pieces[1]);
                if(n1>3 || n2>3 || n1<1 || n2<1){
                    System.out.println("Coordinates should be from 1 to 3!");
                }else if(arr1[3-n2][n1-1] =="X" || arr1[3 - n2][n1-1] =="O"){
                    System.out.println("This cell is occupied! Choose another one!");
                }else{
                    if (count%2==1){
                        arr1[3-n2][n1-1] = "X";
                    }else{
                        arr1[3-n2][n1-1] = "O";
                    }
                    flag = false;
                }
            } catch (NumberFormatException exception) {
                System.out.println("You should enter numbers!");
            }
        }

    }
    public static void layout(String[][] arr1){
        System.out.println("---------");
        System.out.println('|' + " " +arr1[0][0]+ " " + arr1[0][1]+ " " +arr1[0][2]+ " " + "|");
        System.out.println('|' + " " +arr1[1][0]+ " " + arr1[1][1]+ " " +arr1[1][2]+ " " + "|");
        System.out.println('|' + " " +arr1[2][0]+ " " + arr1[2][1]+ " " +arr1[2][2]+ " " + "|");
        System.out.println("---------");
    }

    public static boolean decider(String[][] arr ){
        int x = 0;
        int o = 0;
        for(String[] arr1: arr){
            for(String a : arr1)
            if (a =="X"){
                x++;
            }else if(a =="O"){
                o++;
            }
        }
        if(Math.abs(x-o)>1){
            System.out.println("Impossible");
            return false;
        }

        boolean xwin = false;
        boolean ywin = false;
        for(int i = 0;i<3;i++) {
            if (arr[i][0] == "X" && arr[i][1] == "X" && arr[i][2] == "X") {
                xwin = true;
            } else if (arr[i][0] == "O" && arr[i][1] == "O" && arr[i][2] == "O") {
                ywin = true;
            }else if( arr[0][i] == "X" && arr[1][i] == "X" && arr[2][i] == "X"){
                xwin = true;
            }else if (arr[0][i] == "O" && arr[1][i] == "O" && arr[2][i] == "O"){
                ywin = true;
            }
        }
        int xcount1 =0;
        int ycount1 = 0;
        int xcount2 =0;
        int ycount2 = 0;
        for(int i = 0;i<3;i++) {
            for(int j = 0 ;j<3;j++){
                if( i ==j  && i+j==2){
                    if (arr[i][j]=="X"){
                        xcount1++;
                        xcount2++;
                    }else if (arr[i][j]=="O"){
                        ycount1++;
                        ycount2++;
                    }
                }else if (i==j){
                    if (arr[i][j]=="X"){
                        xcount1++;
                    }else if (arr[i][j]=="O"){
                        ycount1++;
                    }
                }else if (i+j ==2){
                    if (arr[i][j]=="X"){
                        xcount2++;
                    }else if (arr[i][j]=="O"){
                        ycount2++;
                    }
                }
                if(xcount1 ==3 || xcount2 ==3){
                    xwin =true;
                }if (ycount1 ==3 || ycount2 ==3){
                    ywin = true;
                }

            }
        }
        if (xwin==true && ywin==true){
            System.out.println("Impossible");
            return false;
        }else if(xwin == true && ywin == false){
            System.out.println("X wins");
            return false;
        }else if (xwin ==false && ywin == true){
            System.out.println("O wins");
            return false;
        }else if ( x + o ==9 && xwin ==false && ywin ==false ){
            System.out.println("Draw");
            return false;
        }
        return true;

    }
}
