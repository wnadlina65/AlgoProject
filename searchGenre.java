import java.util.*;

public class searchGenre 
{
    // Returns index of x if it is present in arr[],
    // else return -1
    public static int search(String[] genre, String input)
    {
        int j = 0, k = genre.length - 1;
        while (j <= k) 
        {
            int sum = j + (k - j) / 2;
            int num = input.compareToIgnoreCase(genre[sum]);

            // Check if num is present at mid
            if (num == 0)
                return sum;
 
            // If num greater, ignore left half
            if (num > 0)
                j = sum + 1;
 
            // If num is smaller, ignore right half
            else
                k = sum - 1;
        }
 
        return -1;
    }
}
