package recursion.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 从data中选取n个元素，列出所有组合
 */
public class Combinations {

    //从data中选取n个元素，排列组合
    public void combination(List<Integer> selected,List<Integer> data,int n){
        if (n == 0){
            for (Integer i:selected) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }
        if (data.isEmpty()){
            return;
        }

        //select element 0
        selected.add(data.get(0));
        combination(selected,data.subList(1,data.size()),n-1);
        //un-select element 0
        selected.remove(selected.size()-1);
        combination(selected,data.subList(1,data.size()),n);

    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.combination(new ArrayList<>(),Arrays.asList(1,2,3,4),2);
        System.out.println("========");
        combinations.combination(new ArrayList<>(),Arrays.asList(1,2,3,4),1);
        System.out.println("========");
        combinations.combination(new ArrayList<>(),Arrays.asList(1,2,3,4),0);
        System.out.println("========");
        combinations.combination(new ArrayList<>(),new ArrayList<>(),2);
        System.out.println("========");
        combinations.combination(new ArrayList<>(),new ArrayList<>(),0);
        System.out.println("========");
        combinations.combination(new ArrayList<>(),Arrays.asList(1,2,3,4,5,6,7,8,9,10),4);
    }
}
