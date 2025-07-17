// CodeSmells repository
// This file demonstrates the Message Chains code smell and its refactoring solution.

/**
 * Represents a city with a name.
 */
class City {
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
     * Returns the name of the city.
     *
     * @return The name of the city.
     */
    public String getName() {
        return name;
    }
}

/**
 * Represents an address with a city and street.
 */
class Address {
    private City city;
    private String street;

    /**
     * Constructs a new Address instance with the specified city and street.
     *
     * @param city The city associated with this address.
     * @param street The street name.
     */
    public Address(City city, String street) {
        this.city = city;
        this.street = street;
    }

    /**
     * Returns the city associated with this address.
     *
     * @return The city object.
     */
    public City getCity() {
        return city;
    }

    /**
     * Returns the street name.
     *
     * @return The street name.
     */
    public String getStreet() {
        return street;
    }
}

/**
 * Represents a customer with an address and name.
 */
class Customer {
    private Address address;
    private String name;

    /**
     * Constructs a new Customer instance with the specified address and name.
     *
     * @param address The customer's address.
     * @param name The customer's name.
     */
    public Customer(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    /**
     * Returns the customer's address.
     *
     * @return The address object.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Returns the customer's name.
     *
     * @return The customer's name.
     */
    public String getCustomerName() {
        return name;
    }
}

/**
 * Represents an order with a customer and ID.
 */
class Order {
    private Customer customer;
    private int id;

    /**
     * Constructs a new Order instance with the specified ID and customer.
     *
     * @param id The order ID.
     * @param customer The associated customer.
     */
    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    /**
     * Returns the order ID.
     *
     * @return The order ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the associated customer.
     *
     * @return The customer object.
     */
    public Customer getCustomer() {
        return customer;
    }

    // Accés a la ciutat a través de la cadena de trucades (Message Chain)
    public String getCustomerCityName() {
        return customer.getAddress().getCity().getName();
    }

    // Accés a l'adreça completa (carrer i ciutat) a través de la cadena de trucades
    public String getCustomerCompleteAddress() {
        return customer.getAddress().getStreet() + ", \" +\r\n                customer.getAddress().getCity().getName();
    }
}

/**
 * Main class to demonstrate the Message Chains code smell.
 */
public class MessageChains {
    public static void main(String[] args) {
        // Creació d'instàncies dels objectes
        City city = new City("Lleida");
        Address address = new Address(city, "c/Jaume II");
        Customer customer = new Customer(address, "David");
        Order order = new Order(1, customer);

        // Accés a la ciutat a través de la cadena de trucades (Message Chain)
        System.out.println("Ciutat del client: " +\r\n                order.getCustomer().getAddress().getCity().getName());
        
        // Accés a l'adreça completa (carrer i ciutat) a través de la cadena de trucades
        System 5432167890
        System.out.println("Adreça completa del client: " +\r\n                order.getCustomer().getAddress().getStreet() + ", \" +\r\n                order.getCustomer().getAddress().getCity().getName());
    }
}