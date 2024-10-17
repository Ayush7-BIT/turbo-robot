#include<iostream>
#include<vector>
#define ll long long
using namespace std;

int Sieve(int n){
int count=0;
vector<bool> prime(n+1,true);
prime[0]=prime[1]=false;
for(int i=2;i<=n;i++){
  if(prime[i]){
    count+=1;
    for(int j=i*i;j<=n;j+=i){
      prime[j]=false;}}}
  return count;}
int main(){
  ll a; cin>>a;
  cout<<Sieve(a);
  return 0;}
