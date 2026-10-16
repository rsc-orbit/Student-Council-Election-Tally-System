import java.util.Scanner;
import java.util.ArrayList;

public class Groupprojectjavaextension {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Candidate names
        String[] candidates = {
            "Candidate 1 - Rahul",
            "Candidate 2 - Priya",
            "Candidate 3 - Arjun"
        };

        // Vote counts
        int[] votes = new int[3];

        // Number of voters
        System.out.print("Enter number of voters: ");
        int n = sc.nextInt();

        // Voting process
        for (int i = 1; i <= n; i++) {

            System.out.println("\nVoter " + i + ", choose your candidate:");

            for (int j = 0; j < candidates.length; j++) {
                System.out.println((j + 1) + ". " + candidates[j]);
            }

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice >= 1 && choice <= 3) {
                votes[choice - 1]++;
                System.out.println("Vote recorded successfully!");
            } else {
                System.out.println("Invalid choice! Vote not recorded.");
            }
        }

        // Display results
        System.out.println("\n========== ELECTION RESULTS ==========");

        for (int i = 0; i < candidates.length; i++) {
            System.out.println(candidates[i] + " : " + votes[i] + " votes");
        }

        // Find winner
        int maxVotes = votes[0];
        int winner = 0;

        for (int i = 1; i < votes.length; i++) {
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
                winner = i;
            }
        }

        System.out.println("\n========== WINNER ==========");
        System.out.println("Winner: " + candidates[winner]);
        System.out.println("Votes: " + maxVotes);
        
        // Creating object instances using 'new' from our loop variables above
        ElectionReport r1 = new ElectionReport(candidates[0], votes[0]);
        ElectionReport r2 = new ElectionReport(candidates[1], votes[1]);
        ElectionReport r3 = new ElectionReport(candidates[2], votes[2]);

        // Printing our new object out cleanly using our custom toString() blueprint method
        System.out.println("Summary Object 1 -> " + r1.toString());
        System.out.println("Summary Object 2 -> " + r2.toString());
        System.out.println("Summary Object 3 -> " + r3.toString());

        
        String winnerText = candidates[winner];
        String checkText = new String(candidates[winner]); // Forced new string block in memory heap

        // Value checking content (.equals) vs pointer reference (==) comparisons
        System.out.println("Does content match using .equals()? " + winnerText.equals(checkText));
        System.out.println("Does memory address match using ==? " + (winnerText == checkText));

        // Simple built-in text transformation operation conversion methods
        System.out.println("Winner Name in CAPITAL letters: " + winnerText.toUpperCase());
        
        // Creating a dynamic generic collection list container to store objects
        ArrayList<ElectionReport> reportList = new ArrayList<ElectionReport>();
        reportList.add(r1);
        reportList.add(r2);
        reportList.add(r3);

        System.out.println("Iterating Collection list box by box:");
        // A simple for-each loop: pulls each report item data object out one by one
        for (ElectionReport reportItem : reportList) {
            // Using a standard condition if branch check inside our collection iteration loop
            if (reportItem.getVoteCount() > 0) {
                System.out.println(" -> Active candidate found: " + reportItem.getCandidateName());
            }
        }

        sc.close();
    }
}


class ElectionReport {
    // Encapsulation parameters: keeping internal object state values private
    private String candidateName;
    private int voteCount;

    // Simple Parameterized Constructor mapping custom state instances definitions
    public ElectionReport(String name, int votes) {
        this.candidateName = name; // 'this' maps external targets variables parameters to local fields
        this.voteCount = votes;
    }

    // Public accessors methods (Getters) exposing elements safely to outside loops
    public String getCandidateName() {
        return this.candidateName;
    }

    public int getVoteCount() {
        return this.voteCount;
    }

   
    public String toString() {
        return "CandidateData[Name = " + candidateName + ", TotalVotes = " + voteCount + "]";
    }
}