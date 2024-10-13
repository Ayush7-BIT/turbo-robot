#include<iostream>
using namespace std;
int main()
{
	int a[5]={5,4,3,2,1},i,j;
	for(i=0;i<5;i++)
	{
		for(j=0;j<4;j++)
		{
			if(a[j+1]<a[j])
			{
				a[j+1]=a[j+1]+a[j];
				a[j]=a[j+1]-a[j];
				a[j+1]=a[j+1]-a[j];
			}
		}
	}
	//Printing the array
	for(i=0;i<5;i++)
	{
		cout<<a[i];
	}
	return 0;
}
