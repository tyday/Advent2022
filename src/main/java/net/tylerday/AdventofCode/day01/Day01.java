package net.tylerday.AdventofCode.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day01 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\LocalProgramming\\Advent2022\\src\\main\\java\\net\\tylerday\\AdventofCode\\day01\\pt1Test.txt");
        Scanner sc = new Scanner(file);

        List<Meal> meals = new ArrayList<>();

        meals.add(new Meal());

//        boolean elfIsCurrent = true;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if ("" == line){
//                elfIsCurrent = false;
                meals.add(new Meal());
            } else {
//                elfIsCurrent = true;
                Meal currentMeal = meals.get(meals.size() - 1);
                currentMeal.addCalories(Integer.parseInt(line));
            }

        }
        int maxCalories = 0;
        List <Integer> calList = new ArrayList<>();
        for(Meal meal : meals){
            if (meal.getCalories() > maxCalories) {
                maxCalories = meal.getCalories();
            }
            calList.add(meal.getCalories());
        }
        System.out.println("Max Calories = " + maxCalories);
        Collections.sort(calList, Collections.reverseOrder());
        int cals = calList.get(0) + calList.get(1) + calList.get(2);
        System.out.println("Top 3 elves: " + cals);
    }
}

class Meal implements Comparator<Meal> {
    int calories = 0;

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void addCalories(int calories){
        this.calories += calories;
    }

    @Override
    public int compare(Meal o1, Meal o2) {
        return o1.getCalories() - o2.getCalories();
    }
}
