public class User {
    public static void main(String[] args){
        UserInterface ui = null;

        String OS = "MS-Windows"; // simulated user input

        if(OS.equals("MS-Windows")) {
            System.out.println("Microsoft Windows Operating System Selected");
            ui = new MSWindowsUI();
        } else if (OS.equals("Mac OS")) {
            System.out.println("Mac OS Operating System Selected");
            ui = new MacOSUI();
        } else if (OS.equals("Linux")) {
            System.out.println("Linux Operating System Selected");
            ui = new LinuxUI();
        } else {
            System.out.println("Invalid Operating System Selected");
        }

        ListBox osListBox = ui.createListBox();
        TextField osTextField = ui.createTextField();
        PushButton osPushButton = ui.createPushButton();

        System.out.println("Widget List for " + OS + " Operating System");
        System.out.println(osListBox.getListBox());
        System.out.println(osTextField.getTextField());
        System.out.println(osPushButton.getPushButton());

    }
}
