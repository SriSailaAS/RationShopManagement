import java.io.*;
import java.util.*;
class Stocks{
static int[] stocks={12,4,5,6,73,8,5,46};
int i;
int q[]=new int[8];
int[] price={35,20,30,50,25,30,40,35};
int[] totalprice=new int[8];
Scanner sc =new Scanner(System.in);
void get()
{
for(i=0;i<8;i++)
{
System.out.println("Enter the no of quantity of stocks you want to purchase with respect to :"+(i+1));
q[i]=sc.nextInt();

if(stocks[i]-q[i]<0){
System.out.println("Insufficient Stocks, Please Try Again");
System.out.println("Stocks"+ stocks[i]);
System.out.println("I value"+ i);
i--;
System.out.println("I value"+ i);
}
else{
stocks[i]=stocks[i]-q[i];
totalprice[i]=q[i]*price[i];
System.out.println("The price of the stocks for quantity no : "+(i+1)+" is "+totalprice[i]);
}

}
}
}
public class FirstImplementation{
public static void main(String args[]) {
System.out.println("1.SUGAR-35 RS\n2.RICE-20RS\n3.TEA-30 RS\n4.WHEAT-50 RS\n5.KEROSENE-25 RS\n6.OIL-30 RS\n7.PULSES-40 RS\n8.SALT-35 RS");

Stocks s=new Stocks();
// Object serialization
try {
Stocksarr s1 = new Stocksarr(Stocks.stocks);
System.out.println("The stocks are " + s1);
FileOutputStream fo = new FileOutputStream("serial");
ObjectOutputStream oo = new ObjectOutputStream(fo);
oo.writeObject(s1);
oo.flush();
oo.close();
}
catch(IOException e) {
System.out.println("Exception during serialization: " + e);
System.exit(0);
}
s.get();
try {
Stocksarr stocks2;
FileInputStream fi = new FileInputStream("serial");
ObjectInputStream oi = new ObjectInputStream(fi);
stocks2 = (Stocksarr)oi.readObject();
oi.close();
System.out.println("Remaining Stocks " + stocks2);
}
catch(Exception e) {
System.out.println("Exception during deserialization: " + e);
System.exit(0);
}
}
}
class Stocksarr implements Serializable {
static int []a;
public Stocksarr(int [] a) {
this.a=a;
}
public String toString() {
return "The stocks are : "+ a[0]+" " +a[1]+" "+ a[2]+" " +a[3]+" "+ a[4]+" " +a[5]+" "+ a[6]+" " +a[7]+" ";
}
}
