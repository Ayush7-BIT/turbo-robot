
#include<iostream>
using namespace std;
int main()
{
	int a[5]={5,4,3,2,1},i,j,min,temp;
	for(i=0;i<5;i++)
	{
		min=a[i];
		for(j=i+1;j<5;j++)
		{
			if(a[j]<min)
			{
				temp=a[j];
				a[j]=min;
				min=temp;
			}
		}
		a[i]=min;
	}
	for(i=0;i<5;i++)
	{
		cout<<a[i];
	}
	return 0;
}
