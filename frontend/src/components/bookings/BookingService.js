import {BOOKING_CALCULATE_TOTAL_PRICE_ENDPOINT, CREATE_BOOKING_ENDPOINT} from "@/config";

class BookingService{
    async calculateTotalPrice(startDate, endDate, pricePerDay, discountId){
        const response = await fetch(BOOKING_CALCULATE_TOTAL_PRICE_ENDPOINT, {
            method: 'POST',
            headers:{
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                startDate,
                endDate,
                pricePerDay,
                discountId
            })
        })
        if(!response.ok){
            throw new Error('Failed to calculate TOTAL PRICE!')
        }
        else{
            return await response.json();
        }
    }
    async saveBooking(yacht, startDate, endDate, totalPrice, status, discountId){
        const response = await fetch(CREATE_BOOKING_ENDPOINT,{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                yacht: yacht,
                startDate: startDate,
                endDate: endDate,
                totalPrice: totalPrice,
                status: status,
                discountId: discountId
            })

        })
        if(!response.ok){
            throw new Error('Failed to create a booking!')
        }
        else{
            return await response.json();
        }

    }
}
export default new BookingService