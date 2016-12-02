package test;
import lib.myio.*;
import java.util.*;
public class IOManagerTest {
     public void test(){
          Scanner sc=new Scanner(System.in);
          IOManager io1=new IOManager("io1"),io2=new IOManager("io2");
          io1.createInPipe(100);
          io2.setOutPipe(io1);
          io2.createInPipe(100);
          io1.setOutPipe(io2);
          io1.setConsumer(s->{System.out.println("io1->"+s);});
          io2.setConsumer(s->System.out.println("io2->"+s));
          boolean turn=false;
               for(;;){
                    if(turn){
                         System.out.println("input for io1..");
                         io1.putMessage(sc.nextLine());
                    }else{
                         System.out.println("input for io2..");
                         io2.putMessage(sc.nextLine());
                    }
               }
     }
}
