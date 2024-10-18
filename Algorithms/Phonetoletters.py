#This file takes input a string of digits and returns a list of all the possible combinations similar to a Phone Keypad
import sys
def combo(a, mp, i, curr, res):
    #Base case: if 'i' reaches the end of the input list, add the current combination to results
    if i == len(a):
        res.append(curr)
        return
    #Get the characters corresponding to the current digit
    chars = mp[a[i]]
    #Loop through each character mapped to the current digit
    for c in chars:
        # Recursively call 'combo' for the next digit, adding the current character to 'curr'
        combo(a, mp, i + 1, curr + c, res)
#Function to generate all possible words based on the digit list 'a'
def possiblewords(a):
    # Mapping of digits to corresponding letters as on a phone keypad
    mp = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
    #List to store the generated combinations
    res = []
    #Start the combination generation with an empty string
    combo(a, mp, 0, "", res)
    #Return the list of generated combinations
    return res
# Take input as a string of digits
n = input()
# Filter input to retain digits between 2 and 9 and convert them into a list of integers
a = [int(x) for x in n if x.isdigit() and 2 <= int(x) <= 9]
# Generate all possible combinations for the input digits
res = possiblewords(a)
# Print the resulting combinations as a single space-separated string
print(" ".join(res))