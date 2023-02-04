public class ApplicationSalesReceipt {
    public static void main(String[] args) {
        System.out.println("Printing out Receipt 1");

        String userInput = "Receipt1";
        if(userInput.equalsIgnoreCase("RECEIPT1")){
            AbstractReceiptFactory receiptFactory = new SalesReceipt1Factory();
            Header salesHeader = receiptFactory.getHeader();
            Receipt salesReceipt = receiptFactory.getReceipt();
            Footer salesFooter = receiptFactory.getFooter();
            salesHeader.getHeader();
            salesReceipt.getReceipt();
            salesFooter.getFooter();
        } else if(userInput.equalsIgnoreCase("RECEIPT2")){
            AbstractReceiptFactory receiptFactory = new SalesReceipt2Factory();
            Header salesHeader = receiptFactory.getHeader();
            Receipt salesReceipt = receiptFactory.getReceipt();
            Footer salesFooter = receiptFactory.getFooter();
            salesHeader.getHeader();
            salesReceipt.getReceipt();
            salesFooter.getFooter();
        } else {
            System.out.println("Invalid Receipt Type");
        }

    }
}
