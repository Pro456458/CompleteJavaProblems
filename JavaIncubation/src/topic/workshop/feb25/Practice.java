package topic.workshop.feb25;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {

        /**
         * Input: A string with groups of characters separated by commas and spaces.
         *
         * Example: "a,b,c, e,f,g i,j,k m,n,o"
         * Output: A new string where each group of characters is combined in a specific pattern.
         *
         * Example: "aeim bfjn cgko"
         * Transformation Rules:
         *
         * Each character from the first group is combined with the corresponding character from the subsequent groups.
         * The characters are combined in the order they appear in the groups.
         * Problem Statement
         * Given a string str containing groups of characters separated by commas and spaces, transform it into a new string where each group of characters is combined in a specific pattern. The pattern involves taking the first character from each group and combining them, then the second character from each group, and so on.
         *
         *
         *
         *
         */


        /**
         * Solution
         */

        approachOne();

        approachTwo();


    }

    private static void approachTwo() {

        String str="a,b,c, e,f,g i,j,k m,n,o"; // op:/ "aeim bfjn cgko"
        String[] arr = str.split(" ");

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<arr[0].length();i=i+2)
        {
            for(String s:arr)
            {
                sb.append(s.charAt(i));
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }

    private static void approachOne() {
        String str = "a,b,c, e,f,g i,j,k m,n,o";

        // Split the input string into groups
        String[] groups = str.split(" ");

        System.out.println(Arrays.toString(groups));

        // Remove commas from each group
        for (int i = 0; i < groups.length; i++) {
            groups[i] = groups[i].replace(",", "");
        }

        System.out.println(Arrays.toString(groups));

        // Determine the length of the groups (assuming all groups are of the same length)
        int groupLength = groups[0].length();

        // Initialize a StringBuilder to store the result
        StringBuilder result = new StringBuilder();

        // Combine characters from each group
        for (int i = 0; i < groupLength; i++) {

            for (String group : groups) {
                result.append(group.charAt(i));
            }

            //adding space after completing 1st combination
            if (i < groupLength - 1) {
                result.append(" ");
            }
        }

        System.out.println(result);
    }
}
