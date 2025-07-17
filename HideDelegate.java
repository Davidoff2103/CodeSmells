class City {
    /**
     * Represents a city with a name.
     *
     * @param name The name of the city.
     */
    private String name;

    /**
     * Constructs a new City instance with the specified name.
     *
     * @param name The name of the city.
     */
    public City(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the city.
     *
     * @return The name of the city.
     */
    public String getName() {
        return name;
    }
}

class Address {
    /**
     * Represents an address with a city and street.
     *
     * @param city The city associated with this address.
     * @param street The street of the address.
     */
    private City city;
    private String street;

    /**
     * Constructs a new Address instance with the specified city and street.
     *
     * @param city The city associated with this address.
     * @param street The street of the address.
     */
    public Address(City city, String street) {
        this.city = city;
        this.street = street;
    }

    /**
     * Retrieves the city associated with this address.
     *
     * @return The city object.
     */
    public City getCity() {
        return city;
    }

    /**
     * Retrieves the street of the address.
     *
     * @return The street name.
     */
    public String getStreet() {
        return street;
    }
}

class Customer {
    /**
     * Represents a customer with an address and name.
     *
     * @param address The address of the customer.
     * @param name The name of the customer.
     */
    private Address address;
    private String name;

    /**
     * Constructs a new Customer instance with the specified address and name.
     *
     * @param address The address of the customer.
     * @param name The name of the customer.
     */
    public Customer(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    /**
     * Retrieves the address of the customer.
     *
     * @return The address object.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Retrieves the name of the customer.
     *
     * @return The customer's name.
     */
    public String getCustomerName() {
        return name;
    }
}

class Order {
    /**
     * Represents an order with a customer and an ID.
     *
     * @param id The unique identifier of the order.
     * @param customer The customer associated with this order.
     */
    private Customer customer;
    private int id;

    /**
     * Constructs a new Order instance with the specified ID and customer.
     *
     * @param id The unique identifier of the order.
     * @param customer The customer associated with this order.
     */
    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    /**
     * Retrieves the ID of the order.
     *
     * @return The order's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the customer associated with this order.
     *
     * @return The customer object.
     */
    public Customer getCustomer() {
        return customer;
    }
}

/**
 * Demonstrates the Hide Delegate design pattern by encapsulating access to city information through methods.
 */
public class HideDelegate {
    public static void main(String[] args) {
        // Creating instances of objects
        City city = new City("Lleida");
        Address address = new Address(city, "c/Jaume II");
        Customer customer = new Customer(address, "David");
        Order order = new Order(1, customer);

        // Access to the city through encapsulated method
        System.out.println("Ciutat del client: " + order.getCustomer().getAddress().getCity().getName());

        // Access to the complete address through encapsulated method
        System.out.println("Adreça completa del client: " + order.getCustomer().getAddress().getStreet() + ", " +
                order.getCustomer().getAddress().getCity().getName());
    }
}