#include<iostream>
using namespace std;
int main()
{
	int a[5]={5,4,3,2,1},i,j,key,temp;
	for(i=1;i<5;i++)
	{
		key=a[i];
		j=i-1;
		while(j>=0 && key<a[j])
		{
			a[j+1]=a[j];
			a[j]=key;
			j--;
		}
	}
for(i=0;i<5;i++)
		{
		cout<<a[i];
		}
	return 0;
}
