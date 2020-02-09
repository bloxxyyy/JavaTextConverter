package Conv;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mblok
 */
public class Leet {

    String output = "";

    void leetConv(String input) {

        for (int i = 0; i < input.length(); i++) {

            String tester = "" + input.charAt(i);
            switch (tester) {
                case "e":
                    output = output + "3";
                    break;
                case "a":
                    output = output + "4";
                    break;
                case "l":
                    output = output + "1";
                    break;
                case "o":
                    output = output + "0";
                    break;
                case "s":
                    output = output + "$";
                    break;
                case "w":
                    output = output + "VV";
                    break;
                case "t":
                    output = output + "7";
                    break;
                case "u":
                    output = output + "v";
                    break;
                case "i":
                    output = output + "!";
                    break;
                default:
                    output = output + input.charAt(i);
                    break;

            }
        }

    }

    String getLeet() {
        return output;
    }

}
