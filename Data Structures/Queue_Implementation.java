import java.util.Scanner;

class Queue_Demo{
	
	int n=10,temp;
	int[] a=new int[n];
	int frontpointer=-1,rearpointer=-1;

	void enque(int b)
	{
		if(rearpointer>=n-1){
			System.out.println("Queue Overflow");
		}
		else{
			if(rearpointer==-1){
				frontpointer=0;
			}
			rearpointer++;
			a[rearpointer]=b;	
			}
						
	}
	void deque(){
		if(rearpointer<=0){
			System.out.println("Underflow");
		}
		else{
			temp=frontpointer;
			frontpointer++;
		}
	}
	void display()
	{
		System.out.println("Items Are:");
		for(int i=frontpointer;i<=rearpointer;i++){
			System.out.println(a[i]);
		}
	}

}
public class Queue_Implementation{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		System.out.print("\n 1.INSERT(Enque) \n 2.DELETE(Deque) \n 3.Display");

		Queue_Demo qd=new Queue_Demo();
		int choice;
		do{
			System.out.println("Enter your choice:");
			choice=sc.nextInt();

			switch(choice)
			{
			case 1:
				{
					System.out.println("Enter data:");
					int b=sc.nextInt();
					qd.enque(b);
					break;
				}
		     case 2:
			 	{
			 		qd.deque();
			 		break;
				}
			 case 3:
			 	{
			 		qd.display();
			 		break;
			 	}
			}
		}
		while(true);
	}
}
