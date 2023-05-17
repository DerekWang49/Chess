import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;

public class OwlPopulation {
    private String fileName;
    private Owl[] data;


    public int populateData() {
        try {
            File f = new File(fileName);
            Scanner scanner = new Scanner(f);

            int numLines = 0;
            while(scanner.hasNextLine()){
                numLines++;
                String s = scanner.nextLine();
            }
            scanner.close();

            data = new Owl[numLines];   //data is is allocated the exact amount of space it needs
            scanner = new Scanner(f);

            //TODO: Populate the data with owls constructed from the lines of the file given
            for (int i = 0; i < numLines; i++) {
                String s = scanner.nextLine();
                String[] t = s.split(",");
                String name = t[0];
                int age = Integer.parseInt(t[1]);
                double weight = Double.parseDouble(t[2]);
                data[i] = new Owl(name, age, weight);
        } catch (Exception e) {
                System.out.println("Could not find file")
            }


        }
        return data.length;
    }

    public OwlPopulation(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        populateData();

    }

    public double averageAge() {
        double average = 0;
        for (int i = 0; i < data.length; i++) {
            average += data[i].getAge();
        }
        return average / data.length;
    }

    public Owl getYoungest(){
        if (this.data.length > 0) {
            Owl youngest = this.data[0];
            for (int i = 0; i < this.data.length; i++) {
                if (this.data[i].getAge() < youngest.getAge()) {
                    youngest = this.data[i];
                }
            }
            return youngest;
        }
        return null;
    }

    public Owl getHeaviest(){
        if (data.length > 0) {
            Owl heaviest = data[0];
            for (int i = 0; i < data.length; i++) {
                if (data[i].getWeight() > heaviest.getWeight()) {
                    heaviest = data[i];
                }
            }
            return heaviest;
        }
        return null;
    }

    public String toString(){
        String str1 = "The youngest owl is " + getYoungest().getName() + ", which is " + getYoungest().getAge() + " years old. ";
        String str2 = "The heaviest owl is " + getHeaviest().getName() + ", which is " + getHeaviest().getWeight() + " pounds. ";
        String str3 = "The average age of the population is " + averageAge() + ".";
        return str1 + str2 + str3;
    }

    public boolean containsOwl(Owl other){
        //TODO: method you can implement as a helper function to your merge method
        for (int i = 0; i < this.data.length; i++) {
            if (data[i].equals(other)) {
                return true;
            }
        }
        return false;

    }
	
    public void merge(OwlPopulation other){
        //TODO: a brief overview of what you can do to implement this method is given below
        //1) determine (and store) the distinct owls in the other population



//        int counter = 0;
//        for (int i = 0; i < other.data.length; i++) {
//            if (containsOwl(other.data[i]) == false) {
//                counter += 1;
//            }
//        }
//
//        Owl distinct [];
//        distinct = new Owl[counter];
//        int count = 0;
//        for (int i = 0; i < other.data.length; i++) {
//            if (containsOwl(other.data[i]) == false) {
//                distinct[count] = other.data[i];
//                count++;
//            }
//        }

        int counter = 0;
        Owl distinct [];
        distinct = new Owl[other.data.length];
        for (int i = 0; i < other.data.length; i++) {
            if (containsOwl(other.data[i]) == false) {
                distinct[counter] = other.data[i];
                counter++;
            }
        }






        //2) make a new data array to hold the correct number of owls for the merged population
        Owl[] merged;
        merged = new Owl[counter + this.data.length];


        //3) copy over the distinct owls from each population to the data array
        for (int i = 0; i < this.data.length; i++) {
            merged[i] = this.data[i];
        }

//        for (int i = 0; i < other.data.length; i++) {
//            if (containsOwl(other.data[i]) == false) {
//                merged[this.data.length] = other.data[i];
//            }
//
//        }

        for (int i = 0; i < counter; i++) {
            merged[data.length + i] = distinct[i];
        }

        //4) set the new data array to "this" data (where is the merged population? what happens to the original populations?)
        this.data = merged;
    }

    public int popSize(){
        return data.length;
    }
	
    public static void main(String[] args) {
        try {

            //The following should run when you are complete. Feel free to comment out as you see fit while you work.
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");
            System.out.println(pop1);
            System.out.println(pop1.popSize());

            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");
            System.out.println(pop2);
            System.out.println(pop2.popSize());

            pop1.merge(pop2);
            System.out.println(pop1);
            System.out.println(pop1.popSize());

        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }


}
