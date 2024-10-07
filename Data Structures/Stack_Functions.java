import java.util.Scanner;

class Stack_Demo
{
	Scanner sc=new Scanner(System.in);
		int[] a=new int[100];
		int TOP=-1;

		public void push()
		{
			if(TOP>=100)
			{
				System.out.println("Stack Overflow");
			}
			else
			{
				System.out.println("Enter a value to insert");
				int x=sc.nextInt();
				TOP++;
				a[TOP]=x;
			}
		}

		public void pop()
		{
			if(TOP<=-1)
			{
				System.out.println("Stack Underflow");
			}
			else{
				System.out.println("\n the popped element is"+a[TOP]);
				TOP--;
			}
		}
		public void display()
		{
			if(TOP>=0)
			{
				System.out.println("\n The elements in stack are....");
				for(int i=TOP;i>=0;i--)
				{
					System.out.println(a[i]);
					
				}
			}
			else
			{
				System.out.println("The stack is empty");
			}
		}
		public void peep()

		{
			if(TOP==-1)
			{
				System.out.println("Stack is empty");
				return;
			}
			else
			{
				System.out.println("The element is :"+a[TOP]);
			}
		}
		public void change()
		{
			System.out.println("Enter position for change:");
			int n1=sc.nextInt();
			System.out.println("Enter number for update:");
			int n2=sc.nextInt();

			if(TOP-n1<=-1)
			{
				System.out.println("Stack Underflow");
				return;
			}
			else{
				a[TOP-n1]=n2;
				System.out.println("Update Successful.....");
			}
		}
}

public class Stack_functions
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter size of array :");
		int n=sc.nextInt();

		System.out.print("\n 1.PUSH \n 2.POP \n 3.DISPLAY \n 4.PEEP \n 5.CHANGE \n 6.EXIT");

		Stack_Demo sd=new Stack_Demo();
		int ch;
		do
		{
			System.out.println("Enter your choice:");
			ch=sc.nextInt();

			switch(ch)
			{
				case 1:
				{
					sd.push();
					break;
				}
				case 2:
				{
					sd.pop();
					break;
				}
				case 3:
				{
					sd.display();
					break;
				}
				case 4:
				{
					sd.peep();
					break;
				}
				case 5:
				{
					sd.change();
					break;
				}
				case 6:
				{
					System.out.println("Exit");
					break;
				}
				default:
				{
					System.out.print("\n 1.PUSH \n 2.POP \n 3.DISPLAY \n 4.PEEP \n 5.CHANGE \n 6.EXIT");
				}
			}
		}
		while(ch!=6);
	}	
}
