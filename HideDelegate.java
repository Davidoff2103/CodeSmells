class City2 {
    /**
     * Represents a city with a name.
     */
    private String name;

    /**
     * Constructor to initialize the city with a name.
     * @param name The name of the city.
     */
    public City2(String name) {
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

class Address2 {
    /**
     * Represents an address with a city and street.
     */
    private City2 city;
    private String street;

    /**
     * Constructor to initialize the address with a city and street.
     * @param city The associated city.
     * @param street The street name.
     */
    public Address2(City2 city, String street) {
        this.city = city;
        this.street = street;
    }

    /**
     * Retrieves the city associated with this address.
     * @return The city object.
     */
    public City2 getCity() {
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

class Customer2 {
    /**
     * Represents a customer with an address and name.
     */
    private Address2 address;
    private String name;

    /**
     * Constructor to initialize the customer with an address and name.
     * @param address The customer's address.
     * @param name The customer's name.
     */
    public Customer2(Address2 address, String name) {
        this.address = address;
        this.name = name;
    }

    /**
     * Retrieves the customer's address.
     * @return The address object.
     */
    public Address2 getAddress() {
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

class Order2 {
    /**
     * Represents an order with a customer and ID.
     */
    private Customer2 customer;
    private int id;

    /**
     * Constructor to initialize the order with an ID and customer.
     * @param id The order's unique identifier.
     * @param customer The associated customer.
     */
    public Order2(int id, Customer2 customer) {
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
    public Customer2 getCustomer() {
        return customer;
    }

    // Aplicació de Hide Delegate per obtenir el nom de la ciutat directament
    /**
     * Gets the city name of the customer through encapsulation.
     * @return The city name as a String.
     */
    public String getCustomerCityName() {
        return customer.getAddress().getCity().getName();
    }

    // Aplicació de Hide Delegate per obtenir l'adreça completa (carrer i ciutat)
    /**
     * Gets the complete address of the customer.
     * @return The full address as a String.
     */
    public String getCustomerCompleteAddress() {
        return customer.getAddress().getStreet() + ", " +
                customer.getAddress().getCity().getName();
    }
}

public class HideDelegate {
    /**
     * Main method to demonstrate the Hide Delegate refactoring.
     */
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