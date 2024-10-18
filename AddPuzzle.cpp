#include <iostream>
#include <cstdlib>   

using namespace std;

int main() {
    
    //using rand function to generate random number and taking modulo by 100 gives 2 digit number
    int num1 = rand() % 100; 
   // taking modulo of 10 fo 1 digit
    int num2 = rand() % 10; 
    int userAns;
    int correctAns = num1 + num2;

    cout << "Welcome to the Adding Puzzle game!" << endl;
    cout << "Answer the following: " << num1 << " + " << num2 << "?" << endl;
    cout << "Enter your answer: ";
    cin >> userAns;

    if (userAns == correctAns) {
        cout << "Correct! Well done!" << endl;
    } else {
        cout << "Oops! The correct answer was " << correctAns << "." << endl;
    }

    return 0;
}
