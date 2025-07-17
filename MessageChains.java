class City {
    /**
     * Represents a city with a name.
     */
    private String name;

    /**
     * Constructor to initialize the city with a name.
     * @param name The name of the city.
     */
    public City(String name) {
        this.name = name;
    }

    /**
     * Retrieves the city's name.
     * @return The name of the city.
     */
    public String getName() {
        return name;
    }
}

class Address {
    /**
     * Represents an address with a city and street.
     */
    private City city;
    private String street;

    /**
     * Constructor to initialize the address with a city and street.
     * @param city The associated city.
     * @param street The street name.
     */
    public Address(City city, String street) {
        this.city = city;
        this.street = street;
    }

    /**
     * Retrieves the city associated with this address.
     * @return The city object.
     */
    public City getCity() {
        return city;
    }

    /**
     * Retrieves the street name.
     * @return The street name.
     */
    public String getStreet() {
        return street;
    }
}

class Customer {
    /**
     * Represents a customer with an address and name.
     */
    private Address address;
    private String name;

    /**
     * Constructor to initialize the customer with an address and name.
     * @param address The customer's address.
     * @param name The customer's name.
     */
    public Customer(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    /**
     * Retrieves the customer's address.
     * @return The address object.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Retrieves the customer's name.
     * @return The customer's name.
     */
    public String getCustomerName() {
        return name;
    }
}

class Order {
    /**
     * Represents an order with a customer and ID.
     */
    private Customer customer;
    private int id;

    /**
     * Constructor to initialize the order with an ID and customer.
     * @param id The order's unique identifier.
     * @param customer The associated customer.
     */
    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    /**
     * Retrieves the order's ID.
     * @return The order ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the customer associated with this order.
     * @return The customer object.
     */
    public Customer getCustomer() {
        return customer;
    }

    // Accés a la ciutat a través de la cadena de trucades (Message Chain)
    /**
     * Gets the city name of the customer through message chaining.
     * @return The city name as a String.
     */
    public String getCustomerCityName() {
        return customer.getAddress().getCity().getName();
    }

    // Accés a l'adreça completa (carrer i ciutat) a través de la cadena de trucades
    /**
     * Gets the complete address of the customer.
     * @return The full address as a String.
     */
    public String getCustomerCompleteAddress() {
        return customer.getAddress().getStreet() + ", " +
                customer.getAddress().getCity().getName();
    }
}

public class MessageChains {
    /**
     * Main method to demonstrate the message chain refactoring.
     */
    public static void main(String[] args) {
        // Creació d'instàncies dels objectes
        City city = new City("Lleida");
        Address address = new Address(city, "c/Jaume II");
        Customer customer = new Customer(address, "David");
        Order order = new Order(1, customer);

        // Accés a la ciutat a través de la cadena de trucades (Message Chain)
        System.out.println("Ciutat del client: " +
                order.getCustomer().getAddress().getCity().getName());
        
        // Accés a l'adreça completa a través de la cadena de trucades
        System.out.println("Adreça completa del client: " +
                order.getCustomer().getAddress().getStreet() + ", " +
                order.getCustomer().getAddress().getCity().getName());
    }
}