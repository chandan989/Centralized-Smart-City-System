import java.util.Scanner;

public class Light_Time_Calculator {
    static int green_time_1 = 30;
    static int green_time_2 = 45;
    static int green_time_3 = 60;
    static int count = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the number of path of diversions from one path");
        int count_Diversion = scanner.nextInt();
        int[] arr = new int[count_Diversion];
        System.out.println("enter the no. of cycles you want to run the traffic light");
        int trafficCycleCount = scanner.nextInt();

        for (int i=0; i < count_Diversion; i++){
            path(i);
        }
        System.out.println("First Cycle completed");
        for (int i = 1;i < trafficCycleCount; i++){
            System.out.println("cycle : "+(i+1));
            pathCircle(i,count_Diversion,arr);
        }
    }

    public static void path(int i){
        int count_of_sensor = collective_Collect(i);
        greenTime(count_of_sensor);
    }

    public static int collective_Collect(int i){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter no. of sensors activated in "+(i+1)+" path");
        int count_of_sensor = scanner.nextInt();
        return count_of_sensor;
    }

    public static void greenTime(int count_of_sensor){
        if (count_of_sensor == 1){

            int green_time = green_time_1;
            System.out.println("low traffic time for green light : "+green_time+" sec");
        } else if (count_of_sensor == 2) {
            int green_time = green_time_2;
            System.out.println("moderate Traffic time for green light : "+green_time+" sec");

        } else if (count_of_sensor == 3) {
            int green_time = green_time_3;
            System.out.println("High Traffic time for green light : "+green_time+" sec");

        }
    }
    public static void pathCircle(int i,int count_Diversion,int[] arr){

        Scanner scanner = new Scanner(System.in);
        for(int j = 0; j< count_Diversion;j++){

            System.out.println("Enter no. of sensors activated in "+(j+1)+" path");
            int count_of_sensor = scanner.nextInt();
            arr[j] = count_of_sensor;

        }
        int equalValue = checkEqual(arr);
        if (equalValue==1){
            System.out.println("Time for every path is 45sec");
        }else{

            for (int m = 0; m < count_Diversion;m++){

                greenTime(arr[m]);
            }

        }

    }
    public static int checkEqual(int[] arr) {

        Integer first = arr[0];
        for (int i=1; i<arr.length; i++)
            if (arr[i] != first)
                return 0;
        return 1;
    }


}