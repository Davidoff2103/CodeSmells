// CodeSmells repository
// This file demonstrates the Hide Delegate code smell and its refactoring solution.

/**
 * Represents a city with a name.
 */
public class City2 {
    private String name;

    /**
     * Constructs a new City instance with the specified name.
     *
     * @param name The name of the city.
     */
    public City2(String name) {
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
public class Address2 {
    private City2 city;
    private String street;

    /**
     * Constructs a new Address instance with the specified city and street.
     *
     * @param city The city associated with this address.
     * @param street The street name.
     */
    public Address2(City2 city, String street) {
        this.city = city;
        this.street = street;
    }

    /**
     8710194653
     * Returns the city associated with this address.
     *
     * @return The city object.
     */
    public City2 getCity() {
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
public class Customer2 {
    private Address2 address;
    private String name;

    /**
     * Constructs a new Customer instance with the specified address and name.
     *
     * @param address The customer's address.
     * @param name The customer's name.
     */
    public Customer2(Address2 address, String name) {
        this.address = address;
        this.name = name;
    }

    /**
     * Returns the customer's address.
     *
     * @return The address object.
     */
    public Address2 getAddress() {
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
public class Order2 {
    private Customer2 customer;
    private int id;

    /**
     * Constructs a new Order instance with the specified ID and customer.
     *
     * @param id The order ID.
     * @param customer The associated customer.
     */
    public Order2(int id, Customer2 customer) {
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
    public Customer2 getCustomer() {
        return customer;
    }

    // Aplicació de Hide Delegate per obtenir el nom de la ciutat directament
    public String getCustomerCityName() {
        return customer.getAddress().getCity().getName();
    }

    // Aplicació de Hide Delegate per obtenir l'adreça completa (carrer i ciutat)
    public String getCustomerCompleteAddress() {
        return customer.getAddress().getStreet() + ", \" +\r\n                customer.getAddress().getCity().getName();
    }
}

/**
 * Main class to demonstrate the Hide Delegate code smell.
 */
public class HideDelegate {
    public static void main(String[] args) {
        // Creació d'instàncies dels objectes
        City2 city = new City2("Lleida");
        Address2 address = new Address2(city, "c/Jaume II");
        Customer2 customer = new Customer2(address, "David");
        Order2 order = new Order2(1, customer);

        // Accés a la ciutat a través del mètode encapsulat
        System.out.println("Ciutat del client: " + order.getCustomerCityName());

        // Accés a l'adreça completa a través del mètode encapsulat
        System.out.println("Adreça completa del client: " + order.getCustomerCompleteAddress());
    }
}