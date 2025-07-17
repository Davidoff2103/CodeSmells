class City2 {
    private String name;

    public City2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Address2 {
    private City2 city;
    private String street;

    public Address2(City2 city, String street) {
        this.city = city;
        this.street = street;
    }

    public City2 getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }
}

class Customer2 {
    private Address2 address;
    private String name;

    public Customer2(Address2 address, String name) {
        this.address = address;
        this.name = name;
    }

    public Address2 getAddress() {
        return address;
    }

    public String getCustomerName() {
        return name;
    }
}

class Order2 {
    private Customer2 customer;
    private int id;

    public Order2(int id, Customer2 customer) {
        this.id = id;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    // Aplicació de Hide Delegate per obtenir el nom de la ciutat directament
    public String getCustomerCityName() {
        return customer.getAddress().getCity().getName();
    }

    // Aplicació de Hide Delegate per obtenir l'adreça completa (carrer i ciutat)
    public String getCustomerCompleteAddress() {
        return customer.getAddress().getStreet() + ", " +
                customer.getAddress().getCity().getName();
    }
}

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
