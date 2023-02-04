public class seLinkList {
    seLinkList prev;
    seLinkList next;

    int index;

    int a;
    int b;
    int c;


    public seLinkList(int index, int a, int b, int c){
        this.index = index;
        this.a = a;
        this.b = b;
        this.c = c;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "seLinkList{" +
                "index=" + index +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public int getIndex() {
        return index;
    }

    public static void main(String[] args){
        seLinkList sll = new seLinkList(0,1,2,3);

        System.out.println(sll);

    }

}
