import java.util.Scanner;
class Transaction {
  public static void transaction (Payment p1)
  {
    p1.sendPayment();
    p1.receivePayment();
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter 1 for Gpay 2 for PhonePe 3 for Paytm");
    int choice = sc.nextInt();
    Payment p1;
    if(choice ==1)
    {
      p1=new Gpay();
      transaction(p1);
    }
    else if (choice ==2)
    {
      p1=new PhonePe();
      transaction(p1);
    }
    else if(choice ==3)
    {
      p1= new Paytm();
      transaction(p1);
    }
    else{
      System.out.println("You don't have another application in your phone install another payment application if you want");
    }
  }
}
interface Payment
  {
    void sendPayment();
    void receivePayment();
  }
class Gpay implements Payment{
  @Override
  public void sendPayment()
  {
    System.out.println("Payment Send by Gpay");
  }
  @Override
  public void receivePayment()
  {
    System.out.println("Payment Received by Gpay");
  }
  void checkRewards()
  {
    System.out.println("You have got scratch Cards");
  }
}

class PhonePe implements Payment{
  @Override
    public void receivePayment()
    {
    System.out.println("Payment Received by PhonePe");
  }
  @Override 
    public void sendPayment(){
    System.out.println("Payment Send by PhonePe");
  }
  void checkOffer()
    {
    System.out.println("You have 100rs flat offer on Train ticket Booking");
  }
}
class Paytm implements Payment{
  @Override
    public void receivePayment()
    {
    System.out.println("Payment Received by Paytm");
  }
  @Override 
    public void sendPayment(){
    System.out.println("Payment Send by Paytm");
  }
  void paytmBank()
    {
    System.out.println("You have 1000rs in your account");
  }
}
