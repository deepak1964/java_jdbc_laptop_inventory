package product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class inventory {
private List<shop> products;
public inventory() {
this.products = new ArrayList<>();
    }
public void addProduct(shop product) {
//products.add(product);
	Statement stmt;
	ResultSet rs;
	String qry=null;
	dbutil db=new dbutil();
	boolean sts=false;
	try
	{
		Connection con=db.getDBConnection();
		stmt=con.createStatement();
	    int count=stmt.executeUpdate("insert into laptop(id,brand,name,price,reviews) values('"+product.getId()+"','"+product.getBrand()+"','"+product.getName()+"','"+product.getPrice()+"','"+product.getReviews()+"')");
		System.out.println("INSERTED SUCCESFULLY");
    }
	catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	}
}
public void updateProduct(shop cs) {
/*if (index >= 0 && index <products.size()) {
products.set(index, updatedProduct);
        } else {
System.out.println("Invalid index. No product updated.");
        }
    }*/
	Statement stmt;
	ResultSet rs;
	String qry=null;
	dbutil db=new dbutil();
	boolean sts=false;
	try {
		Connection con=db.getDBConnection();
		con=db.getDBConnection();
		stmt=con.createStatement();
		int count = stmt.executeUpdate("UPDATE laptop SET name='" + cs.getName() + "', price=" + cs.getPrice() + " WHERE id=" + cs.getId());
		System.out.println("UPDATED SUCCESSFULLY");

	  }
	catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	}
}
	
public void removeProduct(int shopidupdate) {
/*if (index >= 0 && index <products.size()) {
products.remove(index);
        } else {
System.out.println("Invalid index. No product removed.");
        }
    }*/
	Statement stmt;
	ResultSet rs;
	String qry=null;
	dbutil db=new dbutil();
	boolean sts=false;
	try
	{
		Connection con=db.getDBConnection();
		con=db.getDBConnection();
		stmt=con.createStatement();
		int count=stmt.executeUpdate("DELETE from laptop WHERE id="+shopidupdate);
	}
	catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	}
}
	
	
public shop findBrand(String brand) {
for (shop product : products) {
if (product.getBrand() == brand) {
return product;
            }
        }
return null; 
    }
public void showAllProducts()
{
	Statement stmt;
	ResultSet rs;
	String qry=null;
	dbutil db=new dbutil();
	Connection con;
	try
	{
		con=db.getDBConnection();
		stmt=con.createStatement();
		rs=stmt.executeQuery("select * from laptop");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getInt(4)+"    "+rs.getString(5));
			
		}
	}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
/*{
for (cars product : products) {
System.out.println(product);
        }
    }*/
public List<shop>getProducts() {
return products;
    }
public List<shop> getBrand() {
	// TODO Auto-generated method stub
	return null;
}
}