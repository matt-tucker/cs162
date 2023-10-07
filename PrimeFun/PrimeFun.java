/* 
 * App that helps users find prime numbers.
 * 
 * @author matt-tucker
*/
public class PrimeFun {
    public static void main(String [] args) {

        // Print a welcome message using a multi-line Java String.
        System.out.println("""
                =================================
                Let's have some fun with Primes!
                =================================
                """);
        
        // Menu options to display
        String menu = """

                (1) Find all primes up to a number
                (2) Find all primes between two numbers
                (3) Find the next prime after a number
                (4) Quit the program
                Enter the number of the action you'd like to perform:""";
        
        // Keep executing commands until the user selects to quit
        while (true) {
            System.out.print(menu + " ");
            int menuChoice;
            try {
                menuChoice = Integer.parseInt(System.console().readLine());
                // Note this would be a pretty good place to use a "case" statement,
                // but we haven't learned that syntax yet. Google it if interested!
                if (menuChoice == 1) {
                    handleMenu1();
                }
                else if (menuChoice == 2) {
                    handleMenu2();
                }
                else if (menuChoice == 3) {
                    handleMenu3();
                }
                else if (menuChoice == 4) {
                    return; // quit the program
                }
                else {
                    System.out.println();
                    System.out.println("!! Invalid menu selection, please try again.");    
                }
            }
            catch (NumberFormatException ne) {
                System.out.println();
                System.out.println("!! Invalid menu selection, please try again.");
            }
        }
    }

    /**
     * Tests whether a number is prime.
     * 
     * @param num the number to test
     * @return true if the number is prime; false otherwise
     */
    public static boolean isPrime(int num) {
        if (num == 2) { // special case to support optimized loop logic below
            return true;
        }
        if (num < 2 || num % 2 == 0) {
            return false;
        }
        // Any factors of num can't be larger than the square root of num.
        int max = (int)Math.sqrt(num);
        for (int i=3; i<=max; i+=2) { // Only test odd numbers
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void handleMenu1() {
        System.out.print("Enter a number: ");
        int num;
        try {
            num = Integer.parseInt(System.console().readLine());
            System.out.println("All primes through " + num + ":");
            // Primes start at 2, so start loop there. Iterate up through the number
            // to also check if it's prime.
            for (int i=2; i<=num; i++) {
                if(isPrime(i)) {
                    System.out.println(i);
                }
            }
        }
        catch (NumberFormatException ne) {
            System.out.println();
            System.out.println("!! Invalid input, please try again.");   
        }
    }

    private static void handleMenu2() {
        System.out.print("Enter lower bound: ");
        int lowerBound;
        try {
            lowerBound = Integer.parseInt(System.console().readLine());
        }
        catch (NumberFormatException ne) {
            System.out.println();
            System.out.println("!! Invalid input, please try again.");   
            return;
        }
        System.out.print("Enter upper bound: ");
        int upperBound;
        try {
            upperBound = Integer.parseInt(System.console().readLine());
        }
        catch (NumberFormatException ne) {
            System.out.println();
            System.out.println("!! Invalid input, please try again.");   
            return;
        }
        System.out.println("All primes between " + lowerBound + " and " + upperBound + ":");
        // Primes start at 2, so start loop there. Iterate up through the number
        // to also check if it's prime.
        for (int i=lowerBound; i<upperBound; i++) {
            if(isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static void handleMenu3() {
        System.out.print("Enter a number: ");
        int num;
        try {
            num = Integer.parseInt(System.console().readLine());
            System.out.print("The next prime after " + num + " is: ");
            // The supplied number might be prime, so start one number after
            int nextPrime = num + 1;
            while (!isPrime(nextPrime)) {
                nextPrime++;
            }
            System.out.println(nextPrime);
        }
        catch (NumberFormatException ne) {
            System.out.println();
            System.out.println("!! Invalid input, please try again.");   
        }
    }
}