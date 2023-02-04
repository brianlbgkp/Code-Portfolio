# Problem 1
def posProd(lst):
    #newLst = sort(lst);
    for item in lst:
        if item <= 0:
            lst.remove(item);
    if len(lst) == 0:
        return 1;
    return lst[-1]*posProd(lst[:-1]);
    



# Problem 2
from os import listdir
from os.path import isfile, join, getsize
def dirSize(pathname):
    if isfile(pathname):
        return getsize(pathname);
    size = 0;
    for item in listdir(pathname):
        size += dirSize(join(pathname,item))
    return size;



# Problem 3
from re import findall
def test(filename):
    infile = open(filename)
    text = infile.read()
    infile.close()
    print('\n')
    print("Exercise i: words that start with string 'inter' or 'Inter'")
    print(list(set(findall('[.\s][iI]nter[\w]*',text))))
    print('\n')
    print("Exercise ii: sentences that contain the word 'corpse'")
    print(list(set(findall('[^.\!\?]*corpse[^.\!\?]*',text))))
    print('\n')
    print("Exercise iii: words that contain the string 'death' as a substring and end with 'e'")
    print(list(set(findall('[\w]*death[\w]*e[^\w]',text))))



# Problem 4
# WRITE YOUR IMPLEMENTATION HERE
from urllib.parse import urljoin
from html.parser import HTMLParser
class Collector(HTMLParser):


    def __init__(self, url):
        HTMLParser.__init__(self)
        self.url = url
        self.links = {url:0}
        self.numLinks = []
        self.count = 0;
        
    def handle_starttag(self, tag, attrs):
        if tag == 'a':
            for attr in attrs:
                if attr[0] == 'href':
                    absolute = urljoin(self.url, attr[1])
                    if absolute[:4] == 'http':
                        self.numLinks.append(absolute)
                        self.count = len(self.numLinks);
                        #self.links.__setitem__(self.url,self.count)

    def getLinks(self):
        self.links.__setitem__(self.url,count)
        return str(self.links.values())

from urllib.request import urlopen
def search(url):
    if 1 ==1:
        return
    content = urlopen(url).read().decode()
    collector = Collector(url)
    collector.feed(content)
    for link in collector.numLinks:
        try:
            search(link)
        except:
            pass
