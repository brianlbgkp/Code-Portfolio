# Problem 11 (8.34)
# Stat as a subclass of object
class Stat(object):
    'container for numbers that supports statistical methods'

    # do your work here
    def __init__(self):
        self.nums = [];

    def add(self, num):
        self.nums.append(num);

    def min(self):
        return min(self.nums);

    def max(self):
        return max(self.nums);

    def __len__(self):
        return len(self.nums);

    def mean(self):
        return self.sum() / len(self.nums);

    def __contains__(self,num):
        return num in s.nums;

    def sum(self):
        total=0;
        for i in self.nums:
            total+=i;
        return total;

    def clear(self):
        s.nums = [];

# Stat as a subclass of list
class Stat2(list):
    'container for numbers that supports statistical methods'

    # do your work here
    def __init__(self, liste):
        list.__init__(self, liste);



# Problem 2

# do your work here

class Cursor(int):

    def __init__(self):
       self.loc = 0;

    def next(self):
        self.loc+= 1;

    def prev(self):
        self.loc+= -1;
        if self.loc < 0:
            raise NegativeCursorError

    def curr(self):
        return self.loc;

class NegativeCursorError(Exception):
    pass
