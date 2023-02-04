public class SalesReceipt1Factory extends AbstractReceiptFactory{
    @Override
    public Receipt getReceipt(){
        return new Receipt1();
    }
    @Override
    public Header getHeader(){
        return new Header1();
    }
    @Override
    public Footer getFooter(){
        return new Footer1();
    }
}
