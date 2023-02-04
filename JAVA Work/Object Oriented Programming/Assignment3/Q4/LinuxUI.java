public class LinuxUI extends UserInterface {
    public TextField createTextField() { return new LinuxTextField(); }
    public PushButton createPushButton() { return new LinuxPushButton(); }
    public ListBox createListBox() { return new LinuxListBox(); }
}
