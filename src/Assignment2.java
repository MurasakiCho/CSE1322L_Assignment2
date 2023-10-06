/*
Class: CSE 1322L
Section: WJ1
Term: Summer 2022
Instructor: Maneesha Kumari Penmetsa
Name: Briana O'Neal
Lab#: Assignment 2
*/

import java.util.ArrayList;
import java.util.Scanner;

class Caesar {
    ArrayList<Character>alphabet = new ArrayList<Character>();

    public Caesar(){
        for(char letter = 'a'; letter <= 'z'; letter++){
            alphabet.add(letter);
        }
    }
    public int position_of_char(char x){
       return alphabet.indexOf(x);
    }
    public char letter_at_pos(int x){
       return alphabet.get(x);
    }
    public char encrypted_char (char x){
        int charIndex = position_of_char(x);
        int charNum = charIndex + 3;
        if(charNum >= 26){
            charNum -= 26;
        }
        return letter_at_pos(charNum);
    }
    public char decrypt_char(char x){
        int charIndex = position_of_char(x);
        int charNum = charIndex -3;
        if(charNum<0){
            charNum += 26;
        }
        return letter_at_pos(charNum);
    }
    public String encrypt(String x){
        String ciphertext = "";
        for(int i = 0; i < x.length(); i++){
            char extract = x.charAt(i);
            extract = encrypted_char(extract);
            ciphertext = ciphertext.concat(String.valueOf(extract));
        }
        return ciphertext;
    }
    public String decrypt(String x){
        String ciphertext = "";
        for(int i = 0; i < x.length(); i++){
            char extract = x.charAt(i);
            extract = decrypt_char(extract);
            ciphertext = ciphertext.concat(String.valueOf(extract));
        }
        return ciphertext;
    }
}
public class Assignment2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Caesar caesar = new Caesar();

        while(true) {
            System.out.println("1 Encrypt a message");
            System.out.println("2 Decrypt a message");
            System.out.println("3 Quit");
            int userInput = scan.nextInt();
            scan.nextLine();

            switch (userInput){
                case 1:
                    System.out.println("What is the message to encrypt?");
                    String userString = scan.nextLine();
                    userString = userString.toLowerCase();
                    System.out.println("Encrypted: " + caesar.encrypt(userString));
                    break;
                case 2:
                    System.out.println("What is the encrypted message?");
                    userString = scan.nextLine();
                    userString = userString.toLowerCase();
                    System.out.println("Plaintext: " + caesar.decrypt(userString));
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
