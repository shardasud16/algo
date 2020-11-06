package main.java.com.algo.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Solution provided for problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Please provide inputs
 */
public class LetterCombinationOfPhoneNumber {


    private static Map<Character, String []> keyPadMap = new HashMap<>();

    private List<String> output = new ArrayList<>();


    static{
        loadKeyPad();
    }

    public static void loadKeyPad(){

        String [] array2 = {"a", "b", "c"};
        keyPadMap.put('2', array2);

        String [] array3 = {"d", "e", "f"};
        keyPadMap.put('3', array3);

        String [] array4 = {"g", "h", "i"};
        keyPadMap.put('4', array4);

        String [] array5 = {"j", "k", "l"};
        keyPadMap.put('5', array5);

        String [] array6 = {"m", "n", "o"};
        keyPadMap.put('6', array6);

        String [] array7 = {"p", "q", "r", "s"};
        keyPadMap.put('7', array7);

        String [] array8 = {"t", "u", "v"};
        keyPadMap.put('8', array8);

        String [] array9 = {"w", "x", "y", "z"};
        keyPadMap.put('9', array9);
    }



    public List<String> letterCombinations(String digits) {

        if(null == digits || "".equals(digits.trim()))
            return output;

        getAllCombinations(digits, 0, "");

        return output;
    }

    public void getAllCombinations(String input, int index, String builder){

        String [] array = keyPadMap.get(input.charAt(index));

        for(int i = 0; i < array.length; i++){

            if(index < input.length() - 1)
                getAllCombinations(input, index + 1, builder + array[i]);

            if(index == input.length() - 1){
                output.add(builder + array[i]);
            }

        }

    }

    public static void main(String[] args) {

        LetterCombinationOfPhoneNumber run = new LetterCombinationOfPhoneNumber();

        List<String> op = run.letterCombinations("234");

        op.forEach(x -> System.out.print(x + " "));

    }
}
