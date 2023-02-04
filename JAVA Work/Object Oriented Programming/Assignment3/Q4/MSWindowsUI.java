public class MSWindowsUI extends UserInterface {
    public TextField createTextField() { return new MSWindowsTextField(); }
    public PushButton createPushButton() { return new MSWindowsPushButton(); }
    public ListBox createListBox() { return new MSWindowsListBox(); }
}
