package CS201_AS2_;

class Product {
    private String bcode, title;
    private int quantity; 
    private double price;
    public Product() {}
    public Product(String a, String b, int c, double d) {
        bcode = a;
        title = b;
        quantity = c;
        price = d;
    }
    public Product(String a) {
        bcode = a;
    }
    public String getbCode() {return this.bcode;}
    public void setbCode(String a) {this.bcode = a;}
    public int getQuantity() {return this.quantity;}
    @Override
    public String toString() {
        return (this.bcode + " | " + this.title+ " | " + this.quantity + " | " + this.price );
    }
}
