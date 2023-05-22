package mysqlconnection;

public class Queries extends MySql{


    public String customerQuery(String selectValue, String whereValue, String cellValue)  {
        return "SELECT " + selectValue + " FROM prestashop.customer WHERE " + whereValue + " = '" + cellValue + "'";
    }

    public String deleteAddress(String address)  {
        return "DELETE FROM prestashop.address WHERE address1 = '" + address + "'";
    }

    public String deleteCustomer(String lastname)  {
        return "DELETE FROM prestashop.customer WHERE lastname = '" + lastname + "'";
    }

    public String deleteWishlist(String wishlist)  {
        return "DELETE FROM prestashop.wishlist WHERE name = '" + wishlist + "'";
    }

}
