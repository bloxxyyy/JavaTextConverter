package Conv;

/*
 * Copyright (C) 2020 Mark Blokker ~ Ad-Blokker
 */

/**
 * @author Mark Blokker ~ Ad-Blokker
 */
public class Leet {

    String output = "";

    void leetConv(String input) {

        for (int i = 0; i < input.length(); i++) {

            String tester = "" + input.charAt(i);
            switch (tester) {
                case "e":
                    output += "3";
                    break;
                case "a":
                    output += "4";
                    break;
                case "l":
                    output += "1";
                    break;
                case "o":
                    output += "0";
                    break;
                case "s":
                    output += "$";
                    break;
                case "w":
                    output += "VV";
                    break;
                case "t":
                    output += "7";
                    break;
                case "u":
                    output += "v";
                    break;
                case "i":
                    output += "!";
                    break;
                default:
                    output += input.charAt(i);
                    break;

            }
        }

    }

    String getLeet() {
        return output;
    }

}
