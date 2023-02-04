'''
# Problem 9.28
from tkinter import Tk,Frame,Label,Button
from calendar import monthrange
from tkinter.simpledialog import askstring
class Calendar(Frame):
    'Calendar app'
    # implement this [OPTIONAL]          
'''


# Problem 2
def combinations(n,k):
    'returns the number of ways of choosing k items out of n'
    # implement this         
    if k == 0:
        return 1;
    elif n<k:
        return 0;
    else: return combinations(n-1,k-1)+combinations(n-1,k)


# Exercise 10.14
from time import sleep
def countdown(n):
    # implement this         
    #print(n)

    if n== 0:
        return 'Blastoff!!!';
    else:
        print(n)
        if n==3:
            #print(n);
            print("BOOM!!!");
            print("Scared You...");
        return countdown(n-1);


# Problem 10.18
def silly(n):
    'prints n stars followed by n exclamation marks'
    # implement this
    if n==0:
        return ''
    return '*' + silly(n-1)+'!'


def numOnes(n):
    'returns number of 1s in the binary representation of non-negative integer n'
    # implement this
    if n==0:
        return 0;
    elif n==1:
        return 1;
    else:
        return numOnes(n//2)+numOnes(n%2);



# Problem 10.20
def rgcd(a, b):
    'returns the greatest common denominator of non-negative integers a and b'
    # implement this
    if b<=a and b==0:
        return a;
    elif a<b:
        return rgcd(b,a);
    else:
        return rgcd(b,a%b);
                    
