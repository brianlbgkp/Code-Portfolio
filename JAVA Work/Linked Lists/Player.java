public class Player {
    public int numPlayers;
    public int index = 0;

    private seLinkList minWeight = null;
    private seLinkList maxWeight = null;

    seLinkList head;

    Player(){
        this.numPlayers = 0;
        head = null;
    }

    Player(seLinkList min, seLinkList max){
        this.minWeight = min;
        this.maxWeight = max;
    }

    public void addPlayer(int a, int b, int c){
        seLinkList newPlayer = new seLinkList(this.index,a,b,c);
        this.index++;
        this.numPlayers++;
        if(head == null){
            head = newPlayer;
        } else {
            seLinkList current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newPlayer;
            newPlayer.prev = current;
        }
    }

    public void initializeList(PlayerData pData){
        PlayerData[] list = pData.getMyData();

        for(int i = 0; i < list.length; i++){
            int a = list[i].getA();
            int b = list[i].getB();
            int c = list[i].getC();

            this.addPlayer(a, b, c);
        }

    }

    public seLinkList findMaxWeight(){
        int maxWeight = 0;
        seLinkList maxNode = this.head;

        seLinkList current = this.head;
        while(current != null){
            int weight = current.a + current.b + current.c;

            if(weight >= maxWeight){
                maxWeight = weight;
                maxNode = current;
            }
            current = current.next;
        }

        //System.out.println("Max weight: " + maxWeight);
        return maxNode;
    }

    public seLinkList findMinWeight(){
        seLinkList current = this.head;
        seLinkList minNode = this.head;

        int minWeight = current.a + current.b + current.c;

        while(current != null){
            int weight = current.a + current.b + current.c;

            if(weight <= minWeight){
                minWeight = weight;
                minNode = current;
            }
            current = current.next;
        }

        //System.out.println("Min weight: " + minWeight);
        return minNode;
    }




    public Player findMinMaxWeight(){
        seLinkList current = this.head;
        seLinkList minNode = this.head;
        seLinkList maxNode = this.head;

        int minWeight = current.a + current.b + current.c;
        int maxWeight = current.a + current.b + current.c;

        while(current != null){
            int weight = current.a + current.b + current.c;

            if(weight <= minWeight){
                minWeight = weight;
                minNode = current;
            }

            if(weight >= maxWeight){
                maxWeight = weight;
                maxNode = current;
            }
            current = current.next;
        }

        //System.out.println("Min weight: " + minWeight);

        /* can set min and max like this and turn the method to be void then use getters

        this.minWeight = minNode;
        this.maxWeight = maxNode;


         */

        //Or as implemented the method returns Player class with min and max baked in

        return new Player(minNode, maxNode);
    }

    public seLinkList getMin(){
        return minWeight;
    }

    public seLinkList getMax(){
        return maxWeight;
    }

    public void removeNode(int num){
        if(num >= numPlayers){return;} //Does nothing if index is out of bounds
        seLinkList current = this.head;

        while(current.getIndex() != num){
            current = current.next;
        }

        if(current.getIndex() == num) {
            if(current.prev != null) {
                if(current.next != null) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                } else {
                    current.prev.next = null;
                }
            } else {
                head = current.next;
            }
        }

        current = current.next;
        while (current != null){
            current.index = current.index - 1;
            current = current.next;
        }
    }



    public static void main(String[] args){

        /*

        TESTING CODE
        Player player = new Player();

        System.out.println(player.numPlayers);

        //Test PlayerData integration

        PlayerData playerData = new PlayerData();

        PlayerData[] myData = playerData.getMyData();

        System.out.println(myData);

        //Test seLinkList integration

        player.addPlayer(1,2,3);

        player.addPlayer(4,5,6);


        player.initializeList(playerData);

        seLinkList max = player.findMaxWeight();
        seLinkList min = player.findMinWeight();

        System.out.println("Max weight node: " + max);
        System.out.println("Min weight node: " + min);

        Player minMax = player.findMinMaxWeight();

        System.out.println("Max weight node: " + minMax.getMax() + " Min weight node: " + minMax.getMin());

        seLinkList current = player.head;
        while(current != null){
            System.out.println(current);
            current = current.next;
        }


        player.removeNode(49);

        seLinkList newCurrent = player.head;
        while(newCurrent != null){
            System.out.println(newCurrent);
            newCurrent = newCurrent.next;
        }

         */

        System.out.println("[Brian Salinas - GIT Assignment 2]");

        Player player = new Player();

        PlayerData playerData = new PlayerData();

        player.initializeList(playerData);

        for(int i = 0; i < 3; i++) {

            Player minMax = player.findMinMaxWeight();

            seLinkList max = minMax.getMax();
            seLinkList min = minMax.getMin();

            System.out.println("Max weight node: " + max + " Min weight node: " + min);

            player.removeNode(max.getIndex());
            player.removeNode(min.getIndex());
        }

        System.out.println("[DONE!]");

    }
}
