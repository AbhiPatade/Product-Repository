
package java_project_1_2;


public class Product {
    private int id;
    private String name;
    private float price;
    private String addDate;
    private byte[] picture;
    
    public Product(int pid,String pname,float pprice,String pAdddate,byte[] pimg)
    {
        this.id=pid;
        this.name=pname;
        this.price=pprice;
        this.addDate=pAdddate;
        this.picture=pimg;
    }

    Product(int aInt, String string, float parseFloat, String string0, byte aByte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
    return name;
    }
    
    public float getPrice()
    {
        return price;
    }
    
    public String getAdddate()
    {
        return addDate;
    }
    
    public byte[] getImage()
    {
        return picture;
    }
}
