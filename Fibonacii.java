
public class Fibonacii{
    public static int FibRec(int n){
        if(n<=1){
            return n;

        }
        return FibRec(n-1)+FibRec(n-2);
    }
    //non recursive
    public static int FibNonRec(int n){
        if(n<=1){
            return n;
        }
        int prev=0,curr=1;
        for(int i=2;i<=n;i++){
            int next=curr+prev;
            prev=curr;
            curr=next;
        }
        return curr;
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println("fibonacii no at position:"+n+"(recursive):"+FibRec(n));
        System.out.println("fibonacii no at position:"+n+"(non recursive):"+FibNonRec(n));

        System.out.println("time complexity of recursive method time:o(2^n) space:o(n)");
         System.out.println("time complexity of non recursive method time:o(n) space:o(1)");
    }

}