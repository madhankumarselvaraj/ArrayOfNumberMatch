/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysolution;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Madhankumar Selvaraj
 */
public class ArraySolution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        List<Integer> ls1 = new ArrayList<>();
        List<Integer> ls2 = new ArrayList<>();
        ls1.add(2);
        ls1.add(4);
        ls2.add(16);
        ls2.add(32);
        ls2.add(96);
        int result = getTotalX(ls1, ls2);
        System.out.println(result);

    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        Integer[] aa = new Integer[a.size()];
        Integer[] bb = new Integer[b.size()];
        for (int i = 0; i < aa.length; i++) {
            aa[i] = a.get(i);
        }
        for (int j = 0; j < bb.length; j++) {
            bb[j] = b.get(j);
        }
        int bAryFirstNum = bb[0];
        List<Integer> getMatchArrayValueFromAarryMatch = new ArrayList();
        for (int i = aa[0]; i <= bAryFirstNum; i++) {
            for (int j = 0; j < aa.length; j++) {
                if (i % aa[j] == 0) {
                    if (!getMatchArrayValueFromAarryMatch.contains(i)) {
                        getMatchArrayValueFromAarryMatch.add(i);
                    }
                }
            }
        }
        List<Integer> getMatchValueFromFirstArryValue = new ArrayList();
        for (int j = 0; j < getMatchArrayValueFromAarryMatch.size(); j++) {
            int allValueMatch = 0;
            for (int i = 0; i < aa.length; i++) {
                if (getMatchArrayValueFromAarryMatch.get(j) % aa[i] == 0) {
                    allValueMatch++;
                }
            }
            if (allValueMatch == aa.length) {
                getMatchValueFromFirstArryValue.add(getMatchArrayValueFromAarryMatch.get(j));
            }
        }
        List<Integer> getMatchValueFromSecondArryValue = new ArrayList();
        for (int k = 0; k < getMatchValueFromFirstArryValue.size(); k++) {
            int allValueMatch = 0;
            for (int i = 0; i < bb.length; i++) {
                if (bb[i] % getMatchValueFromFirstArryValue.get(k) == 0) {
                    allValueMatch++;
                }
            }
            if (allValueMatch == bb.length) {
                getMatchValueFromSecondArryValue.add(getMatchValueFromFirstArryValue.get(k));
            }
        }
        return getMatchValueFromSecondArryValue.size();
    }
}
