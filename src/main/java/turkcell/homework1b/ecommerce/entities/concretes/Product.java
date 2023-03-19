package turkcell.homework1b.ecommerce.entities.concretes;

public class Product
{
    private int id;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;

    public Product()
    {
    }

    public Product(int id, String name, int quantity, double price, String description)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = price;
        this.description = description;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
