# Problem 1
class Vehicle(object):
    # implement this
    def __init__(self):
        self.cargo = [];

    def add_cargo(self,item):
        self.cargo.append(item);

    def cargo_contents(self):
        return self.cargo;

    def deliver(self):
        return self.cargo.pop();
        #return dropped;



# Problem 2
class Sled(Vehicle):
    # implement this
    def __init__(self,cordX,cordY):
        Vehicle.__init__(self)
        self.x = cordX;
        self.y = cordY;


    def move(self,mX, mY):
        self.x = self.x + mX;
        self.y = self.y + mY;

    def __str__(self):
        return 'Gifts being delivered at location (' +str(self.x)+ ','+str(self.y) + ')'


# Problem 3
from random import sample
from tkinter import Tk,Frame,Entry,Button,LEFT,RIGHT,END
class Lottery(Frame):
    # implement this
    def __init__(self,master):
        Frame.__init__(self,master)
        self.pack()

        self.ent = Entry(self)
        self.ent.grid(row=0,column=0)
        
        button = Button(self, text='Select',command=self.select)
        button.grid(row=0,column=1,columnspan=3)

    def select(self):
        lst = sample(range(1,61),6);
        self.ent.delete(0,END);
        self.ent.insert(0,lst);
        
    
root = Tk()
l = Lottery(root)
l.pack()
root.mainloop()
