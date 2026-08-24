import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GradeAnalyzer {

//Total scores processed
static int scoresProcessed =0;
//Invalid lines skipped
static int linesSkipped=0;
    
    public static void main(String[] args) {
        //System.getProperty("user.dir");
        //System.out.println("here???   "+System.getProperty("user.dir"));
        // Step 1: read scores from file
        ArrayList<Integer> scores= readScores("scores.txt");
        scoresProcessed = scores.size();
        
        if (scores.isEmpty()) {
            System.out.println("No valid scores found.");
            writeReport(scores, 0.0, 0, 0, "GradesReport.txt");
            return;
        }
        // Step 2: calculate statistics
        double average = calculateAverage(scores);


        //initialize highest to  and lowest to Integer.MAX_VALUE
        //Loop through the scores list and update both as you go.

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for(int score : scores){
            //highest = Math.max(highest, score);
            //lowest = Math.min(lowest, score);

            if(score>highest){
                highest = score;
            }
            if(score<lowest){
                lowest = score;
            }
        }

        // Step 3: write and print report
        writeReport(scores, average, highest, lowest, "GradesReport.txt");
    }

     // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scoreList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            
            
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if(line.isEmpty()){
                    continue;
                }
                try{
                    int   value  = Integer.parseInt(line);  
                    scoreList.add(value);
                    
                    
                }catch (NumberFormatException e) {
                System.out.println("Skipping invalid value: " + line);
                linesSkipped++;
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        return scoreList;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        //returns 0.0 if the list is empty
        double average = 0.0;
        if(scores.isEmpty()){
            return average;
        }

        double total=0.0;
        for(int score : scores){
            total += score;
        }
        average = total/scores.size();
        return average;
    } 

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores, double avg, int high, int low, String outputFile) {
        /* Create 5 int counters: countA, countB, countC, countD, and countF, all starting at 0.  
                Loop through the scores list once.  
                Use if, else if, and else to assign each score to the correct band and increment the counter.  
                Grade bands: A = 90+, B = 80 to 89, C = 70 to 79, D = 60 to 69, F = below 60. */ 

        int countA =0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;
        
        for(int score:scores){
            if(score >= 90){
                countA++;
            }else if(score >= 80){
                countB++;
            }else if(score >= 70){
                countC++;
            }else if(score >= 60){
                countD++;
            }else{
                countF++;
            }

        }

        try(BufferedWriter report = new BufferedWriter(new FileWriter(outputFile))) {
            
            report.write("=== Grade Analysis Report ===");
            report.newLine();
            report.newLine();
        
            System.out.println("=== Grade Analysis Report ===");
            System.out.println("");
            
            String scrPorcessed = String.format("Total scores processed:  %d", scoresProcessed);
            report.write(scrPorcessed);
            System.out.println(scrPorcessed);
            report.newLine();
            String invalidLines = String.format("Invalid lines skipped:  %d", linesSkipped);
            report.write(invalidLines);
            System.out.println(invalidLines);
            report.newLine();
            report.newLine();
            System.out.println("");

            String lineAverage = String.format("Average Score:  %.2f", avg);
            String lineHigh = String.format("Highest Score:  %d", high);
            String lineLow = String.format("Lowest Score:  %d", low);


            report.write(lineAverage);
            report.newLine();
            System.out.println(lineAverage);
            report.write(lineHigh);
            report.newLine();
            System.out.println(lineHigh);
            report.write(lineLow);
            report.newLine();
            System.out.println(lineLow);

            report.newLine();
            report.newLine();

            report.write("Grade Distribution:");
            System.out.println("Grade Distribution:");
            report.newLine();
            String gradeA = String.format("   A  (90 - 100):  %d", countA);
            String gradeB = String.format("   B  (80 - 89):   %d", countB);
            String gradeC = String.format("   C  (70 - 79):   %d", countC);
            String gradeD = String.format("   D  (60 - 69):   %d", countD);
            String gradeF = String.format("   F  (below 60):  %d", countF);

            report.write(gradeA);
            report.newLine();
            System.out.println(gradeA);
            report.write(gradeB);
            report.newLine();
            System.out.println(gradeB);
            report.write(gradeC);
            report.newLine();
            System.out.println(gradeC);
            report.write(gradeD);
            report.newLine();
            System.out.println(gradeD);
            report.write(gradeF);
            report.newLine();
            System.out.println(gradeF);

        } catch (IOException e) {
             System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
