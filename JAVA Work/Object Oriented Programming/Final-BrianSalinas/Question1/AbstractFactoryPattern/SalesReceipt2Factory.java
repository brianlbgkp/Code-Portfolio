public class SalesReceipt2Factory extends AbstractReceiptFactory{
    @Override
    public Receipt getReceipt(){
        return new Receipt2();
    }
    @Override
    public Header getHeader(){
        return new Header2();
    }
    @Override
    public Footer getFooter(){
        return new Footer2();
    }
}
