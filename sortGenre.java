import java.util.*;

public class sortGenre
{
    
    //sort arrays
    public static void mergeSort(String[] genre) 
    {
        if (genre.length > 1) 
        {
            String[] left = new String[genre.length / 2];
            String[] right = new String[genre.length - genre.length / 2];

            for (int i = 0; i < left.length; i++) 
            {
                left[i] = genre[i];
            }

            for (int j = 0; j < right.length; j++) 
            {
                right[j] = genre[j + genre.length / 2];
            }

            mergeSort(left);
            mergeSort(right);
            merge(genre, left, right);
        }
    }
    
    //merge array
    public static void merge(String[] genre, String[] left, String[] right) 
    {
        int x = 0;
        int y = 0;
        for (int i = 0; i < genre.length; i++) 
        {
            if (y >= right.length || (x < left.length && left[x].compareToIgnoreCase(right[y]) < 0)) 
            {
                genre[i] = left[x];
                x++;
            } 
            else 
            {
                genre[i] = right[y];
                y++;
            }
        }
    }
}