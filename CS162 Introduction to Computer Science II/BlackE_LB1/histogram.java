public class histogram {

    //count instances of part and whole equality
    static int count = 0;

    public static boolean copies(String whole, String part, int check)
    {

        //check if current string length is valid
        if(whole.length() < part.length())
        {
            //check if check parameter equals part instances
            if(count == check)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //check if current string value is an instance of part
        if(whole.substring(0, 3).equals(part))
        {
            count++;
        }

        //recursive call
        return copies(whole.substring(1), part, check);

    }

    public static void main(String[] args)
    {
        System.out.println(copies("dogcatdog", "cat", 2));
    }
}