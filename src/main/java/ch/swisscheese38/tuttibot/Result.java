package ch.swisscheese38.tuttibot;

public class Result {

    private String itemId;
    private String title;
    private int price;

    public Result(String itemId, String title, int price) {
        this.itemId = itemId;
        this.title = title;
        this.price = price;
    }
    
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

}
