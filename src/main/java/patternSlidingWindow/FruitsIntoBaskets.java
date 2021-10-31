package patternSlidingWindow;

import java.util.HashMap;

public class FruitsIntoBaskets {
    public static void main(String[] args) {
        System.out.println("Max number of fruits picked : " + FruitsIntoBaskets.findMaxFruitsCollected(new int[] {1,2,1}));
        System.out.println("Max number of fruits picked : " + FruitsIntoBaskets.findMaxFruitsCollected(new int[] {0,1,2,2}));
        System.out.println("Max number of fruits picked : " + FruitsIntoBaskets.findMaxFruitsCollected(new int[] {1,2,3,2,2}));
        System.out.println("Max number of fruits picked : " + FruitsIntoBaskets.findMaxFruitsCollected(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
    }
    public static int findMaxFruitsCollected(int[] tree){
        HashMap<Integer, Integer> fruitBasket = new HashMap<Integer, Integer>();
        int windowStart=0, maxFruits=0;
        for(int windowEnd=0; windowEnd<tree.length; windowEnd++){
            int fruit = tree[windowEnd];
            fruitBasket.put(fruit, fruitBasket.getOrDefault(fruit,0)+1);
            while(fruitBasket.size()>2){
                fruitBasket.put(tree[windowStart], fruitBasket.get(tree[windowStart])-1);
                if(fruitBasket.get(tree[windowStart]) == 0)
                    fruitBasket.remove(tree[windowStart]);
                windowStart++;
            }
            maxFruits = Math.max(maxFruits, windowEnd-windowStart+1);

        }
        return  maxFruits;
    }

}
