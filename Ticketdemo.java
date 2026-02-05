class Ticket
{
    int TicketID;
    int no_of_seats;
    String date;
    double fare;

    static int total_tickets_booked=0;
    void  ticketbook(int no_of_seats,String date,double fare,int TicketID) {
        this.no_of_seats = no_of_seats;
        this.date = date;
        this.fare = fare;
        this.TicketID = TicketID;
        if (total_tickets_booked > no_of_seats) {
            total_tickets_booked += no_of_seats;
        }
    }

    double amount(){
        return this.fare*no_of_seats;
    }
    void show()
    {
        System.out.println("Ticketid is"+TicketID);
        System.out.println("date is"+date);
        System.out.println("total tickets "+total_tickets_booked);

    }


}
class Ticketdemo
{
    public static void main(String[] args) {
        Ticket obj=new Ticket();
        obj.ticketbook(2,"7-11-24",172.0,23000);
        obj.amount();

        obj.show();
    }
}