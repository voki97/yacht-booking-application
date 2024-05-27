export default class Booking {
    constructor(bookingId, yacht, bookingDate, startDate, endDate, totalPrice, status, discounts) {
        this.bookingId = bookingId;
        this.yacht = yacht;
        this.bookingDate = bookingDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.status = status;
        this.discounts = discounts;
    }
}