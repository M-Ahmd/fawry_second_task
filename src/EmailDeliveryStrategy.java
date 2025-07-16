public class EmailDeliveryStrategy implements EmailDeliverable {
    @Override
    public void deliverToEmail(String email) {
        System.out.println("Sent to email: " + email);
        MailService.sendMail(email);
    }
}