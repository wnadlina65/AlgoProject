import java.util.*;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException; 

public class libraryApp 
{
    public static void main(String[] args) throws InterruptedException, IOException
    {
        //initialize variable && array
        Scanner scan = new Scanner(System.in);
        String[] Fiction = {"Mystery", "Romance", "Comic", };
        String[] NonFiction = {"Reference", "Biography", "Dictionary"};
        String [] Genre = new String[Fiction.length + NonFiction.length];;
        
        //display welcome page
        welcomeMessage(); 
        System.out.print("Press Any Key To Continue...");
        //read input
        System.in.read();
        //clear screen (works in BlueJ)
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  
        
        //sort fiction and non fiction genre
        sortGenre.mergeSort(Fiction);
        sortGenre.mergeSort(NonFiction);
        
        //merge two genre
        sortGenre.merge(Genre, Fiction, NonFiction);
        
        //sort all genre ascending
        sortGenre.mergeSort(Genre);
        
        //print all sorted genre
        System.out.print("\n\n*** A R I E S || L I B R A R Y ***\n\n");
        System.out.println("\n    List Of Book Genre\n");
        for (int i=0;i<Genre.length;i++) 
        {
            System.out.println("    " + Genre[i]);
        }
        
        //search genre
        System.out.print("\n Enter A Genre : ");
        String input = scan.next();
        int val = searchGenre.search(Genre, input);
        
        if (val == -1)
            System.out.println("Genre not found. Please Try Again.");
        else
        {
            try 
            {
                FileReader read = new FileReader("C:\\Users\\User\\OneDrive\\Documents\\CSC645\\Project\\AlgoProject\\listbook.txt");
                BufferedReader bf = new BufferedReader(read);
                Book B = new Book();
                ArrayList<Book> bookList = new ArrayList<Book>();
                String data = null;
                StringTokenizer ST = null;
                
                 while((data = bf.readLine()) != null) 
                {
                    ST = new StringTokenizer(data,";");
                    
                    //Ensure that have enough tokens to retrieve all attribute
                    if(ST.countTokens() == 6)
                    {
                        String title = ST.nextToken();
                        String author = ST.nextToken();
                        String publisher = ST.nextToken();
                        String genre = ST.nextToken();
                        int year = Integer.parseInt(ST.nextToken());
                        int page = Integer.parseInt(ST.nextToken());
                            
                        B = new Book(title, author, publisher, genre, year, page);
                        bookList.add(B);
                    }
                }
                
                int count=0;
                Collections.sort(bookList, new SortByTitle());
                System.out.println("\n====================================================================================");
                for(int i=0;i<bookList.size();i++)
                {
                    B = (Book)bookList.get(i);
                    if(B.getGenre().equalsIgnoreCase(input))
                    {
                         System.out.println(B.toString());
                         System.out.println("====================================================================================");
                         count++;
                    } 
                }
                System.out.println(" Number of Books: " + count);
                bf.close();
            }
            catch(FileNotFoundException fnf)
            { System.out.println(fnf.getMessage());}
            
            catch(EOFException eof)
            { System.out.println(eof.getMessage());}
            
            catch(IOException io)
            { System.out.println(io.getMessage());}
            
            finally
            { System.out.println("\n System end here...Thank You!!");}
        }
    }
    
    public static void welcomeMessage() throws InterruptedException //welcome page
    {
        System.out.print("     **                ** ******** **          ****      ****         **      **      ******** \n");      
        Thread.sleep(300);
        System.out.print("      **              **  **       **        **        **    **      ****    ****     **       \n");
        Thread.sleep(200);
        System.out.print("       **    ****    **   **       **       **        **      **    **  **  **  **    **       \n");
        Thread.sleep(300);
        System.out.print("        **  **  **  **    ******** **       **        **      **   **    ****    **   ******** \n");  
        Thread.sleep(200);
        System.out.print("         ****    ****     **       **        **        **    **   **              **  **       \n");
        Thread.sleep(300);
        System.out.print("          **      **      ******** ********    ****      ****    **                ** ********  \n\n");
        Thread.sleep(200);
        System.out.print("\t\t\t               *** A R I E S || L I B R A R Y ***\n\n\tLoading...\t");
        for(int i = 0;i<55;i++)
        {
            System.out.print("|");
            if(i<5)
            {Thread.sleep(200);}
            else if(i<30)
            {Thread.sleep(30);}
            Thread.sleep(20);
        }
        System.out.print("\n\n\n\t\tDEVELOPED BY:");
        Thread.sleep(500);
        System.out.print("\n\t\t\t\t1.Shafiqah Alya\n\t\t\t\t2.Madihah Hannani\n\t\t\t\t3.Nur Ain Emylia");
        System.out.print("\n\t\t\t\t4.Nurul Syahmina\n\t\t\t\t5.Syarifah Ayuwandira\n\t\t\t\t6.Wan Nur Adlina\n\n");
        
    }
}
