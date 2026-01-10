package warmup;

public class Main {

    public static void main(String[] args) {
        int limit = 4000000;

        int first =1;
        int second =2;

        int sum = 0;

        while (second <= limit){
            if(second % 2 ==0){
                sum = sum + second;
            }
            int next = first + second;
    }
            first = second;
            second = next;
        
        }     
             System.out.println(sum);
    }


}
