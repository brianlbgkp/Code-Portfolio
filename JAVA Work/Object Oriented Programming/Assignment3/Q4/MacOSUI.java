public class MacOSUI extends UserInterface {
    public TextField createTextField() { return new MacOSTextField(); }
    public PushButton createPushButton() { return new MacOSPushButton(); }
    public ListBox createListBox() { return new MacOSListBox(); }
}
