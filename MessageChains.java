class City {
    private String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Address {
    private City city;
    private String street;

    public Address(City city, String street) {
        this.city = city;
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }
}

class Customer {
    private Address address;
    private String name;

    public Customer(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public String getCustomerName() {
        return name;
    }
}

class Order {
    private Customer customer;
    private int id;

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }
}

public class MessageChains {
    public static void main(String[] args) {
        // Creació d'instàncies dels objectes
        City city = new City("Lleida");
        Address address = new Address(city, "c/Jaume II");
        Customer customer = new Customer(address, "David");
        Order order = new Order(1, customer);

        // Accés a la ciutat a través de la cadena de trucades (Message Chain)
        System.out.println("Ciutat del client: " +
                order.getCustomer().getAddress().getCity().getName());
        System.out.println("Adreça completa del client: " +
                order.getCustomer().getAddress().getStreet() + ", " +
                order.getCustomer().getAddress().getCity().getName());

    }
}
