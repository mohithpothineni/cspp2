import java.util.ArrayList;
import java.util.Scanner;

class Consumption {
    String name;
    String quantity;
    String date;
    String time;

    Consumption(String nameofitemm, String quantityy, String datee, String timee) {
        this.name = nameofitemm;
        this.quantity = quantityy;
        this.time = timee;
        this.date = datee;

    }


    public String toString() {
        return "Date:" + this.date + "\n" + "Time:" + this.time + "\n" + "Name:" + this.name + "\n" + "Quantity:" + this.quantity;
    }

}


class Food extends Consumption{

    Food(String nameofitemm, String quantityy, String datee, String timee) {
        super(nameofitemm, quantityy, datee, timee);
    }

}


class Water extends Consumption{

    Water(String quantityy, String datee, String timee) {
        super("water", quantityy, datee, timee);
    }

    public String toString() {
        return "Date:" + this.date + "\n" + "Quantity:" + this.quantity + "ml";
    }

}

class Activity {

    String nameofactivity;
    String starttime;
    String endtime;
    String notes;
    String date;


    Activity(String nameofactivityy, String notess, String datee, String starttimee, String endtimee) {
        this.nameofactivity = nameofactivityy;
        this.starttime = starttimee;
        this.endtime = endtimee;
        this.date = datee;
        this.notes = notess;
    }

    Activity(String datee, String starttimee, String endtimee) {
        this.date = datee;
        this.starttime = starttimee;
        this.endtime = endtimee;
    }

    public String toString() {
        return "Name:" + this.nameofactivity + "\n" 
                + "Notes:" + this.notes + "\n"
                + "Date:" + this.date + "\n"
                + "Starttime:" + this.starttime + "\n"
                + "Endtime:" + this.endtime;
    }




}



class PhysicalActivity extends Activity{

    PhysicalActivity(String nameofactivity, String notess, String datee, String starttimee, String endtimee) {
        super(nameofactivity, notess, datee, starttimee, endtimee);
    }

}


class Sleep extends Activity{

    Sleep(String datee, String starttimee, String endtimee) {
        super(datee,starttimee, endtimee);
    }

    public String toString() {
        return "Date:" + this.date + "\n"
                + "Starttime:" + this.starttime + "\n"
                + "Endtime:" + this.endtime;   
    }

}


class Weight {

    String date;
    String weight;
    String fatper;
    String time;

    Weight(String datee, String timee, String weightt, String fatperr) {
        this.weight = weightt;
        this. fatper = fatperr;
        this.date = datee;
        this.time = timee;
    }

    public String toString() {
        return "Date:" + this.date + "\n"
                + "Time:" + this.time + "\n"
                + "Weight:" + this.weight + "\n"
                + "Fat:" + this.fatper;
    }



}



class FitByte {
    
    ArrayList<Food> food;
    ArrayList<Water> water;
    ArrayList<PhysicalActivity> physicalactivity;
    ArrayList<Weight> weight;
    ArrayList<Sleep> sleep;

    String[] names = {"Food ", "Water", "PhysicalActivity", "Weight", "Sleep"};
    

    FitByte() {
        food = new ArrayList<Food>();
        water = new ArrayList<Water>();
        physicalactivity = new ArrayList<PhysicalActivity>();
        sleep = new ArrayList<Sleep>();
        weight = new ArrayList<Weight>();
           
    }


    void addFood(String nameofitemm, String quantityy, String datee, String timee) {
        food.add(new Food(nameofitemm, quantityy, datee, timee));
    }

    void addWaterconsumption(String quantityy, String datee, String timee) {
        water.add(new Water(quantityy, datee, timee));
    }

    void addPhysicalActivity(String nameofactivity, String notess, String datee, String starttimee, String endtimee) {
        physicalactivity.add(new PhysicalActivity(nameofactivity, notess, datee, starttimee, endtimee));
    }

    void addSleep(String datee, String starttimee, String endtimee) {
        sleep.add(new Sleep(datee, starttimee, endtimee));
    }

    void addWeight(String datee, String timee, String weightt, String fatperr) {
        weight.add(new Weight(datee, timee, weightt, fatperr));
    }

    void diplayHelper(String name, ArrayList<?> listt) {
        System.out.println(name);
        
        if (listt.size() == 0) {
            System.out.println("None");
            return;
        } 
        for (Object obj : listt) {
            System.out.println(obj);
        }
    }

    void diplayHelper(String name, ArrayList<?> listt, String datee, String seperator) {
        System.out.println(name);
        if (listt.size() == 0) {
            System.out.println("None");
            return;
        }

        for (Object obj : listt) {
            if (obj instanceof Food) {
                Food f = (Food) obj;
                if (f.date.equals(datee)) {
                    System.out.println(f);
                }
            }

            if (obj instanceof  Water) {
                Water f = (Water) obj;
                if (f.date.equals(datee)) {
                    System.out.println(f);
                }
            }

            if (obj instanceof PhysicalActivity) {
                PhysicalActivity f = (PhysicalActivity) obj;
                if (f.date.equals(datee)) {
                    System.out.println(f);
                }
            }

            if (obj instanceof  Weight) {
                Weight f = (Weight) obj;
                if (f.date.equals(datee)) {
                    System.out.println(f);
                }
            }

            if (obj instanceof Sleep) {
                Sleep f = (Sleep) obj;
                if (f.date.equals(datee)) {
                    System.out.println(f);
                }
            }
            
        }
        if (seperator.equals("")) {
            System.out.println();    
        }
        
    }


    void displayLog() {
        ArrayList<?>[] fbdata = {food, water, physicalactivity, weight, sleep};    
        for (int i = 0; i < names.length; i++) {
            diplayHelper(names[i], fbdata[i]);            
        }

    }

    void displayLog(String datee) {
        ArrayList<?>[] fbdata = {food, water, physicalactivity, weight, sleep};
        for (int i = 0; i < names.length; i++) {
            diplayHelper(names[i], fbdata[i], datee ,"");            
        }

        for (int i = 0; i < names.length; i++) {
            diplayHelper(names[i], fbdata[i], datee ,"nospace");            
        }

        System.out.println();

    }

    void foodlog() {
        this.diplayHelper("Food", food);
        System.out.println();
    }

    void waterlog() {
        this.diplayHelper("Water", water);
        System.out.println();   
    }

    void physicalActivitylog() {
        this.diplayHelper("PhysicalActivity", physicalactivity);
        System.out.println();   
    }

    void weightlog() {
        this.diplayHelper("Weight", weight);
        System.out.println();
    }

    void sleeplog() {
        this.diplayHelper("Sleep", sleep);
        System.out.println();   
    }

}


class Client {

    public static void main(String[] args) {
        
        FitByte fb = new FitByte();
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            String[] tokens2;

            switch (tokens[0]) {
            case "Food":
                tokens2 = tokens[1].split(",");
                fb.addFood(tokens2[0], tokens2[1], tokens2[2], tokens2[3]);
                break;
            case "Water":
                tokens2 = tokens[1].split(",");
                fb.addWaterconsumption(tokens2[0], tokens2[1], tokens2[2]);
                break;
            case "PhysicalActivity":
                tokens2 = tokens[1].split(",");
                fb.addPhysicalActivity(tokens2[0], tokens2[1], tokens2[2], tokens2[3], tokens2[4]);
                break;
            case "Sleep":
                tokens2 = tokens[1].split(",");
                fb.addSleep(tokens2[0], tokens2[1], tokens2[2]);
                break;
            case "Weight":
                tokens2 = tokens[1].split(",");
                fb.addWeight(tokens2[0], tokens2[1], tokens2[2], tokens2[3]);
                break;
            case "Summary":
                if (tokens.length == 1) {
                    fb.displayLog();    
                } else {
                    fb.displayLog(tokens[1]);
                }
                break;
            case "Foodlog":
                fb.foodlog();
                break;
            case "Waterlog":
                fb.waterlog();
                break;
            case "PhysicalActivitylog":
                fb.physicalActivitylog();
                break;
            case "Weightlog":
                fb.weightlog();
                break;
            case "Sleeplog":
                fb.sleeplog();
                break;
            default:
                break;
            }
        }


    }



}


