import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        int[] massiv = {2, 5, 1 , 3, 4, 2, 1, 3};

        int countD = countDistinct(massiv);

        System.out.println("Количество уникальных = "+ countD);
        countD = countDistinctWithSet(massiv);
        System.out.println("Количество уникальных = "+ countD);
        countD = countDistinctWithStream(massiv);
        System.out.println("Количество уникальных = "+ countD);

    }

    public static int countDistinct(int[] mas){
        int count =0;
        for (int i = 0; i < mas.length; i++) {
            int y = mas[i];
            if(!isPresent(y, mas, 0, i-1))  //вызов функции и передача ей параметров
                        //параметр №1 x получает значение, равное y
                        //параметр №2 mas получет адрес массива
                        //параметр №3 from получает значение 0
                        //параметр №4 to   получает значение i-1
                count++;
        }
        return count;
    }

    public static boolean isPresent(int x, int[] mas, int from, int to){
        for (int i = from; i<=to; i++)        {
            if(mas[i] == x)
                return true;
        }
        return false;
    }

    public static int countDistinctWithSet(int[] mas)
    {
        Set<Integer> set1 = new TreeSet<>();
        for (int i = 0; i < mas.length; i++) {
            set1.add(mas[i]);
        }
        return set1.size();
    }

    public static int countDistinctWithStream(int[] mas)
    {
        return (int) Arrays.stream(mas).distinct().count();
    }
}