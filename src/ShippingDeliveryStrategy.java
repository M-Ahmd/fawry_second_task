public class ShippingDeliveryStrategy implements ShippingDeliverable {
    @Override
    public void deliverToAddress(String address) {
        System.out.println("Shipped to: " + address);
        ShippingService.shipping(address);
    }
}